package app0512.Graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class LineTest extends JFrame{
	
	public void paint(Graphics g) {
		g.drawLine(100, 50, 250, 380); // 선
		g.drawOval(100, 200, 100, 100); // 색이없는 원
		g.drawRect(10, 250, 80, 80); // 사각형
		g.fillOval(30, 300, 90, 90); // 색채워진 원
		
		g.setColor(Color.RED); //빨간색 
		g.fillRect(300, 200, 50, 100); // 빨간색의 직사각형
		
		g.setFont(new Font("Verdana",Font.BOLD| Font.ITALIC,50)); //아래 apple을 꾸밈.
		g.drawString("Apple",20,400); // 텍스트로 apple 표기
	} 
	
	public LineTest() {
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new LineTest();
	}
}
