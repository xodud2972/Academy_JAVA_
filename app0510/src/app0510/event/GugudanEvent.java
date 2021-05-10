package app0510.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class GugudanEvent implements ActionListener{
	JTextField t_input;
	// 생성자
	public GugudanEvent(JTextField t_input) {
		System.out.println("이벤트 클래스 생성시 넘겨받은 t_input");
		this.t_input=t_input;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 나 아닌 다른 클래스에 존재하는 Textfield 값에 무엇이 들어있는지 알아 맞추기	
		//t_input 값 가져오기
		
		printDan();
	}
	public void printDan() {
		for(int i=1;i<=9;i++) {
			System.out.println("5*"+i+"="+(5*i));
		}
	}
}
