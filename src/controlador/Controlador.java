package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import modelo.totem;
import vista.Vista;

public class Controlador implements ActionListener {
	
	private Vista vistaTotem;
	private totem modelo;
	
	
	public Controlador () {
		this.vistaTotem = new Vista();
		vistaTotem.setActionlistener(this);
		this.modelo= new totem();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equalsIgnoreCase("Aceptar")) {
			String documento=vistaTotem.textDocumento.getText();
			if(modelo.isValid(documento)) {
				
				try {
					Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),1236); //puerto 1236 es para el totem
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true); //inicia el flujo para enviar los mensajes
	
					out.println(documento); 
			        out.close();
			        socket.close();
			        
			        
				} catch (UnknownHostException e1) {
	            	JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 1.TOTEM", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				} catch (IOException e1) {
	            	JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 2.TOTEM", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					//e1.printStackTrace();
				}
			
				vistaTotem.limpiarDNI();
            	JOptionPane.showMessageDialog(null,"Turno asignado! Tome asiento");
			}
			else {
            	JOptionPane.showMessageDialog(null,"¡No es válido el documento! Escriba de nuevo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		Controlador c= new Controlador();
	}
	

}
