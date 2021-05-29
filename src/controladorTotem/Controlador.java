package controladorTotem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import modeloTotem.Totem;
import vistaTotem.Vista;

public class Controlador implements ActionListener {
	
	private Vista vistaTotem;
	private Totem modelo;
	
	public Controlador () {
		this.vistaTotem = new Vista();
		vistaTotem.setVisible(true);
		vistaTotem.setActionlistener(this);
		this.modelo= new Totem(Integer.parseInt(JOptionPane.showInputDialog("Escribe el n�mero de t�tem")));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if(comando.equalsIgnoreCase("Aceptar")) {
			String documento=vistaTotem.textDocumento.getText();
			try {
				comunicacionTotem(documento,modelo.getPuerto());
			} catch (IOException e1) {
				try {
					comunicacionTotem(documento,modelo.getPuerto()+200);
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null,"ERROR, NO SE PUDO CONECTAR EN NINGUN PUERTO EL TOTEM, POR FAVOR INTENTA DE NUEVO", "ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
	}
	
	

	private void comunicacionTotem(String documento, int puerto) throws UnknownHostException,IOException   {
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
        	JOptionPane.showMessageDialog(null,"�No es v�lido el documento! Escriba de nuevo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
			
	

	public static void main(String[] args) {
		Controlador c= new Controlador();
	}
	

}