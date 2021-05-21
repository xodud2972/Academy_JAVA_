package com.minssam.shoppingapp.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

// 모든 페이지의 부모패널 정의 ( 공통된 코드가 있을 경우 이 클래스에 적용시키자 )
public class Page extends JPanel{
	public Page() {
		setPreferredSize(new Dimension(170,50));
	}
}
