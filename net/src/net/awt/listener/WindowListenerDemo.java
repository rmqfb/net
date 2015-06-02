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
		// [1] ������Ʈ�� ����
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		// import ����Ű ctrl+shift+o
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit ��ü ����.. new �� �ƴ� �޼ҵ� ���Ϲ������ ��ü�� ������Ŵ
		Dimension dim = toolkit.getScreenSize(); // ȭ��ũ��
		
		Label labId = new Label(" Hello AWT ");
		labId.setBounds(50,50,30,10); // 50,50 �� ��ġ.  30,10 �� ���� ����
		
		Font plain = new Font("Serif", Font.PLAIN, 20);
		Font italic = new Font("Serif", Font.ITALIC, 20);
		Font bold = new Font("Serif", Font.BOLD, 20);
		Font bolditalic = new Font("Serif", Font.BOLD+Font.ITALIC, 20);
		
		// [2] ������Ʈ ����
		labId.setFont(bolditalic);
		frame.setLayout(new FlowLayout());
		frame.add(labId);
		
		// [3] ������Ʈ �����ֱ�
		frame.setLocation(dim.width/2, dim.height/2);
		// ��üȭ�鿡�� ����, ������ ��ġ�� �ΰڴ�.
		// Ư�� ����� ���ϴ� �ͺ��� ����ó�� dim �� ����ϸ�
		// �������� ȭ�鿡 ���� �������� ������ ȭ���� ũ�� �۵�
		// �߾� �αٿ� ��ġ�ϰ� ��.
		frame.addWindowListener(new EventHandler());
		// �̺�Ʈ�� ���ս�Ŵ
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
		// ������ �ݱ� ��ư�� Ŭ������ �� ȣ��
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0); // 0�� �ǹ̴� �� ������ �������� ���ᰪ�̴�.
		
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