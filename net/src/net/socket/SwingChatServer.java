package net.socket;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SwingChatServer extends JFrame implements ActionListener{
	
	JTextArea txtList;
	JButton btnExit;
	ServerSocket ss = null;
	Vector inwon;  // �ο��� ī��Ʈ
	/* ArrayList �� ������� �ʰ� Vector �� ����ϴ� ����
	 * ����ȭ ���������̴�. ���� ���α׷��� ����ȭ ������ �ʿ��ϴ�.
	 */
	
	public SwingChatServer(){
		super("Chatting Server");
		txtList = new JTextArea();
		btnExit = new JButton("��������");
		
		add(txtList, "Center");
		add(btnExit, "South");
		setSize(350, 650);
		setVisible(true);
		// �̺�Ʈ ó�� -------------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE); // ������â �ݱ� �̺�Ʈ
		btnExit.addActionListener(this);
		inwon = new Vector(); // ���Ϳ��� ���׸��� �����ϸ� ��� Ÿ�� ����
		serverStart();
		
	}
	
	private void serverStart() {
		final int PORT = 7500;
		try{
			ss = new ServerSocket(PORT);
			System.out.println("������ ���۵Ǿ����ϴ�.");
			txtList.append("������ ���۵Ǿ����ϴ�.");
			txtList.setFont(new Font("����ü", Font.BOLD, 16)); // 16 �� ũ��
			while (true) {
				Socket socket = ss.accept();
				String str = socket.getInetAddress().getHostAddress();
				txtList.append(str);
				// ����ó���� �ϱ� ���� Ŭ���̾�Ʈ ��ü����(����� ���� Ŭ����)
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setMsg(String str) {
		txtList.append(str);
		
	}

}

class ChatHandle extends Thread{
	SwingChatServer server = null;
	Socket socket = null;
	PrintWriter pw = null;
	BufferedReader in = null;
	
	public ChatHandle(SwingChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		
		try{
			InputStream is = socket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(os));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	} // ������ ��
	
	@Override
	public void run() {
		String nickName = null;
		try{
			nickName = in.readLine();
			// �������� �޽��� ����� ����� �ϱ�����... setMsg() �����Ͽ� �ڵ����� �õ�
			server.setMsg("["+ nickName + "] ���� ���� �ϼ̽��ϴ�."); // �ڵ� ������ �޼ҵ�� ���� ���� ����Ű ctrl + �޼ҵ�� �� ���콺�� Ŭ��
			// �µ� �޽����� ȭ�鿡 �Ѹ��� �޼ҵ� broadcast();
			broadcast("["+ nickName + "] ���� ���� �ϼ̽��ϴ�.");
			// ��ȭ���� --------------------
			 while (true) {
			    try{
			    	String text = in.readLine();
			    	server.setMsg(nickName + ":>" + text + "\\n");
			    	broadcast(nickName + ":>" + text + "\\n");
			    }catch(Exception ex) {
			    	ex.printStackTrace();
			    }finally { // finally �� ������ ���� ���� ����� �ݵ�� ��ó�� �ϴ� ���
			    	 synchronized (server.inwon) {
			    		server.inwon.remove(this);
			    		server.setMsg("["+nickName+"]���� ���� �ϼ̽��ϴ�.");
			    		broadcast("["+nickName+"]���� ���� �ϼ̽��ϴ�.");
			    	 }
			    }
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// ��� ����ڿ��� �޽����� �����ִ� ���
	private void broadcast(String str) {
		synchronized (server.inwon) { // inwon : �����
			int s = server.inwon.size(); // �����ڼ�
			for(int i=0; i<s; i++){
				ChatHandle ch = (ChatHandle) server.inwon.elementAt(i);
				server.txtList.append(str + "\n");
				ch.pw.println();
				ch.pw.flush();
			}
			
		}
		
	}
	
}
