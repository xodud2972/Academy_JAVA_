package app0512.Graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	MoveTest moveTest; // null
	
	//이 생성자를 호출하는 자는, moveTest 의 주소값을 인수로 넘겨야한다.
	public MyCanvas(MoveTest moveTest) {
		this.moveTest = moveTest;
	}
		
	// 캔버스에 그려질 그림을 개발자가 주도하여, 원하는 그림을 그려보자.
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW); // 이 시점부터는, 노란색으로 그려진다.
		g.fillOval(moveTest.x, 100, 100, 100);
		
	}
}
