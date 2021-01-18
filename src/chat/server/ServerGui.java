package chat.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener{

	
	JTextArea jta = new JTextArea(40,25);
	JTextField jtf = new JTextField(25);
	
	ServerBackground severBackground = new ServerBackground();
	
	public ServerGui() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서버");
		
		severBackground.setGui(this);
		severBackground.Setting();
		
	
	}
	
	public static void main(String[] args) {
		new ServerGui();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String msg = jtf.getText() + "\n";
	jta.append(msg);
	jtf.setText("");
	
	severBackground.sendMessage(msg);
	
	
	
	}

	public void appendMsg(String msg) {
		jta.append(msg);
	}
	
	
	
}
