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
	Vector inwon;  // 인원수 카운트
	/* ArrayList 를 사용하지 않고 Vector 를 사용하는 것은
	 * 동기화 지원때문이다. 소켓 프로그램은 동기화 지원이 필요하다.
	 */
	
	public SwingChatServer(){
		super("Chatting Server");
		txtList = new JTextArea();
		btnExit = new JButton("서버종료");
		
		add(txtList, "Center");
		add(btnExit, "South");
		setSize(350, 650);
		setVisible(true);
		// 이벤트 처리 -------------------------
		super.setDefaultCloseOperation(EXIT_ON_CLOSE); // 윈도우창 닫기 이벤트
		btnExit.addActionListener(this);
		inwon = new Vector(); // 벡터에서 제네릭을 제거하면 모든 타입 수용
		serverStart();
		
	}
	
	private void serverStart() {
		final int PORT = 7500;
		try{
			ss = new ServerSocket(PORT);
			System.out.println("서버가 시작되었습니다.");
			txtList.append("서버가 시작되었습니다.");
			txtList.setFont(new Font("굴림체", Font.BOLD, 16)); // 16 는 크기
			while (true) {
				Socket socket = ss.accept();
				String str = socket.getInetAddress().getHostAddress();
				txtList.append(str);
				// 병행처리를 하기 위한 클라이언트 객체생성(사용자 정의 클래스)
				
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
	} // 생성자 끝
	
	@Override
	public void run() {
		String nickName = null;
		try{
			nickName = in.readLine();
			// 서버에서 메시지 남기는 기능을 하기위해... setMsg() 선언하여 자동생성 시도
			server.setMsg("["+ nickName + "] 님이 입장 하셨습니다."); // 자동 생성된 메소드로 가기 위한 단축키 ctrl + 메소드명 을 마우스로 클릭
			// 셋된 메시지를 화면에 뿌리는 메소드 broadcast();
			broadcast("["+ nickName + "] 님이 입장 하셨습니다.");
			// 대화시작 --------------------
			 while (true) {
			    try{
			    	String text = in.readLine();
			    	server.setMsg(nickName + ":>" + text + "\\n");
			    	broadcast(nickName + ":>" + text + "\\n");
			    }catch(Exception ex) {
			    	ex.printStackTrace();
			    }finally { // finally 는 에러가 나든 정상 종료든 반드시 거처야 하는 블록
			    	 synchronized (server.inwon) {
			    		server.inwon.remove(this);
			    		server.setMsg("["+nickName+"]님이 입장 하셨습니다.");
			    		broadcast("["+nickName+"]님이 입장 하셨습니다.");
			    	 }
			    }
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// 모든 사용자에게 메시지를 보내주는 기능
	private void broadcast(String str) {
		synchronized (server.inwon) { // inwon : 사람수
			int s = server.inwon.size(); // 접속자수
			for(int i=0; i<s; i++){
				ChatHandle ch = (ChatHandle) server.inwon.elementAt(i);
				server.txtList.append(str + "\n");
				ch.pw.println();
				ch.pw.flush();
			}
			
		}
		
	}
	
}
