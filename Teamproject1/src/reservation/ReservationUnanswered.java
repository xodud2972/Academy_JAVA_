package reservation;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.AppMain;
import main.CustomButton;
import main.Page;

public class ReservationUnanswered extends Page{
	
	JPanel p_west;
	JPanel p_top;
	JPanel p_sub;
	
	String[] top_title= {"회원 관리","바이크 관리","중고장터 관리","예약관리","기업 관리","고객 센터"};
	CustomButton[] bt_top = new CustomButton[top_title.length];
	String[] sub_user = {"회원","바이크","연비","정비"};
	CustomButton[] bt_user = new CustomButton[sub_user.length];
	String[] sub_bike = {"전체조회"};
	CustomButton[] bt_bike = new CustomButton[sub_bike.length];
	String[] sub_market = {"게시글","로그","리뷰"};
	CustomButton[] bt_market = new CustomButton[sub_market.length];
	String[] sub_customer = {"게시글","미답변"};
	CustomButton[] bt_customer = new CustomButton[sub_customer.length];
	String[] sub_reservation = {"게시글"};
	CustomButton[] bt_reservation = new CustomButton[sub_reservation.length];
	String[] sub_company = {"전체조회"};
	CustomButton[] bt_company = new CustomButton[sub_company.length];
	
	
	
	
	//센터관련 
	JPanel p_center;
	JPanel p_search; //검색 컴포넌트들 올려놓을 패널 
	Choice ch_category;//상위 카테고리 선택
	Choice ca_category;//하위 카테고리 선택
	JTextField t_keyword;//검색어 입력
	JButton bt_search; 
	JTable table;
	JScrollPane scroll_table;
	
	
	//동쪽관련
	JPanel p_east;
	JButton bt_regist; // 동쪽 등록버튼
	Canvas can2; // 동쪽 사진
	JTextField brand2; //  동쪽 제목
	Choice ech_category;// 동쪽 상위 카테고리 선택
	Choice eca_category;//동쪽 하위 카테고리 선택
	JTextArea t_detail2; // 동쪽 상세내용
	JButton bt_modify; // 동쪽 수정버튼
	JButton bt_del; // 동쪽 삭제버튼
	
	
	JScrollPane scroll2;
	JFileChooser chooser;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image image; //등록시 미리보기에 사용할 이미지
	Image image2; //상세보기시 그려질 이미지
	String filename; //유저의 복사에 의해 생성된 파일명!!!
	
	
	String[] columns={"product_id", "subcategory_id","product_name","price","brand","detail","filename"};//컬럼배열 
	String[][] records={};//레코드배열
	int product_id; // 현재 상세보기 중인 product의 pk
	String del_file; //현재 상세보기 중인 filename(삭제 대상이 될 수 있슴)
	
	//데이터 베이스 관련
	String driver="com.mysql.jdbc.Driver"; // 8.xx 인 경우 com.mysql.jdbc.cj.Driver
	String url="jdbc:mysql://localhost:3306/shoppingapp?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	private Connection con;
	
	
	public ReservationUnanswered(AppMain appMain) {
		super(appMain);
		connect();//DB접속
		
		p_west = new JPanel();
		p_top = new JPanel();
		p_sub = new JPanel();
		for(int i=0;i<top_title.length ;i++) {
			bt_top[i] = new CustomButton(top_title[i]);
			bt_top[i].setId(i);
			
		//센터 영역 생성 
		p_center = new JPanel();
		p_search = new JPanel();
		ch_category = new Choice();
		ca_category = new Choice();
		
		//검색 카테고리 등록
		ch_category.add("Parent Category");
		ch_category.add("product_name");
		ch_category.add("price");
		ch_category.add("brand");
		
		ca_category.add("Subcategories");
		ca_category.add("product_name");
		ca_category.add("price");
		ca_category.add("brand");
		
		t_keyword = new JTextField();
		bt_search = new JButton("search");
		
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
			//JTable의 각셀의 값을 지정
			//셀을 편집한 후, 엔터치는 순간 아래의 메서드 호출됨
			public void setValueAt(Object value, int row, int col) {
				System.out.println(row+","+col+" 번째 셀의 데이터는 "+value+"로 바꿀께요");
				records[row][col]=(String)value;
			}
			
			//다른 메서드와 마찬가지로, 아래의 isCellEditable메서드도 호출자가 JTable이다
			public boolean isCellEditable(int row, int col) {
				if(col==0) { //첫번째 열인 product_id만 읽기전용으로 세팅
					return false;
				}else {
					return true;					
				}
			}
		});
		scroll_table = new JScrollPane(table);
		
