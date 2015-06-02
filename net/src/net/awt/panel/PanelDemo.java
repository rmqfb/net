package net.awt.panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;

public class PanelDemo {
	public static void main(String[] args) {
		// [1] ������Ʈ�� ����
		Frame frame = new Frame("�޸���");
		frame.setSize(500, 300);
		// import ����Ű ctrl+shift+o
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// toolkit ��ü ����.. new �� �ƴ� �޼ҵ� ���Ϲ������ ��ü�� ������Ŵ
		Dimension dim = toolkit.getScreenSize(); // ȭ��ũ��
		
		Panel panel = new Panel();
		panel.setBackground(Color.GREEN);
		panel.setSize(100, 100);
		panel.setLocation(50, 50);  // ��ġ
		
		Button ok = new Button("OK");
		
		// [2] ������Ʈ�� ����
		panel.add(ok);
		frame.add(panel);
		
		// [3] ������Ʈ�� ��üȭ
		frame.setLocation(dim.width/2, dim.height/2);
		// ��üȭ�鿡�� ����, ������ ��ġ�� �ΰڴ�.
		// Ư�� ����� ���ϴ� �ͺ��� ����ó�� dim �� ����ϸ�
		// �������� ȭ�鿡 ���� �������� ������ ȭ���� ũ�� �۵�
		// �߾� �αٿ� ��ġ�ϰ� ��.
		frame.setVisible(true);
	}
}
