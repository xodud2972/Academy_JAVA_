package app0603;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MailsendApp extends JFrame{
	JTextField t_receiver;
	JTextField t_sender;
	JTextField t_title;
	JTextField area;
	JButton bt;
	
	public MailsendApp() {
		t_receiver = new JTextField(252);
		t_sender = new JTextField("xodud2972@gmail.com",25);
		t_title = new JTextField(25);
		area = new JTextField();
		bt = new JButton("메일 발송");
		
		setLayout(new FlowLayout());
		area.setPreferredSize(new Dimension(250,150));
		
		add(t_receiver);
		add(t_sender);
		add(t_title);
		add(area);
		add(bt);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MailsendApp();
	}
}
