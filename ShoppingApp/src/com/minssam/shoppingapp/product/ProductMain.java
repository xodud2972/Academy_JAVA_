package com.minssam.shoppingapp.product;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.minssam.shoppingapp.main.AppMain;
import com.minssam.shoppingapp.main.Page;
import com.minssam.shoppingapp.model.domain.Subcategory;
import com.minssam.shoppingapp.model.domain.Topcategory;
import com.minssam.shoppingapp.util.FileManager;

//상품관리 메인 페이지
public class ProductMain extends Page{
	//서쪽관련
	JPanel p_west;
	Choice ch_top;
	Choice ch_sub;
	JTextField t_product_name;
	JTextField t_price;
	JTextField t_brand;
	JTextArea t_detail;
	JScrollPane scroll;
	JButton bt_web; //웹에서 가져오기
	JButton bt_file; //로컬 파일에서 가져오기
	Canvas can;
	JButton bt_regist;
	
	//Choice 컴포넌트는 html의 option  과 달리 텍스트,value 값을 동시에 담을 수 없다..
	//따라서 우리가 이 부분을 복합 데이터 형태로 직접 만들어서 해결해보자!!
	ArrayList<Topcategory> topList=new ArrayList<Topcategory>(); //size 0 즉 아무것도 채워진게 없다
	ArrayList<Subcategory> subList=new ArrayList<Subcategory>();
	
	//센터관련 
	JPanel p_center;
	JPanel p_search; //검색 컴포넌트들 올려놓을 패널 
	Choice ch_category;//검색 카테고리 선택
	JTextField t_keyword;//검색어 입력
	JButton bt_search; 
	JButton bt_excel; //엑셀을 이용한 일괄등록
	
	JTable table;
	JScrollPane scroll_table;
	
	//동쪽관련
	JPanel p_east;
	Choice ch_top2;
	Choice ch_sub2;
	JTextField t_product_name2;
	JTextField t_price2;
	JTextField t_brand2;
	JTextArea t_detail2;
	JScrollPane scroll2;
	JButton bt_web2; //웹에서 가져오기
	JButton bt_file2; //로컬 파일에서 가져오기
	Canvas can2;
	JButton bt_regist2;
	
	JFileChooser chooser;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image image; //등록시 미리보기에 사용할 이미지
	String filename; //유저의 복사에 의해 생성된 파일명!!!
	
	String[] columns={"product_id", "subcategory_id","product_name","price","brand","detail","filename"};//컬럼배열 
	String[][] records={};//레코드배열
	
