package app0510.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 윈도우 이벤트를 감지하는 WindowListener를 재정의해보자
public class WindowControl implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpend호출");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing호출");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed호출");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowconified호출");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified호출");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated호출");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated호출");
		
	}
	
}
