package app0602.cal.diary;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Diary extends JFrame{
	JPanel p_north;
	JButton bt_prev;
	JLabel la_title;
	JButton bt_next;
	
	JPanel p_center; // 날짜 박스 처리할 영역;
	
	public Diary() {
		p_north = new JPanel();
		bt_prev = new JButton("이전");
		la_title = new JLabel("연도 월 올 예정");
		bt_next = new JButton("다음");
		p_center = new JPanel();
		
		//스타일
		
		//조립
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		createDay();
		
		//이벤트
		
		//보여주기
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(780,780);
	}
	
	// 요일 생성
	public void createDay() {
		for(int i=0;i<7;i++) {
			DateBox dateBox = new DateBox();
		}
	}
	
	
	public static void main(String[] args) {
		new Diary();
	}

}
