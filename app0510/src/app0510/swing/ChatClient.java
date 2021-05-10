package app0510.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	
	JTextArea area;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	public ChatClient() {
		// 생성
		area = new JTextArea();
		p_south = new JPanel();
		t_input = new JTextField(20);
		bt_send = new JButton("Send");
		
		// 스타일 적용
		area.setBackground(Color.yellow);
		area.setEditable(false); // area 영역에 글씨 못쓰게 막음
		
		// 조립
		add(area); //프레임 센터에 부착
		p_south.add(t_input); // p_south에 부착
		p_south.add(bt_send); // p_south에 부착
		add(p_south, BorderLayout.SOUTH);
	
		//보여주기
		setSize(350,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //윈도우창 닫을 떄 프로세스도 종료

	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
