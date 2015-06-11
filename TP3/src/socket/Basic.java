/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Pato
 */
public class Basic
{
    private ServerSocket serverSocket;
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    private String sNombre;
    
        public String recibir()
    {
        try 
        {
            // Lee un mensaje enviado por el cliente
            String mensajeRecibido = entradaDatos.readUTF();
            return mensajeRecibido;
        } catch (IOException ex) 
        {

            // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
            try {
                entradaDatos.close();
                salidaDatos.close();
            } catch (IOException ex2) 
            {
                System.out.println("Recibir BasicServer: "+ex);
                JOptionPane.showMessageDialog(null,ex, "Recibir BasicServer", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
    
    public void enviar(String sTexto)
    {
        try 
        {
            salidaDatos.writeUTF(sTexto);
        } catch (IOException ex) 
        {
            System.out.println("Enviar BasicServer: "+ex);
            JOptionPane.showMessageDialog(null,ex, "Enviar BasicServer", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ServerSocket getServerSocket() 
    {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) 
    {
        this.serverSocket = serverSocket;
    }

    public DataInputStream getEntradaDatos() 
    {
        return entradaDatos;
    }

    public void setEntradaDatos(DataInputStream entradaDatos) 
    {
        this.entradaDatos = entradaDatos;
    }

    public DataOutputStream getSalidaDatos() 
    {
        return salidaDatos;
    }

    public void setSalidaDatos(DataOutputStream salidaDatos) 
    {
        this.salidaDatos = salidaDatos;
    }

    public String getsNombre() 
    {
        return sNombre;
    }

    public void setsNombre(String sNombre) 
    {
        this.sNombre = sNombre;
    }
    
    
    
}
