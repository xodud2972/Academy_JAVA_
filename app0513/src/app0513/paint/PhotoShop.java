package app0513.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoShop extends JFrame implements ActionListener{
	JPanel p_north;
	JButton bt_eraser;//그림 지우기 
	Color[] colorArray= {Color.RED, Color.ORANGE, Color.YELLOW
			, Color.GREEN, Color.BLUE, Color.CYAN, Color.PINK};
	MyCanvas can;
	
	public PhotoShop() {
		//생성 
		p_north = new JPanel();
		bt_eraser = new JButton("지우기");
		can = new MyCanvas();
		
		for(int i=0;i<7;i++) {
			ColorBox colorBox = new ColorBox(colorArray[i]);
			p_north.add(colorBox); //북쪽 패널에 색상자를 붙여넣기
		}
		//스타일 및 레이아웃 
		p_north.setPreferredSize(new Dimension(700, 50));
		can.setBackground(Color.WHITE);
		
		//조립 
		p_north.add(bt_eraser);
		add(p_north, BorderLayout.NORTH);
		add(can);
		
		//연결 
		bt_eraser.addActionListener(this);
		
		//보이게 
		setBounds(2400, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		can.log.removeAll(can.log);
		Graphics2D g=(Graphics2D)can.getGraphics();
		g.setColor(Color.WHITE);
		can.getGraphics().fillRect(0,0, 700, 550);
		can.repaint();
	}
	public static void main(String[] args) {
		new PhotoShop();
	}
	
}
