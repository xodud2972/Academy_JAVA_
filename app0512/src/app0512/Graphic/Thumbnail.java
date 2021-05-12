package app0512.Graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Thumbnail extends JPanel implements MouseListener{
	Image image; // 추상 클래스 이므로, new 불가
	Toolkit kit; // 이미지를 얻을 수 있는 클래스
	
	public Thumbnail() {
		kit = Toolkit.getDefaultToolkit();
		image = kit.getImage("D:\\korea202102_javaworkspace\\app0512\\res\\images\\mt.jpg");
		image = image.getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		this.setPreferredSize(new Dimension(100,90));
		
		// 현재 패널과 리스너의 연결
		this.addMouseListener(this);
		
	}
	
	public void paint(Graphics g) {
		g.drawImage(image,0, 0, this);
		
	}


	public void mouseClicked(MouseEvent e) {
		System.out.println("나 눌렀어?");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
