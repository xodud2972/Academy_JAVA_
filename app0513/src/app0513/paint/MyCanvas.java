package app0513.paint;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyCanvas extends Canvas implements MouseMotionListener{
	ArrayList<int[]> log = new ArrayList<int[]>();
	
	public MyCanvas() {
		this.addMouseMotionListener(this);//켄버스와 마우스 모션 리스너 연결
		
	}

	public void paint(Graphics g) {
		Graphics2D g2= (Graphics2D)g;
		
		for(int i=0;i<log.size();i++) {
			int[] point=log.get(i);
			//g.fillOval(point[0], point[1], 5, 5);
			g2.drawLine(log.get(i)[0] ,log.get(i)[1], log.get(i+1)[0] ,log.get(i+1)[1]);
		}
	}
	
	
	public void mouseDragged(MouseEvent e) {
		log.add(new int[]{e.getX(), e.getY()});
		repaint(); //간접적으로  paint() 메서드를 호출하게 된다
	}
	
	public void mouseMoved(MouseEvent e) {
	}

}
