package app0512.Graphic;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gallery2 extends JFrame{
	//커스텀마이징 할 필요가 있으니, JPanel의 코드를 수정하자
	GalleryDetail galleryDetail; // 상세이미지 그려질 패널
	
	JPanel p_south; // 커스텀마이징 할 필요없으니깐 그냥 쓰자
	JButton bt_prev;
	JButton bt_next;
	//갤러리에 사용할 데이터 각 배열을 준비하자 !!
	String dir = "D:\\korea202102_javaworkspace\\app0512\\res\\images"; //디렉토리
	String[] arr = {"1.jpg","2.jpt","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.jpg","9.jpg","10.jpg"}; //파일명
	Toolkit kit;
	Image[] image;
	
	public Gallery2() {
		//생성
		galleryDetail = new GalleryDetail();
		p_south = new JPanel();
		bt_prev = new JButton("이전 사진 ");
		bt_next = new JButton("다음 사진 ");
		kit = Toolkit.getDefaultToolkit(); //인스턴스 얻기 new하지 않고도 자바에서 준비된 메서드 이용
		image[0] = kit.getImage(dir+"\\"+arr[0]);
		
		//스타일 레이아웃
		
		//조립
		add(galleryDetail); //Center 영역에 부착
		p_south.add(bt_prev); 
		p_south.add(bt_next);
		add(p_south, BorderLayout.SOUTH);
		
		//보여주기
		setBounds(1600,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Gallery2();
	}
	
}
