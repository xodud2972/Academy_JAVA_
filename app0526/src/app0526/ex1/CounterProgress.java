package app0526.ex1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class CounterProgress extends JFrame{
	JLabel la;
	JProgressBar bar;
	JButton bt;
	int count=0;
	
	Thread t1; //카운터를 증가시킬 쓰레드 
	
	public CounterProgress() {
		la = new JLabel(Integer.toString(count));
		bar  = new JProgressBar();
		bt = new JButton("Start !!");
		
		
		//style & Layout 
		this.setLayout(new FlowLayout());
		la.setFont( new Font("Verdana", Font.BOLD, 60));
		bar.setPreferredSize(new Dimension(260, 40));
		
		//add
		add(la);
		add(bar);
		add(bt);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(2400, 100, 300, 200);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCount();
			}
		});
	}
	public void addCount() {
		t1 = new Thread() {
			public void run() {
				while(true) {
					count++;
					la.setText(Integer.toString(count));
				}
			}
		};
		t1.start(); //JVM에 맡기자!! 더이상 관여X
	}
	
	public static void main(String[] args) {
		new CounterProgress();
	}

}







