package app0511.member;

import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinForm extends JFrame{
	
	JPanel p_title; //제목란에 패널 뒤쪽에 판대기
	JLabel la_title; //회원가입이라고 써져있는 란 가장위에 제목
	JLabel la_id; //아이디 글씨써져있는 란
	JTextField t_id; //아이디 입력란
	JLabel la_pass; // 패스원드 써져있는 란
	JPasswordField t_pass; //패스워드 입력란
	JLabel la_hobby; //취미라고 써져있는란 
	JPanel p_hobby; // 취미 체크박스를 뒤쪽에 판대기
	JCheckBox[] ch_hobby; // 취미체크박스
	JPanel p_mail; // 메일란에 패널 뒤쪽에 판대기
	JTextField t_mailId; // mail 아이디  입력란
	JLabel la_at; // 골뱅이 ?
	Choice ch_server; // mail 초이스란
	JPanel p_receivel;  //mail 수신 여부
	JLabel la_receive; // mail 수신 여부
	CheckboxGroup g; // 수신거부동의 체크란
	JButton bt_regists; // 마무리 가입 버튼  
	
	public JoinForm() {
		//생성
		p_title = new JPanel();
		la_title = new JLabel("회원가입"); // 기본 부품에 회원가입 글씨 장착
		la_id = new JLabel("ID");
		t_id = new JTextField();
		la_pass = new JLabel("Pass");
		t_pass = new JPasswordField();
		la_hobby = new JLabel("취미선택");
		p_hobby= new JPanel(); //취미 체크박스 담게될 패널
		ch_hobby = new JCheckBox[5]; // 빈 공간만 생성함
		ch_hobby[0] = new JCheckBox("코딩");
		ch_hobby[1] = new JCheckBox("운동");
		ch_hobby[2] = new JCheckBox("게임");
		ch_hobby[3] = new JCheckBox("독서");
		ch_hobby[4] = new JCheckBox("여행");
		
		p_mail = new JPanel();
		t_mailId = new JTextField();
		la_at = new JLabel("@");
		ch_server = new Choice();
		
		ch_server.add("gmail.com");
		ch_server.add("naver.com");
		ch_server.add("daum.net");
		ch_server.add("direct insert");
		
		
		
		//스타일,레이아웃
		setLayout(new FlowLayout());
		la_title.setFont(new Font("돋움", Font.BOLD,24)); //setFont(new Font(글씨체, Font.두꼐, 글씨크기);
		p_title.setPreferredSize(new Dimension(450,50));
		
		
		Dimension d = new Dimension(100,30);
		la_id.setPreferredSize(d);
		t_id.setPreferredSize(new Dimension(350,30));
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(new Dimension(350,30));
		p_hobby.setPreferredSize(new Dimension(450,50));
		
		t_mailId.setPreferredSize(new Dimension(150,30));
		la_at.setPreferredSize(new Dimension(30,30));
		ch_server.setPreferredSize(new Dimension(120,30));
		
		
		//조립
		p_title.add(la_title); //패널에 제목 올려놓기
		add(p_title); //윈도우에 제목 패널 부착
		add(la_id);
		add(t_id);
		add(la_pass);
		add(t_pass);
		add(la_hobby);
		for(int i=0; i<ch_hobby.length;i++) {
		p_hobby.add(ch_hobby[i]);
		}
		add(p_hobby);
		//메일 조립
		p_mail.add(t_mailId);
		p_mail.add(la_at);
		p_mail.add(ch_server);
		add(p_mail);
		
		
		
		//보여주기 ( 모니터 화면 중앙으로 오게끔 )
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	public static void main(String[] args) {
		new JoinForm();

	}

}
