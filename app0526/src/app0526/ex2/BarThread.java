package app0526.ex2;

import javax.swing.JProgressBar;

public class BarThread extends JProgressBar implements Runnable{
	int n;
	int step;
	
	public BarThread(int step) {
		this.step = step;
	}


	public void run() {
		while(true) {
			n+=step;
			setValue(n);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
