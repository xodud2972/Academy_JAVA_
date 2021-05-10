package app0510.layout;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.BorderLayout;

// LginForm 예제에서는 메인 메서드 안에 변수를 뫃아 넣고, 즉 지역변수로 객첻르을 처리하고 있다.
// 이번엔 OOP언어의 is a, 와 has a 관계를 활용하여 객체를 정의해보자.
public class LoginForm2 extends Frame{
							    	/* is a */
	
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_join;
	
	Panel p_center; // 
	Panel p_south;
	
	// 이 윈도우 즉, 로그인 폼이 메모리에 생성될 떄 해당 부품들도 같이 생성시키려면 생서자 메서드를
	// 적극 활용해야 한다.
	
	public LoginForm2() {
		// 윈도우에 제목달기 - 방법 1 : 부모의 생성자를 이용하는 방법
		super("LoginForm style 2");
		
		// 부품 생성
		la_id = new Label("ID");
		la_pass = new Label("pass");
		t_id = new TextField(20); //20자 너비의 크기를 갖음(20자만 넣을 수 있는게 아니다)
		t_pass = new TextField(20);
		bt_login = new Button("Login");
		bt_join = new Button("join");
		
		p_center = new Panel();
		p_south = new Panel();
		
		// 스타일 생성 (내가 원하는 크기로 설정)
		la_id.setPreferredSize(new Dimension(110,35));
		t_id.setPreferredSize(new Dimension(110,35));
		la_pass.setPreferredSize(new Dimension(110,35));
		t_pass.setPreferredSize(new Dimension(110,35));
		
		// 조립
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		// 패널을 윈도우 센터에 부착
		this.add(p_center);
		this.add(p_south, BorderLayout.SOUTH);
		
		//위도우의 크기설정 ( this인 이유는 extends로 인해 is a 관계가 되어서 나자체가 윈도우가 된다. )
		// ( 그렇기 때문에 frame.setSize가 아닌 this를 사용한다. )
		//현재 클래스가 Frame을 상속받은 자식이므로, Frame이 보유한 메서드를 내것처럼 쓸 수 있다.
		this.setSize(330,160);
		// 윈도우 보이기
		this.setVisible(true);
		
		// 윈도우에 제목달기 - 방법 2: 부모의 일반 메서드 이용하는 방법
		/* this.setTitle("LoginForm style2");*/
	}
	
}
