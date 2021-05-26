package app0526.ex3;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import util.ImageManager;


//웹상의 자원을 수집하고, 다운로드 받는 진행상황을 표시하자
public class DownLoader extends JFrame{
	
	
	JTextField t_url;
	JButton bt;
	JProgressBar bar;
	ImageManager imageManger = new ImageManager();
	ImageIcon icon;
	
	public DownLoader() {
		
		t_url = new JTextField();
		// resource 폴더로 등록된 자원은 classpath를 통해 접근해야한다.
		// 그리고 classpath와 관련된 정보를 얻으려면, class 클래스를 이용하면된다.
		// 자바의 클래스 중 class에 대한 정보를 가진 Class이다. 이 Class 클래스를 이용하면 클래스코드를 static에 올리수도 있고
		// (Class.forName("드라이버 명")), 해당 클래스가 가진 메서드, 속성 등을 추출할수도 있다.
		//Class myClass = this.getClass();
		//Method[] methods = myClass.getMethods();
		//System.out.println("이클래스가 보유한 메서드의 수는"+methods.length);
		
		// 개발자가 특정 디렉토리를 resourc로 등록하면, getResource() 메서드로
		// 클래스 패스도 이용하여 접근 가능~~!!

		bt = new JButton(imageManeger.getScal);
		bar = new JProgressBar();
		
		// style & layout
		setLayout(new FlowLayout());
		t_url.setPreferredSize(new Dimension(470,35));
		bar.setPreferredSize(new Dimension(470,35));
		
		//add
		add(t_url);
		add(bt);
		add(bar);
		
		setVisible(true);
		setSize(500,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public void test() {
		
	}
	
	public void test2() {
		
	}
	
	
	public static void main(String[] args) {
		new DownLoader();
	}
}