		//동쪽 영역 생성 
		p_east= new JPanel();
		bt_regist = new JButton("등록 버튼");
		can2 = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(image2, 0,0, 180,180, can2);
			}
		};
		brand2 = new JTextField();
		ech_category = new Choice();
		eca_category = new Choice();
		
		//검색 카테고리 등록
		ech_category.add("Parent Category");
		ech_category.add("product_name");
		ech_category.add("price");
		ech_category.add("brand");
		
		eca_category.add("product_name");
		eca_category.add("Subcategories");
		eca_category.add("price");
		eca_category.add("brand");
		
		
		t_detail2 = new JTextArea();
		bt_modify = new JButton("수정 버튼");
		bt_del = new JButton("삭제 버튼");
		scroll2 = new JScrollPane(t_detail2);
		
		
		bt_del = new JButton("상품삭제");
		
		chooser = new JFileChooser("D:\\workspace\\korea202102_jsworkspace\\images");
						

		//스타일 및 레이아웃 
		setLayout(new BorderLayout());
		
		Dimension d = new Dimension(180,30); //공통 크기
		
		//센터관련 
				ch_category.setPreferredSize(d);
				ca_category.setPreferredSize(d);
				t_keyword.setPreferredSize(new Dimension(300, 30));
				p_search.add(ch_category);
				p_search.add(ca_category);
				p_search.add(t_keyword);
				p_search.add(bt_search);
				p_center.setLayout(new BorderLayout());
				p_center.add(p_search, BorderLayout.NORTH);//검색 패널을 북쪽에 부착!!
				p_center.add(scroll_table);
				
				//동쪽관련
				p_east.setPreferredSize(new Dimension(200, 700));
				can2.setPreferredSize(new Dimension(180, 180));
				can2.setBackground(Color.YELLOW);
				scroll2.setPreferredSize(new Dimension(180, 180));
				brand2.setPreferredSize(d);
				ech_category.setPreferredSize(d);
				eca_category.setPreferredSize(d);

				p_east.add(bt_regist);
				p_east.add(can2);
				p_east.add(brand2);
				p_east.add(eca_category);
				p_east.add(ech_category);
				p_east.add(scroll2);
				p_east.add(bt_modify);
				p_east.add(bt_del);
				
				add(p_west, BorderLayout.WEST);//서쪽영역에 부착 
				add(p_east, BorderLayout.EAST);//서쪽영역에 부착 
				add(p_center);//센터영역에 부착 
			
		}
		
		
		
		
		p_west.setPreferredSize(new Dimension(240, 800));
		p_west.setBackground(Color.BLACK);
		p_top.setPreferredSize(new Dimension(110, 800));
		p_top.setBackground(Color.DARK_GRAY);
		p_sub.setPreferredSize(new Dimension(110, 800));
		p_sub.setBackground(Color.GRAY);
		
		
		
		
		for (JButton bt: bt_top) {
			bt.setPreferredSize(new Dimension(110, 35));
			bt.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					CustomButton bt = (CustomButton)obj;
					if(bt.getId()==0) {
						createUser(sub_user,bt_user);
					}else if(bt.getId()==1) {
						createUser(sub_bike,bt_bike);						
					}else if(bt.getId()==2) {
						createUser(sub_market,bt_market);						
					}else if(bt.getId()==3) {
						createUser(sub_customer,bt_customer);						
					}else if(bt.getId()==4) {
						createUser(sub_reservation,bt_reservation);						
					}else if(bt.getId()==5) {
						createUser(sub_company,bt_company);						
					}
				}
			});
			p_top.add(bt);
		}
		p_west.add(p_top);
		p_west.add(p_sub);
		add(p_west,BorderLayout.WEST);
		
		

		
	
		
	}
	
	public void connect() {
		try {
			Class.forName(driver); //드라이버 로드 
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//쿼리문이 DML
		public void release(PreparedStatement pstmt) {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//쿼리문이 select인 경우
		public void release(PreparedStatement pstmt, ResultSet rs) {
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		public Connection getCon() {
			return con;
		}
	
	
	public void createUser(String[] sub,CustomButton[] bt_sub) {
		p_sub.removeAll();
		for(int i=0;i<sub.length ;i++) {
			bt_sub[i] = new CustomButton(sub[i]);
			bt_sub[i].setId(i);
		}
		for(JButton bt : bt_sub) {
			bt.setPreferredSize(new Dimension(110, 35));
			p_sub.add(bt);
		}
		p_sub.updateUI();
		
	}
	
	
		//상품 목록 가져오기 
		public void getProductList() {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select product_id, sub_name, product_name, price, brand, detail,filename";
			sql+=" from subcategory s, product p";
			sql+=" where s.subcategory_id=p.subcategory_id";
			
			try {
	
				
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
				
			}
		}
		

		public static void main(String[] args) {
			new ReservationMain(null);
		}

}