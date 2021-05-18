package db.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberApp extends JFrame{
	JPanel p_north, p_west, p_center; 
	//북쪽관련
	JTextField t_url, t_port;
	JButton bt_connect;
	
	//서쪽관련 
	JTextField t_user_id;
	JPasswordField t_password;
	JTextField t_name;
	JButton bt_regist, bt_list;
	
	//가운데 관련 
	JTextArea area;
	JScrollPane scroll;
	
	
	public MemberApp() {
		//생성 
		p_north = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		t_url = new JTextField();
		t_port = new JTextField();
		bt_connect = new JButton("접속");
		
		t_user_id  = new JTextField(15);
		t_password  = new JPasswordField(15);
		t_name  = new JTextField(15);
		bt_regist = new JButton("등록");
		bt_list = new JButton("목록");
		
		area = new JTextArea();
		scroll  = new JScrollPane(area);
		
		//스타일 & 레이아웃 
		t_url.setPreferredSize(new Dimension(470, 25));
		t_port.setPreferredSize(new Dimension(120, 25));
		p_west.setPreferredSize(new Dimension(200, 550));
		p_west.setBackground(Color.LIGHT_GRAY);
		
		//조립 
		p_north.add(t_url);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north, BorderLayout.NORTH);
		
		p_west.add(t_user_id);
		p_west.add(t_password);
		p_west.add(t_name);
		p_west.add(bt_regist);
		p_west.add(bt_list);
		add(p_west, BorderLayout.WEST);
		
		add(scroll);
		
		//리스너연결
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//입력한 url 및 포트번호를 이용하여 mysql 접속할 예정
				connect();
			}
		});
		
		
		//윈도우와 리스너 연결 
		//어댑터의 존재 + 익명클래스를 이용하면, 많은 메서드를 거느린 인터페이스 구현 코드를
		//현저히 줄일 수 있다...
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("윈도우 닫아요!!");
			}
		});
		
		
		//보여주기
		
		setSize(700,600);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); // 이 메서드는 윈도우 창 닫을때 무언가 반환할
		//것이 있을때는 호출해서는 아니된다!!! why? 그냥 꺼져버리니...
		//이때는 WindowListener의 windowClosing() 메서드에서
		//반납할 자원등을 처리해야 하기 때문에...
	}
	//DB접속 메서드
	public void connect() {
		//드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			area.append("드라이버 로드 성공\n");
			
			String url="jdbc:mysql://"+t_url.getText()+":"+t_port.getText()+"/javase";
			Connection con=DriverManager.getConnection(url, "root", "1234");
			if(con!=null) {
				area.append("접속 성공\n");
			}else {
				area.append("접속 실패\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			area.append("드라이버 로드 실패\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//DB접속 해제 메서드
	public void disConnect() {
		
	}
	public static void main(String[] args) {
		new MemberApp(); 
	}
}







