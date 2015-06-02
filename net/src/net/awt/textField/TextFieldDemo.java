package net.awt.textField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class TextFieldDemo {
	public static void main(String[] args) {
		// [1] 컴포넌트의 생성
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		// import 단축키 ctrl+shift+o
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit 객체 생성.. new 가 아닌 메소드 리턴방식으로 객체를 생성시킴
		Dimension dim = toolkit.getScreenSize(); // 화면크기
		
		Label labId = new Label(" ID : ");
		labId.setBounds(50,50,30,10); // 50,50 은 위치.  30,10 은 가로 세로
		Label labPwd = new Label(" Password : ");
		labPwd.setBounds(50,65,100,10);
		
		TextField txtId = new TextField(10); // 10글자를 입력할 수 있는 공간
		TextField txtPwd = new TextField(10);
		txtPwd.setEchoChar('*'); // 내부가 char 타입이라 싱글쿼터 줌
		
		frame.setLayout(new FlowLayout());
		frame.add(labId);
		frame.add(txtId);
		frame.add(labPwd);
		frame.add(txtPwd);				
		
		// [3] 컴포넌트 보여주기
		frame.setLocation(dim.width/2, dim.height/2);
		// 전체화면에서 절반, 절반의 위치에 두겠다.
		// 특정 사이즈를 정하는 것보다 위에처럼 dim 을 사용하면
		// 보여지는 화면에 따라 동적으로 무조건 화면이 크든 작든
		// 중앙 부근에 위치하게 됨.
		frame.setVisible(true);
	}
}
