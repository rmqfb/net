package net.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * �������� �⺻ ���̾ƿ� �����ڴ� 
 * �������̾ƿ���
 * Swing �⺻ ���̾ƿ� ���� ���� ���� ����Ʈ ��ũ  ==> http://hosang.tistory.com/289
*/

public class SwingDemo {
	public static void main(String[] args) {
		MyFrame m = new MyFrame();
	}
}
class MyFrame extends JFrame{
	public MyFrame() {
		setSize(600, 150); // ������ ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������â �ݱ� �̺�Ʈ
		setTitle("JEE (MVC ��)");
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit ��ü����
		Dimension dim = toolkit.getScreenSize(); // ȭ��ũ��
		
		// �г� ��ü ����
		JPanel panel = new JPanel();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		
		// �г� ���� ����
		panel.setBackground(Color.BLACK);
		panelA.setBackground(Color.LIGHT_GRAY);
		panelB.setBackground(Color.CYAN);
		
		// �� ��ü ����, �г�A �� �� �߰�
		JLabel label = new JLabel(" JEE (MVC ��)");
		panelA.add(label);
		
		// ��ư ��ü ����
		JButton button1 = new JButton("Model : �����ڹ�");
		JButton button2 = new JButton("View : JSP");
		JButton button3 = new JButton("Controller : ������");
		JButton button4 = new JButton("(+) Database : ����Ŭ");
		
		// panelB �� button1,2,3,4 �߰�
		panelB.add(button1);
		panelB.add(button2);
		panelB.add(button3);
		panelB.add(button4);
		
		// panel �� panelA, panelB �߰�
		panel.add(panelA);
		panel.add(panelB);
		
		// �����ӿ� panel �߰�
		add(panel);
		setLocation(dim.width/2, dim.height/2);
		setVisible(true);
		
	}
}