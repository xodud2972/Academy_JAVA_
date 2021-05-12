package app0512.Image;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DetailView extends JPanel{
	Image image;
	
	public DetailView() {
		this.image = image;
	}
	// 클릭시 마다 넘겨받을 이미지 처리..
	public void setImage(Image image) {
		this.image = image;
		System.out.println("클릭시 넘어온 이미지는" + image);
	}
	
	public void paint(Graphics g) {
		System.out.println("큰이미지는" + image);
		g.drawImage(image, 0, 0, this);
	}
}