	public ProductMain(AppMain appMain) {
		super(appMain);
		setBackground(Color.YELLOW);
		
		//서쪽 영역 생성 
		p_west= new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_product_name = new JTextField();
		t_price = new JTextField();
		t_brand = new JTextField();
		t_detail = new JTextArea();
		scroll = new JScrollPane(t_detail);
		bt_web = new JButton("웹에서찾기");
		bt_file = new JButton("파일찾기");
		can = new Canvas() {
			//내부익명 클래스는 외부클래스의 멤버(변수,메서드)들을 내것처럼 접근 가능!!
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 180, 180, can);	
			}
		};
		
		bt_regist = new JButton("상품등록");
		
		//센터 영역 생성 
		p_center = new JPanel();
		p_search = new JPanel();
		ch_category = new Choice();
		
		//검색 카테고리 등록
		ch_category.add("choose category");
		ch_category.add("product_name");
		ch_category.add("price");
		ch_category.add("brand");
		
		t_keyword = new JTextField();
		bt_search = new JButton("search");
		bt_excel = new JButton("엑셀로 등록");
		
		table = new JTable(new AbstractTableModel() {
			public int getRowCount() {
				return records.length;
			}
			public int getColumnCount() {
				return columns.length;
			}
			//컬럼의 제목을 배열로부터 구한다
			public String getColumnName(int col) {
				return columns[col];
			}
			//각 셀에 들어갈 데이터를 이차원 배열로 부터 구한다
			public Object getValueAt(int row, int col) {
				return records[row][col];
			}
		});
		scroll_table = new JScrollPane(table);
		
		//동쪽 영역 생성 
		p_east= new JPanel();
		ch_top2 = new Choice();
		ch_sub2 = new Choice();
		t_product_name2 = new JTextField();
		t_price2 = new JTextField();
		t_brand2 = new JTextField();
		t_detail2 = new JTextArea();
		scroll2 = new JScrollPane(t_detail2);
		bt_web2 = new JButton("웹에서찾기");
		bt_file2 = new JButton("파일찾기");
		can2 = new Canvas();
		bt_regist2 = new JButton("상품등록");
		
		chooser = new JFileChooser("D:\\korea202102_javaworkspace\\images");
		
		
		//스타일 및 레이아웃 
		setLayout(new BorderLayout());
		
		Dimension d = new Dimension(180,30); //공통 크기
		//서쪽 관련
		p_west.setPreferredSize(new Dimension(200, 700));
		scroll.setPreferredSize(new Dimension(180, 180));
		ch_top.setPreferredSize(d);
		ch_sub.setPreferredSize(d);
		t_product_name.setPreferredSize(d);
		t_price.setPreferredSize(d);
		t_brand.setPreferredSize(d);
		can.setPreferredSize(new Dimension(180, 180));
		can.setBackground(Color.CYAN);
		
		//센터관련 
		ch_category.setPreferredSize(d);
		t_keyword.setPreferredSize(new Dimension(300, 30));
		p_search.add(ch_category);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		p_search.add(bt_excel);
		p_center.setLayout(new BorderLayout());
		p_center.add(p_search, BorderLayout.NORTH);//검색 패널을 북쪽에 부착!!
		p_center.add(scroll_table);
		
		//동쪽관련
		p_east.setPreferredSize(new Dimension(200, 700));
		scroll2.setPreferredSize(new Dimension(180, 300));
		ch_top2.setPreferredSize(d);
		ch_sub2.setPreferredSize(d);
		t_product_name2.setPreferredSize(d);
		t_price2.setPreferredSize(d);
		t_brand2.setPreferredSize(d);
		
		//서쪽조립 
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_product_name);
		p_west.add(t_price);
		p_west.add(t_brand);
		p_west.add(scroll);
		p_west.add(bt_web);
		p_west.add(bt_file);
		p_west.add(can);
		p_west.add(bt_regist);
		
		//동쪽조립
		p_east.add(ch_top2);
		p_east.add(ch_sub2);
		p_east.add(t_product_name2);
		p_east.add(t_price2);
		p_east.add(t_brand2);
		p_east.add(scroll2);
		p_east.add(bt_web2);
		p_east.add(bt_file2);
		p_east.add(can2);
		p_east.add(bt_regist2);
		
		add(p_west, BorderLayout.WEST);//서쪽영역에 부착 
		add(p_east, BorderLayout.EAST);//서쪽영역에 부착 
		add(p_center);//센터영역에 부착 
		
		//리스너 연결 
		ch_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//지금 선택한 상위카테고리의 pk값을 알아 맞추려면???
				Choice ch=(Choice)e.getSource();
				
				System.out.println("당신이 선택한 아이템은 "+ch.getSelectedIndex()+" 번째 입니다");
				
				//유저가 현재 선택한 Choice에서의 아이템을 이용하여 ArrayList의 객체를 꺼내자!! 
				int index = ch.getSelectedIndex()-1; 
				Topcategory topcategory=topList.get(index);//topList에서 VO 한개 꺼내기!!
				System.out.println("선택하신 아이템의 정보 topcategory_id="+topcategory.getTopcategory_id());
				System.out.println("선택하신 아이템의 정보 top_name="+topcategory.getTop_name());
				
				getSubList(topcategory.getTopcategory_id()); 
			}
		});
		
		//웹에서 파일 찾기 버튼과 리스너 연결 
		bt_web.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findWeb();
			}
		});
		
		//파일찾기 버튼과 리스너 연결
		bt_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findLocal();
			}
		}); 
		
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
				getProductList();
			}
		});
		
		//엑셀버튼과 리스너 연결 
		bt_excel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registByExcel();
			}
		});
		
		getTopList(); //상위 카테고리 목록 
		getProductList();//상품 목록 
	}
	
	//왼쪽 영역의 TopCateogry 가져오기 
	public void getTopList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from topcategory";
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();//select 실행 후 레코드 반환
			
			ch_top.add("Choose Category");
			
			while(rs.next()){//커서한칸씩 이동하면서 true인 동안..
				ch_top.add(rs.getString("top_name"));
				
				//Empty 상태의 인스턴스 한개 생성 , 이 안에 카테고리 이름과  pk을 넣어두자!!
				Topcategory topcategory = new Topcategory();
				topcategory.setTopcategory_id(rs.getInt("topcategory_id")); //pk
				topcategory.setTop_name(rs.getString("top_name")); //카테고리 이름
				
				topList.add(topcategory); //ArrayList에 아이템 추가!!!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getAppMain().release(pstmt, rs);
		}
		
	}
	
	//왼쪽영역의 subcategory 나오게 
	public void getSubList(int topcategory_id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from subcategory where topcategory_id="+topcategory_id;
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ch_sub.removeAll();//기존 아이템 싹!!! 제거 
			subList.removeAll(subList); //ArrayList 의 요소 모두 삭제
			
			ch_sub.add("choose category");
			while(rs.next()) {
				Subcategory subcategory = new Subcategory();//empty
				subcategory.setSubcategory_id(rs.getInt("subcategory_id")); //pk
				subcategory.setTopcategory_id(rs.getInt("topcategory_id"));//fk
				subcategory.setSub_name(rs.getString("sub_name")); //카테고리명

				subList.add(subcategory);//완성된 VO를 ArrayList에 추가하자!! 
				ch_sub.add(rs.getString("sub_name"));
			}
			System.out.println("현재 누적된 서브카테고리 목록은 "+subList.size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.getAppMain().release(pstmt, rs);
		}
	}
	
	//웹에서 파일 찾아서 이미지 미리보기 구현 
	public void findWeb() {
		String path=JOptionPane.showInputDialog(this.getAppMain(),"경로 입력");
		
		//위의 경로를 이용하여, 웹서버에 요청을 시도해본다!! 
		//HttpURLConnection !!!!
		URL url=null;
		HttpURLConnection httpCon=null;
		InputStream is=null; //입력스트림 계열의 최상위 객체
		FileOutputStream fos=null; //파일을 대상으로 한 출력스트림
		
		try {
			url=new URL(path);
			httpCon=(HttpURLConnection)url.openConnection();
			httpCon.setRequestMethod("GET");
			
			is=httpCon.getInputStream();//웹서버로의 요청에 연결된 스트림 얻기!!
			long time=System.currentTimeMillis();
			filename=time+"."+FileManager.getExtend(path, "/");
			fos = new FileOutputStream("D:\\korea202102_javaworkspace\\ShoppingApp\\data\\"+filename);
			
			int data=-1;
			//byte[] b = new byte[1024*1024]; //1M
			while(true) {
				data=is.read();
				if(data==-1)break;
				fos.write(data);
			}
			
			JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	//로컬 시스템에서 파일 찾아서 이미지 미리 보기 구현 
	public void findLocal() {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		if(chooser.showOpenDialog(this.getAppMain())==JFileChooser.APPROVE_OPTION) {
			File file=chooser.getSelectedFile();
			
			image = kit.getImage(file.getAbsolutePath()); //파일의 물리적 풀 경로
			can.repaint();
			
			//유저가 선택한 파일을 data 디렉토리에 복사해보자~~
			try {
				fis = new FileInputStream(file);
				long time = System.currentTimeMillis();
				filename = time+"."+FileManager.getExtend(file.getAbsolutePath(), "\\");
				fos = new FileOutputStream("D:\\korea202102_javaworkspace\\ShoppingApp\\data\\"+filename); //복사될 경로
				
				//입력과 출력스트림이 준비되었으므로, 복사를 시작하자!!!
				int data=-1; 
				byte[] buff = new byte[1024]; //1kbyte 의 버퍼확보
				while(true) {
					data=fis.read(buff); //버퍼로 읽었다면,
					if(data==-1)break;
					fos.write(buff);//버퍼로 내려쓰자
				}
				JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fos!=null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}			
			}
			
		};
	}

	
	
	public void regist() {
		PreparedStatement pstmt=null;
		
		String sql="insert into product(subcategory_id, product_name, price, brand, detail, filename)";
		sql+=" values(?,?,?,?,?,?)";
		int index= ch_sub.getSelectedIndex()-1;
		
		//얻어진 초이스 컴포넌트의 index를 이용하여, VO가 들어있는 ArrayList의 접근해보자!!
		Subcategory subcategory=subList.get(index);
		System.out.println("당신이 등록하려는 상품의 subcategory_id 는 "+ subcategory.getSubcategory_id());
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			//바인드 변수값 처리 
			pstmt.setInt(1, subcategory.getSubcategory_id()); //서브 카테고리
			pstmt.setString(2, t_product_name.getText());//상품명
			pstmt.setInt(3, Integer.parseInt(t_price.getText()));//가격
			pstmt.setString(4, t_brand.getText());//브랜드
			pstmt.setString(5, t_detail.getText());//상세설명
			pstmt.setString(6, filename);//이미지명
			
			//쿼리실행(DML)
			int result = pstmt.executeUpdate();
			if(result==1) {
				JOptionPane.showMessageDialog(this.getAppMain(), "상품 등록성공");
			}else {
				JOptionPane.showMessageDialog(this.getAppMain(), "상품 등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt);
		}
		
	}
	
	//상품 목록 가져오기 
	public void getProductList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select product_id, sub_name, product_name, price, brand, detail,filename";
		sql+=" from subcategory s, product p";
		sql+=" where s.subcategory_id=p.subcategory_id";
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql
					, ResultSet.TYPE_SCROLL_INSENSITIVE
					, ResultSet.CONCUR_READ_ONLY);
			
			rs=pstmt.executeQuery();
			rs.last(); //커서를 마지막레코드로 보냄 
			int total = rs.getRow(); //레코드 번호 구하기
			
			//JTable이 참조하고 있는 records라는 이차원배열의 값을, rs를 이용하여 갱신해보자!
			records=new String[total][columns.length];
			
			rs.beforeFirst(); //커서 위치 제자리로 
			int index=0;
			while(rs.next()) {
				records[index][0]=Integer.toString(rs.getInt("product_id"));
				records[index][1]=rs.getString("sub_name");
				records[index][2]=rs.getString("product_name");
				records[index][3]=Integer.toString(rs.getInt("price"));
				records[index][4]=rs.getString("brand");
				records[index][5]=rs.getString("detail");
				records[index][6]=rs.getString("filename");
				index++;
			}
			table.updateUI();//JTable 갱신 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt, rs);
		}
	}
	//java가 기본적으로 엑셀을 제어할 수 있는 api가 지원되지 않는다. 따라서 외부의 api를 이용해야 한다 
	//apache 개발한 라이브러리 이용해보자~
	// http://apache.org  : 무료 소프트웨어 진영을 이끌고 있는 단체!!   POI  jar
	public void registByExcel() {
		//유저가 선택한 엑셀파일의 경로를 구한다!!
		
		String path=null;
		
		if(chooser.showOpenDialog(this.getAppMain()) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();//파일 정보 얻기!!
			path = file.getAbsolutePath();
		}else {
			JOptionPane.showMessageDialog(this.getAppMain(), "엑셀파일을 선택해 주세요");
			return; //이하 라인을 못지나가게..함수 호출한 곳으로 실행부를 돌려보냄..
		}
		
		/*
		 * 1) 엑셀파일에 접근부터 해야 한다!! ( 즉 빨대를 꽂아야 한다)
		*/
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		PreparedStatement pstmt=null;
		
		try {
			fis =new FileInputStream(path);
			//이 스트림을 통해 내부데이터를 엑셀로 이해할 수 있도록 해석!!! 
			workbook=new XSSFWorkbook(fis);//엑셀파일을 처리하기 위한 객체 XSSFWorkbook
			
			XSSFSheet sheet = workbook.getSheet("product");//우리가 부여한 sheet명을 이용해서 쉬트 접근!!!
			
			
			//쉬트객체를 이용해서 원하는 레코드에 접근해보자!!
			for(int i=1;i<sheet.getLastRowNum();i++) {
				XSSFRow row = sheet.getRow(i);
				
				int subcategory_id=0;
				String product_name=null;
				int price=0;
				String brand=null;
				String detail=null;
				String filename=null;
				
				//컬럼 수 만큼 반복
				for(int a=0; a< row.getLastCellNum();a++) {
					XSSFCell cell=row.getCell(a);
					//숫자일경우, 문자열 경우 메서드가 틀리기 때문에 결국 자료형에 따라 조건으로 알맞는메서드 호출
					if(a==0) { //subcategory_id
						System.out.print(cell.getNumericCellValue());
						subcategory_id=(int)cell.getNumericCellValue(); //double --> int
					}else if(a==1) {
						System.out.print(cell.getStringCellValue());
						product_name=cell.getStringCellValue();
					}else if(a==2) {
						System.out.print(cell.getNumericCellValue());
						price = (int)cell.getNumericCellValue(); //double --> int
					}else if(a==3) {
						System.out.print(cell.getStringCellValue());
						brand = cell.getStringCellValue();
					}else if(a==4) {
						System.out.print(cell.getStringCellValue());
						detail=cell.getStringCellValue();
					}else if(a==5) {
						System.out.print(cell.getStringCellValue());
						filename=cell.getStringCellValue();
					}
				}
				System.out.println(""); //줄바꿈
				
				String sql="insert into product(subcategory_id,product_name,price,brand,detail,filename)";
				sql+=" values(?,?,?,?,?,?)";
				
				Connection con=this.getAppMain().getCon();
				//con.setAutoCommit(false);//자동 커밋 하지마라!!! 즉 커밋은 내가주도해서 하겠다!!
				//con.setAutoCommit(true);//매 DML마다 무조건 commit해라!!
				
				pstmt=this.getAppMain().getCon().prepareStatement(sql);
				pstmt.setInt(1, subcategory_id);
				pstmt.setString(2, product_name);
				pstmt.setInt(3, price);
				pstmt.setString(4, brand);
				pstmt.setString(5, detail);
				pstmt.setString(6, filename);
				
				//쿼리실행 
				int result = pstmt.executeUpdate(); 
				
			}//바깥for

			JOptionPane.showMessageDialog(this.getAppMain(), "등록완료");
			getProductList();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				this.getAppMain().release(pstmt);
			}
		}
	}
}