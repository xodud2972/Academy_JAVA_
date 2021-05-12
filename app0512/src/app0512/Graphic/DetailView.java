package app0512.graphic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//JPanel을 상속받아서, paint 메서드를 재정의하기 위한 클래스
public class DetailView extends JPanel{
	PhotoAlbum photoAlbum;
	Image image;
	
	public DetailView(PhotoAlbum photoAlbum) {
		this.photoAlbum=photoAlbum;
	}
	
	//클릭시마다 넘겨받을 이미지..처리
	public void setImage(Image image) {
		this.image = image;
		System.out.println("클릭시 넘어온 이미지는 "+image);
	}
	
	
	public void paint(Graphics g) {
		System.out.println("큰이미지는 "+image);
		g.drawImage(image, 0, 0, this);
	}
}






