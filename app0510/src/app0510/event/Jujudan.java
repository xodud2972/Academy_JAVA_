package app0510.event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Jujudan extends JFrame{
	JTextField t_input;
	JButton bt;
	

	public Jujudan() {
		t_input = new JTextField(20);
		bt = new JButton("출력");
	
		//조립
		this.setLayout(new FlowLayout());
		add(t_input);
		add(bt);
		
		//버튼과 리스너의 연결
		bt.addActionListener(new GugudanEvent());
		
		
		//보여주기
		setSize(250,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

	public static void main(String[] args) {
		new Jujudan();	
	}
}
