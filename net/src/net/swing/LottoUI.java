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
	JPanel pan_nth, pan_sth; // �г��߿��� ����, ����
	ImageIcon icon;
	List<JButton> btns;
	
	public LottoUI() {
		init();  // ������ �ҽ��� �Ϻη� ������ �޼ҵ�� ó���ؼ� ����� ��ġ�� ������� ȣ��ν� ����� �����ϵ��� �ϴ� �� : �ڹٽ�ũ��Ʈ�� ȣ�̽�Ʈ ���� ����.
		// �Ķ���Ͱ� ���� ��� this.lotto ó�� this�� �ۼ������ ��
		// ex> lotto = new Lotto();
	}
	
	private void init(){
		setTitle("�ζ� ������");
		lotto = new Lotto(); // ������ ����ϴ� Ŭ������ Lotto �� �����ڿ� �ٿ���.
		btns = new ArrayList<JButton>();
		/*
		 * �����г�, �����г� ������ �� �����ӿ� ���̰�,
		 * ��ư���� �̺�Ʈ�� �Ҵ��ϴµ�
		 * btn.addActionListener(this);
		 * �����гο� ��ư�� ���̱�
		 * �����гο� BorderLayout ���� ���ʿ� ��ġ�ϰ�
		 * �����г��� ���ʿ� ��ġ
		 * ������ ������� 1200, 300 �ȼ��̰�
		 * x, y ��ǥ���� 300, 400 ���� �Ѵ�.
		 * �������� ������� Ȯ��Ұ��� �ٲ� �� ���� �ϱ�
		*/ 
		pan_nth = new JPanel();
		pan_sth = new JPanel();
		btn = new JButton("������");
		/*
		 * this �� LottoUI �� �� �� �ִ� ��� �߿��� ActionListner �� �޼ҵ� ��
		 * actionPerformed(ActionEvent e)�� 
		 * ��ư���� �ο��� ��
		*/
		btn.addActionListener(this);
		
		pan_nth.add(btn);
		
		this.add(pan_nth, BorderLayout.NORTH);
		this.add(pan_sth, BorderLayout.SOUTH);
		
		
		this.setBounds(300, 400, 1200, 300);
		this.setVisible(true);
		this.setResizable(false);  // âũ�� ����
		
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
		String imgPath = "C:\\Users\\�����_PM\\git\\net\\net\\src\\images\\"+Integer.toString(i)+".gif"; // �̹��� ��θ� ���ϴ� ��
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
