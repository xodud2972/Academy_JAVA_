package db.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
		
		//보여주기
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 이 메서드는 윈도우 창 닫을때 무언가 반환할
		//것이 있을때는 호출해서는 아니된다!!! why? 그냥 꺼져버리니...
		//이때는 WindowListener의 windowClosing() 메서드에서
		//반납할 자원등을 처리해야 하기 때문에...
	}
	
	public static void main(String[] args) {
		new MemberApp(); 
	}
}
