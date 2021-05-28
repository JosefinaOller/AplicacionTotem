package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class totem {
	
	
	public totem() {

	}
	
	
	public boolean isValid(String document) {  //chequea si el documento es valido o no
		boolean retorno = false;
		
		if (document.length() <=8 && !document.equals(""))
			retorno = true;
		
		return retorno;
		
	}
	

}
