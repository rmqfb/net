package net.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Lotto lotto;
	JButton btn;
	JPanel pan_nth, pan_sth; // 패널중에서 북쪽, 남쪽
	ImageIcon icon;
	List<JButton> btns;
	
	public LottoUI() {
		init();  // 복잡한 소스를 하부로 보내고 메소드로 처리해서 선언된 위치에 관계없이 호출로써 기능을 수행하도록 하는 것 : 자바스크립트의 호이스트 같은 개념.
		// 파라미터가 있을 경우 this.lotto 처럼 this를 작성해줘야 함
		// ex> lotto = new Lotto();
	}
	
	private void init(){
		setTitle("로또 생성기");
		lotto = new Lotto(); // 로직을 담당하는 클래스인 Lotto 를 생성자에 붙였다.
		btns = new ArrayList<JButton>();
		/*
		 * 북쪽패널, 남쪽패널 생성한 후 프레임에 붙이고,
		 * 버튼에는 이벤트를 할당하는데
		 * btn.addActionListener(this);
		 * 북쪽패널에 버튼을 붙이기
		 * 북쪽패널에 BorderLayout 에서 북쪽에 배치하고
		 * 남쪽패널은 남쪽에 배치
		 * 프레임 사이즈는 1200, 300 픽셀이고
		 * x, y 좌표값은 300, 400 으로 한다.
		 * 프레임의 사이즈는 확장불가로 바꿀 수 없게 하기
		*/ 
		pan_nth = new JPanel();
		pan_sth = new JPanel();
		btn = new JButton("생성기");
		/*
		 * this 는 LottoUI 가 할 수 있는 기능 중에서 ActionListner 의 메소드 중
		 * actionPerformed(ActionEvent e)를 
		 * 버튼에서 부여한 것
		*/
		btn.addActionListener(this);
		
		pan_nth.add(btn);
		
		this.add(pan_nth, BorderLayout.NORTH);
		this.add(pan_sth, BorderLayout.SOUTH);
		
		
		this.setBounds(300, 400, 1200, 300);
		this.setVisible(true);
		this.setResizable(false);  // 창크기 고정
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(btns.size() == 0){
			makeBtns();
		}else{
			lotto.setLotto();
			showLotto();
		}
	}

	private void showLotto() {
		int[] arr = lotto.getLotto();
		for(int i=0; i<arr.length; i++){
			btns.get(i).setIcon(getIcon(arr[i]));
		}	
	}
	
	private Icon getIcon(int i){
		String imgPath = "C:\\Users\\취업반_PM\\git\\net\\net\\src\\images\\"+Integer.toString(i)+".gif"; // 이미지 경로를 구하는 것
		return new ImageIcon(imgPath);
	}

	private void makeBtns() {
		JButton tmp = null;
		for(int i = 0; i<6; i++){
			tmp = new JButton();
			btns.add(tmp);
			pan_sth.add(tmp);
		}
		
	}

}
