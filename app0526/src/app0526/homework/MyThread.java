package app0526.homework;

import javax.swing.JProgressBar;

//바를 제어하는 쓰레드 코드가 너무나 중복되고 있으므로, 재사용성을 고려한 클래스 정의!!
public class MyThread extends Thread{
	int n;
	JProgressBar bar; //null
	
	public MyThread(JProgressBar bar) {
		this.bar=bar;
	}
	
	public void run() {
		while(true) {
			n++;
			bar.setValue(n);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
