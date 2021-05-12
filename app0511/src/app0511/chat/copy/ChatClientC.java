package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	
	private ChatClientA chatClientA;
	private ChatClientB chatClientB;
	
	//생성자도 메서드이다!!!따라서 매개변수 전달이 가능함!!
	public ChatClientC() {
		
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(24);
		
		//스타일, 레이아웃
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280, 280));
		area.setBackground(Color.PINK);
		
		//조립 
		add(scroll);
		add(t_input);
		
		//이벤트연결
		t_input.addKeyListener(this);
		
		//보여주기
		setBounds(600, 100+400, 300, 400);
		setVisible(true);
	}

	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			showText();
		}
	}
	
	//setter
	public void setChatClientA(ChatClientA chatClientA) {
		this.chatClientA = chatClientA;
	}
	
	public void setChatClientB(ChatClientB chatClientB) {
		this.chatClientB = chatClientB;
	}
	
	
	public void showText() {
		//(1)나의 텍스트필드값 구하기
		String msg= t_input.getText();
		
		//(2)나의 TextArea에 누적 
		area.append(msg+"\n");
		
		//(3)ChatA의 TextArea에도 누적 
		chatClientA.area.append(msg+"\n");
		chatClientB.area.append(msg+"\n");
		
		//(4)입력값 다시 초기화
		t_input.setText("");
	}

	
	
}





