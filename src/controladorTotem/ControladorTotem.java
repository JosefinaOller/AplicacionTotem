package controladorTotem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modeloTotem.Totem;

import vistaTotem.VistaTotem;

public class ControladorTotem implements ActionListener {
	
	private VistaTotem vistaTotem;
	public Totem modelo;
	private int cambio=0; 
	
	public ControladorTotem () {
		this.vistaTotem = new VistaTotem();
		vistaTotem.setVisible(true);
		vistaTotem.setActionlistener(this);
		this.modelo= new Totem(Integer.parseInt(JOptionPane.showInputDialog("Escribe el número de tótem")));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equalsIgnoreCase("Aceptar")) {
			String documento=vistaTotem.textDocumento.getText();
			if(modelo.isValid(documento)) {
				try {
					Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),modelo.getPuerto()); 
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(documento);
			        out.close();
			        socket.close();
			        
			        
				} catch (UnknownHostException e1) {
		        	//JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 1.TOTEM", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				} catch (IOException e1) {
		        	//JOptionPane.showMessageDialog(null,"ERROR COMUNICACION 2.TOTEM", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
			
				vistaTotem.limpiarDNI();
		    	JOptionPane.showMessageDialog(null,"Turno asignado! Tome asiento");
			}
			else {
	        	JOptionPane.showMessageDialog(null,"¡No es válido el documento! Escriba de nuevo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
	}
	
	
	public void cambiarServidor() {
		if(cambio==0) { //cambiare el puerto una sola vez 
			System.out.println("Totem cambiando de puerto...");
			this.modelo.setPuerto(modelo.getPuerto()+200);
			System.out.println(modelo.getPuerto());
			cambio=1;
		}
		
		
	}

	
}
