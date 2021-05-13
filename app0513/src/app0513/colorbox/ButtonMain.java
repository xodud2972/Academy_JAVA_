package app0513.colorbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonMain extends JFrame implements ActionListener{

		JPanel p_north;
		JTextField t_ea;
		JButton bt_create;
		JButton bt_create2;
		JButton bt_bg;
		JPanel p_center;
		JButton[] btnArray; // 대부분의 응용프로그램에서는 배열 선언시 반드시 그 크기를 명시해야한다.
		int count = 0; //버튼의 붙여질 순번
		
		JButton[] brnArray2; //낱개로 생성된 버튼들을 담게될 배열
		
	public ButtonMain() {
		//생성
		p_north = new JPanel();
		t_ea = new JTextField(10);
		bt_create = new JButton("Create");
		bt_create2 = new JButton("Just Create");
		bt_bg = new JButton("Background Color");
		p_center = new JPanel();
		
		//스타일 레이아웃
		p_north.setPreferredSize(new Dimension(500,50));
		p_center.setBackground(Color.PINK);
		
		//조립
		p_north.add(t_ea);
		p_north.add(bt_create);
		p_north.add(bt_create2);
		p_north.add(bt_bg);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		bt_create.addActionListener(this);
		bt_create2.addActionListener(this);
		bt_bg.addActionListener(this);
		
		//보여주기
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void create() {
		// 1 텍스트필의 값 구하기
		int ea = Integer.parseInt(t_ea.getText());// "쌍따옴표" 벗겨내기
		
		// 2 개수만큼 버튼을 생성하여 p_center에 붙이기
		for(int i=0;i<ea;i++) {
			JButton bt = new JButton("button"+(i+1));
			p_center.add(bt);
			btnArray[i] = bt; //배열에, 지금 생성된 버튼을 탑재
		}
		p_center.updateUI(); //다시 그려라
	}
	
	public void createOne() {
		int count = 0;
		// 누를때마다, 버튼이 누적되게 처리해본다.
		JButton bt = new JButton("버튼");
		p_center.add(bt); // 센터영역에 버튼 부착
		p_center.updateUI(); //
	}
	public void setBg() {
		for(int i = 0; i < btnArray.length; i++) {
			btnArray[i].setBackground(Color.RED);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt_create) {
			create();
		}else if(e.getSource() == bt_bg) {
			setBg();
		}
		
	}
	
	
	public static void main(String[] args) {
		new ButtonMain();
		
	}

}
