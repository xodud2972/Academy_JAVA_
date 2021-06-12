package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Page;

public class AppMain extends JFrame implements ActionListener{
	JPanel p_west;
	JPanel p_top;
	JPanel p_sub;
	
	//페이지 선언 
	Page[] pages = new Page[7];
	
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
	
	//데이터베스 관련 
	String driver="com.mysql.jdbc.Driver"; // 8.xx 인 경우 com.mysql.jdbc.cj.Driver
	String url="jdbc:mysql://localhost:3306/shoppingapp?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	private Connection con;
	private boolean session=false; //세션이 true 일때 인증받은 것이고, false일때는 미인증 간주
	
	
	
	public AppMain() {
		connect();//DB접속	
		
		p_west = new JPanel();
		p_top = new JPanel();
		p_sub = new JPanel();
		for(int i=0;i<top_title.length ;i++) {
			bt_top[i] = new CustomButton(top_title[i]);
			bt_top[i].setId(i);
		}
		
		
		
		
		p_west.setPreferredSize(new Dimension(240, 800));
		p_west.setBackground(Color.BLACK);
		p_top.setPreferredSize(new Dimension(120, 800));
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
		
		
		//리스너
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect(); //DB 접속해제
				System.exit(0); //kill process
			}
		});
	
				
		

		setSize(1400, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Riding Mate");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
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

	public void actionPerformed(ActionEvent e) {
		//어떤 버튼이 눌렸는지? - 이벤트가 연결된 컴포넌트를 가리켜 이벤트 소스 
		Object obj = e.getSource();
		//obj는 오브젝트 자료형이기 때문에, 버튼을 가리킬수는 있지만, 버튼 보다는 보편적인 기능만을 가지고 
		//있기에, 즉 가진게 별로 없기에 버튼의 특징을 이용하기 위해서는 버튼 형으로 변환해서 사용하자!!
		CustomButton bt=(CustomButton)obj; //down casting
		//System.out.println(bt.getText());
		if(session) {
			showHide(bt.getId());
		}else {
			JOptionPane.showMessageDialog(this , "로그인이 필요한 서비스입니다");
		}
	}
	
	
	
	public void connect() {
		try {
			Class.forName(driver); //드라이버 로드 
			con = DriverManager.getConnection(url, user, password);
			if(con !=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 실패");
			}
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
	
	
	public void showHide(int n) { //보여주고 싶은 페이지의 번호를 넘기면 된다..
		//내가 누른 버튼에 해당하는 페이지만 setVisible() 을 true로 놓고 나머지는 false로 놓자!!
		for(int i=0;i<pages.length;i++) {
			if(n==i) {
				pages[i].setVisible(true); //현재 선택한 버튼과 같은 인덱스를 갖는 페이지라면..
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	
	
	
	public Connection getCon() {
		return con;
	}
	
	
	
	
	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	

	public static void main(String[] args) {
		new AppMain();
	}
}