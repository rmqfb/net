package net.awt.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Notepad extends Frame{
	private TextArea ta = new TextArea();
	private Font font = new Font("궁서체",Font.BOLD, 30);
	
	public Notepad(){
		ta.setFont(font);
		this.add(ta);
		
		// 화면 윈도우 모양 크기 만들기
		this.setTitle("메모장");
		// this.setBackground(Color.YELLOW); // 바탕화면 색깔을 주려면 Panel 이 있어야 함
		this.setBounds(100, 100, 600, 450); // 좌표, 가로, 높이
		this.setVisible(true); // 화면을 보여줘라
		
		// ExitAdapter exit = new ExitAdapter();
		this.addWindowListener(new ExitAdapter());
	}
	
	public static void main(String[] args) {
		new Notepad(); // 개체 이름이 없음  ==> 어나니머스
	}
	class ExitAdapter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			System.out.println("윈도우 창을 닫습니다.");
			System.exit(1);
			// 진짜 종료처리.. 현재 런닝 중인 프로그램을 닫으라는 명령
		}
	}

}
