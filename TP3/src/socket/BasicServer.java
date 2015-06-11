/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pato
 */
public class BasicServer implements Runnable
{
    private ServerSocket serverSocket;
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    private String sNombre;
    private VtnServer vtn;
    private Socket connection = null;
    public BasicServer(int port,String sNombre)
    {
        this.sNombre = sNombre;
        try 
        {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) 
        {
            System.out.println("Run BasicServer: "+ex);
            JOptionPane.showMessageDialog(null,ex, "Run BasicServer", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
                vtn.dispose();
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

    @Override
    public void run() 
    {        
        while(true)
        {
            try 
            {
                connection = serverSocket.accept();
                entradaDatos = new DataInputStream(connection.getInputStream());
                salidaDatos = new DataOutputStream(connection.getOutputStream());
                vtn = new VtnServer(this,sNombre);
                vtn.setVisible(true);
            } catch (IOException ex) 
            {
                try 
                {
                    System.out.println("Run BasicServer: "+ex);
                    JOptionPane.showMessageDialog(null,ex, "Run BasicServer", JOptionPane.ERROR_MESSAGE);
                    connection.close();
                    serverSocket.close();
                } catch (IOException ex1) 
                {
                    System.out.println("Run BasicServer: "+ex1);
                    JOptionPane.showMessageDialog(null,ex1, "Run BasicServer", JOptionPane.ERROR_MESSAGE);
                }
            }finally
            {
                
            }
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

    public VtnServer getVtn()
    {
        return vtn;
    }

    public void setVtn(VtnServer vtn) 
    {
        this.vtn = vtn;
    }

    public Socket getConnection() 
    {
        return connection;
    }

    public void setConnection(Socket connection) 
    {
        this.connection = connection;
    }
    
}

