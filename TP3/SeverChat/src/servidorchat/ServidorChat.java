
package servidorchat;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;



/**
 * Servidor para el chat.
 * 
 */

public class ServidorChat extends JFrame {
	private static int puerto;
	private static int maximoconexiones;
    
        
public ServidorChat(){
	
	// Ventana de configuracion inicial
    
		VentanaConfiguracion vc = new VentanaConfiguracion(this);
	    maximoconexiones = vc.getmaximoconexiones();
	    puerto = vc.getPuerto();
	    
	    System.out.println("Tome de la vista conexiones = " + maximoconexiones +" y el puerto es ="+puerto );
	
}
	
	
	
	public static void main(String[] args) {
        
       
    	
		 ServidorChat s = new ServidorChat();
    	
    	 //int puerto =1234;
        //int maximoConexiones = 10; // Maximo de conexiones simultaneas
       
		ServerSocket servidor = null; 
        Socket socket = null;
        MensajesChat mensajes = new MensajesChat();
        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoconexiones);
            
            // Bucle infinito para esperar conexiones
            while (true) {
           
                socket = servidor.accept();
             
                ConexionCliente cc = new ConexionCliente(socket, mensajes);
                cc.start();
                
            }
        } catch (IOException ex) {
        	System.out.println("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
                System.out.println("intento cerrarrrrrrrrrrrrr");
            
            } catch (IOException ex) {
            	System.out.println("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
	
	}
