import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.EventObject;


public class Servidor extends JFrame implements KeyListener {

	private JPanel contentPane;
	private JButton btnEnviar;
	private TextArea areaEnvio;
	private TextArea areaChat;
	private Cliente client;
	
	private ServerSocket server = null;
	private Socket connection = null;
	private BufferedReader receptor = null;
	private PrintWriter emisor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Servidor();
	}
	
	public Servidor(){
		Launch();
	}
	
	public void Launch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 100, 615, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(435, 247, 117, 25);
		contentPane.add(btnEnviar);
		
		areaEnvio = new TextArea("\n");
		areaEnvio.setBounds(60, 194, 332, 97);
		contentPane.add(areaEnvio);
		
		areaEnvio.addKeyListener(this);
		
		areaChat = new TextArea();
		areaChat.setBounds(60, 10, 497, 167);
		areaChat.setEditable(false);
		contentPane.add(areaChat);
		
		
		
		try {
			server = new ServerSocket(2346);
			this.setVisible(true);
			
			while(true){
				connection = server.accept();
				Thread threadReceptor = new Thread(new Runnable(){
					public void run() {
						try {
							receptor = new BufferedReader(new InputStreamReader(connection.getInputStream()));
							while(true){
								String message = receptor.readLine();
								if(message != null){
									actualizar(message);
								}
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
				});
				Thread threadEmisor = new Thread(new Runnable(){
					public void run(){
						try {
							emisor = new PrintWriter(connection.getOutputStream(),true);
							btnEnviar.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									enviar();
								}
							});
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				
				threadReceptor.start();
				threadEmisor.start();
			}
			
			
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	void actualizar(String s){
		
		areaChat.append('\n' + s);
	}
	public void enviar(){
		if(emisor != null){
			String message = areaEnvio.getText();
			if(message.length()>0){
				if(message.toCharArray()[0] == '\n'){
					message = message.substring(1);
				}
				emisor.println("Servidor dice: " + message);
				actualizar("Servidor dice: "+ message);
				areaEnvio.setText("");
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10){
			if(e.isShiftDown()){
				areaEnvio.append("\n");
			}
			else{
				enviar();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
