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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pato
 */
public class BasicClient implements Runnable
{
    private String host;
    private String sNombre;
    private int port;
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    VtnCliente vtn;
    Socket connection = null;

    public BasicClient(String host, int port,String sNombre)
    {
        this.host = host; 
        this.port = port;
        this.sNombre = sNombre;
    }
    @Override
    public void run() 
    {        
        try 
        {
            connection = new Socket(host, port);
            entradaDatos = new DataInputStream(connection.getInputStream());
            salidaDatos = new DataOutputStream(connection.getOutputStream());
            vtn = new VtnCliente(this,sNombre);
            vtn.setVisible(true);
            vtn.Recibir();
        } catch (IOException ex) 
        {
            System.out.println("Run BasicClient: "+ex);
            JOptionPane.showMessageDialog(null,ex, "Run BasicClient", JOptionPane.ERROR_MESSAGE);
            try 
            {
                connection.close();                
            } catch (IOException ex2) 
            {
                System.out.println("Run BasicClient: "+ex2);
            JOptionPane.showMessageDialog(null,ex2, "Run BasicClient", JOptionPane.ERROR_MESSAGE);
            }
        }finally
        {
            
        }       
    }
    public String Recibir()
    {
        String mensaje = "";
        try 
        {
            mensaje = entradaDatos.readUTF();
            return mensaje;
        } catch (IOException ex) 
        {
            System.out.println("RecibirCliente: "+ex);
            JOptionPane.showMessageDialog(null,ex, "RecibirCliente", JOptionPane.ERROR_MESSAGE);
            vtn.dispose();
        } catch (NullPointerException ex) 
        {
            System.out.println("RecibirCliente: "+ex);
            JOptionPane.showMessageDialog(null,ex, "RecibirCliente", JOptionPane.ERROR_MESSAGE);
            vtn.dispose();
        }
        return null;
    }
    
    void enviar(String sTexto) 
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
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public DataInputStream getEntradaDatos() {
        return entradaDatos;
    }

    public void setEntradaDatos(DataInputStream entradaDatos) {
        this.entradaDatos = entradaDatos;
    }

    public DataOutputStream getSalidaDatos() {
        return salidaDatos;
    }

    public void setSalidaDatos(DataOutputStream salidaDatos) {
        this.salidaDatos = salidaDatos;
    }

    public Socket getConnection() {
        return connection;
    }

    public void setConnection(Socket connection) {
        this.connection = connection;
    }
}
