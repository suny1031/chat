package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBackground {

	Socket socket;
	
	DataInputStream in;
	DataOutputStream out;
	
	ClientGui gui;
	String msg;
	
	public final void setGui(ClientGui gui) {
		this.gui = gui;
		
	}
	public void connet() {
		try {
			socket = new Socket("192.168.0.103",7979);
			System.out.println("서버에 연결 됨");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			
			while(in != null) {
				msg = in.readUTF();
				gui.appendMsg(msg);
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String msg2) {
		try {
			out.writeUTF("클라이언트 : " + msg2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
