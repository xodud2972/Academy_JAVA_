package com.minssam.shoppingapp.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.minssam.shoppingapp.config.ConfigMain;
import com.minssam.shoppingapp.customer.CustomerMain;
import com.minssam.shoppingapp.member.LoginForm;
import com.minssam.shoppingapp.member.Membermain;
import com.minssam.shoppingapp.order.OrderMain;
import com.minssam.shoppingapp.product.ProductMain;

public class AppMain extends JFrame implements ActionListener{
	
	JPanel p_north;
	String[] menu_title = {"상품관리","회원관리","주문관리","Login","고객센터","환경설정"};
	JButton[] bt_menu = new JButton[menu_title.length]; // 배열생성
	
	//페이지를 교체하기 위한 패널 ( 페이지들 간에 공존을 위해 )
	JPanel p_center;
	
	// 페이지 선언
	ProductMain productmain; // 상품관리 페이지
	Membermain mambermain;  // 회원관리 페이지
	OrderMain ordermain;// 주문관리
	CustomerMain customermain;// 고객센터
	LoginForm loginform;// 로그인
	ConfigMain configmain;// 횐경설정
	
	
	public AppMain() {
		
		// 생성
		p_north = new JPanel();
		for(int i=0; i<menu_title.length;i++) {
			bt_menu[i] = new JButton(menu_title[i]);
		}
		// 페이지들 생성
		p_center = new JPanel();
		productmain = new ProductMain(); // 상품관리
		mambermain = new Membermain(); // 회원관리
		ordermain = new OrderMain(); // 주문관리
		customermain = new CustomerMain(); // 고객센터
		loginform = new LoginForm();// 로그인
		configmain = new ConfigMain(); // 횐경설정
		
		// 스타일
		
		
		// 조립
		for(JButton bt : bt_menu) { //improved for loop : 주로 집합 데이터 형식을 대상으로 한 loop (속도는 느림)
			p_north.add(bt);
		}
		add(p_north, BorderLayout.NORTH);
		
		//p_center에 페이지들 붙이
		p_center.add(productmain);
		p_center.add(mambermain); // 보이지 않게 처리 setVis(false)로 처리함
		p_center.add(ordermain);
		p_center.add(customermain);
		p_center.add(loginform);
		p_center.add(configmain);
		
		add(p_center);
		
		
		// 리스너
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); // kill process
			}
		});
		
		for(int i=0; i<bt_menu.length; i++) {
			bt_menu[i].addActionListener(this);
		}
		
		
		
		//보여주기
	setSize(1200,700);
	setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌러써?");
		
	}
		
		
	
	public static void main(String[] args) {
		new AppMain();
	}
}
