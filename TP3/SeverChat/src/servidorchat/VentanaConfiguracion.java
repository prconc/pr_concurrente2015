package servidorchat;


import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaConfiguracion extends JDialog {



   private JTextField tmaximoconexiones;
   private JTextField tfPuerto;
    
    /**
     * Constructor de la ventana de configuracion inicial
     * 
     * @param padre Ventana padre
     */
    public VentanaConfiguracion(JFrame padre) {
      
    	super(padre, "Configuracion Server", true);
        
        JLabel lbmaximoconexiones = new JLabel("Maximo Conexiones:");
        JLabel lbPuerto = new JLabel("Puerto:");
        
       
        tmaximoconexiones = new JTextField("10");
        tfPuerto = new JTextField("1234");
        
        JButton btAceptar = new JButton("Aceptar");
        
        btAceptar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
             
         setVisible(false);
              
            }
        });
        
        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(20, 20, 0, 20);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        c.add(lbmaximoconexiones, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        c.add(lbPuerto, gbc);
        
    
        
        gbc.ipadx = 100;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        c.add(tmaximoconexiones, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        
        c.add(tfPuerto, gbc);
     
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        c.add(btAceptar, gbc);
        
        this.pack(); // Le da a la ventana el minimo tamaño posible
        this.setLocation(450, 200); // Posicion de la ventana
        this.setResizable(false); // Evita que se pueda estirar la ventana
        //this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Deshabilita el boton de cierre de la ventana 
        this.setVisible(true);
    return ;
    }
    
    
    public int getmaximoconexiones(){
       
    	return Integer.parseInt(this.tmaximoconexiones.getText());
    }
    
    
    
    public int getPuerto(){
        return Integer.parseInt(this.tfPuerto.getText());
    }



}
