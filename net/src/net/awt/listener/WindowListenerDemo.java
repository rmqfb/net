package net.awt.listener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDemo {
	public static void main(String[] args) {
		// [1] 컴포넌트의 생성
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		// import 단축키 ctrl+shift+o
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit 객체 생성.. new 가 아닌 메소드 리턴방식으로 객체를 생성시킴
		Dimension dim = toolkit.getScreenSize(); // 화면크기
		
		Label labId = new Label(" Hello AWT ");
		labId.setBounds(50,50,30,10); // 50,50 은 위치.  30,10 은 가로 세로
		
		Font plain = new Font("Serif", Font.PLAIN, 20);
		Font italic = new Font("Serif", Font.ITALIC, 20);
		Font bold = new Font("Serif", Font.BOLD, 20);
		Font bolditalic = new Font("Serif", Font.BOLD+Font.ITALIC, 20);
		
		// [2] 컴포넌트 조립
		labId.setFont(bolditalic);
		frame.setLayout(new FlowLayout());
		frame.add(labId);
		
		// [3] 컴포넌트 보여주기
		frame.setLocation(dim.width/2, dim.height/2);
		// 전체화면에서 절반, 절반의 위치에 두겠다.
		// 특정 사이즈를 정하는 것보다 위에처럼 dim 을 사용하면
		// 보여지는 화면에 따라 동적으로 무조건 화면이 크든 작든
		// 중앙 부근에 위치하게 됨.
		frame.addWindowListener(new EventHandler());
		// 이벤트를 결합시킴
		frame.setVisible(true);
	}
}
class EventHandler implements WindowListener{

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 윈도우 닫기 버튼을 클릭했을 때 호출
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0); // 0의 의미는 잘 모르지만 짐작컨대 종료값이다.
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}}