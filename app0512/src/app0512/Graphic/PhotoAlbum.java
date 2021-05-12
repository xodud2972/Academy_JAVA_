package app0512.Graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app0512.Image.DetailView;

public class PhotoAlbum extends JFrame{
	JPanel p_north; // 썸네일을 올려 놓을 패널
	JPanel canvas; // 그림이 그려질 패널
	Thumbnail[] list = new Thumbnail[8]; // 비어있는 배열 생성
	DetailView detailView; //상세보기 뷰\
	
	public void createThumb() {
		for(int i = 0; i < list.length; i++) {
			list[i] = new Thumbnail(); // 생성
			p_north.add(list[i]);// 패널에 부착
		}
	}
	
	public PhotoAlbum() {
		//생성
		p_north = new JPanel();
		detailView = new DetailView();
		
		
		//스타일, 레이아웃
		p_north.setPreferredSize(new Dimension(900,100));
		p_north.setBackground(Color.GRAY);
		
		//조립
		add(p_north, BorderLayout.NORTH);
		createThumb();
		add(detailView);
		
		//보여주기
		setBounds(0,0,900,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new PhotoAlbum();
	}
}
