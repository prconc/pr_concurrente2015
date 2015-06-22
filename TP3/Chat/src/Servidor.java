import javax.swing.*; 	//biblioteca para interface grafica
import java.awt.*;		//biblioteca para interface grafica
import java.net.*;		//socket
import java.io.*;		//para buffer y printWriter
import java.awt.event.*;//para el boton 

public class Servidor {
	JFrame ventana_chat=null;  			//Ventana principal
	JButton enviar=null;				//boton enviar
	JTextField txt_mensaje = null;		//ventana donde se escribe
	JTextArea area_chat = null;			//ventana donde se muestran los mensajes
	JPanel contenedor_areachat=null;	//contenedor de la ventana donde se muestran mensajes
	JPanel contenedor_btntxt = null;	//contenedor donde va a estar el boton y la ventana de texto
	JScrollPane scroll=null;			//para que la ventana donde se muestran los mensajes tenga una barra a la derecha para ver mensajes de arriba
	
	ServerSocket servidor=null;			//creo un serverSocket
	Socket socket=null;					//creo un socket
	BufferedReader lector=null;			//buffer para leer lo que hay en el socket
	PrintWriter escritor= null; 		//para escribir en el socket
	
	public Servidor(){		
		hacerInterface();				//el constructor crea la interface grafica y arranca el programa
	}
	
	public void hacerInterface(){
		ventana_chat= new JFrame("servidor");	//creamos la ventana principal y la llamamos Servidor
		enviar= new JButton("enviar");			//creo el boton y lo llamo Enviar
		txt_mensaje = new JTextField(10);		//creo la ventana donde se escribe
		area_chat=new JTextArea(10,12);			//creo la ventana donde se muestra el chat
		scroll = new JScrollPane(area_chat);	//le pongo el scroll a la ventana del chat
		contenedor_areachat = new JPanel();		//creo el primero contenedor 
		contenedor_areachat.setLayout(new GridLayout(1,1));// el primero contenedor tiene la forma gridLayout con solo un elemento 
		contenedor_areachat.add(scroll);		//agrego el scroll a este contenedor
		contenedor_btntxt = new JPanel();		//creo el otro contenedor
		contenedor_btntxt.setLayout(new GridLayout(1,2));//tiene la forma GrindLayout con una sola fila y dos columnas
		contenedor_btntxt.add(txt_mensaje);		//grego la ventana de texto
		contenedor_btntxt.add(enviar);			//agrego el boton de enviar
		ventana_chat.setLayout(new BorderLayout());//la ventana principal tiene la forma BorderLayout
		ventana_chat.add(contenedor_areachat,BorderLayout.NORTH);//arriba pongo el contenedor con la ventana del chat
		ventana_chat.add(contenedor_btntxt,BorderLayout.SOUTH);//abajo pongo el contenedor con la ventana para escribir y el boton
		ventana_chat.setSize(300,220);			//le asigno una dimension
		ventana_chat.setVisible(true);			//para que se vea la ventana
		ventana_chat.setResizable(false);		//para que no se pueda agrandar o achicar la ventana pirncipal
		ventana_chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cuando cierro con la cruz corta la simulacion
		
		//creo un hilo principal el cual se crea el serverSocket se acepta la conexion 
		// y luego llama a los metodos leer y escribir
		Thread principal = new Thread (new Runnable (){
			public void run(){
				try{
				servidor=new ServerSocket(9000);
				while(true){
					socket=servidor.accept();
					Leer();
					Escribir();
				}
				}
				catch(Exception e){};
			}
		});
		
		principal.start();	
		
	}
	public void Leer(){
		Thread leer_hilo = new Thread(new Runnable(){
			public void run(){
				try{
					lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					while(true){
						String mensaje_recibido= lector.readLine();
						//imprimo en la vantana del chat lo que me mandaron
						area_chat.append("Cliente dice:\n"+ mensaje_recibido+"\n");
					}
				}catch(Exception e){};
			}
		});

	leer_hilo.start();
	}
	
	public void Escribir(){
		Thread escribir_hilo = new Thread(new Runnable(){
			public void run(){
				try{
					escritor=new PrintWriter(socket.getOutputStream(),true);
					enviar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
						//cuando se aprieta el boton se guarda lo que hay en la ventana para escribir en un string
						String enviar_mensaje=txt_mensaje.getText();
						escritor.println(enviar_mensaje);
						//limpiamos lo que hay en la ventana donde se escribe poniendo algo vacio""
						txt_mensaje.setText("");
						//imprimo tambien lo que yo mando en esta ventana de chat
						area_chat.append("Yo:\n"+ enviar_mensaje +"\n");
					}});
					}
				catch(Exception e){};
			}
		});
		escribir_hilo.start();
	}
public static void main(String []args){

	new Servidor();
	
}
}
