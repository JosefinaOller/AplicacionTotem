package monitoreoTotem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import controladorTotem.ControladorTotem;

public class ErroresTotem {
	ControladorTotem controladorTotem= new ControladorTotem();
	
	
	
	public ErroresTotem(ControladorTotem controladorTotem) {
		super();
		this.controladorTotem = controladorTotem;
		recibirError();
	}

	public void recibirError() {
		new Thread() {
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(2060); //serverSocket de totem desde el monitor
                    while (true) {

                        Socket socket= server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String aviso=null; 
                        aviso=in.readLine();
                        if(aviso.equals("cambio"))
                        	cambioDeServidor();
                        else
                        	System.out.println("Se envio cualquier cosa");
                    }
                                                                                                                                                                                         

                } catch (Exception e) {
                	e.printStackTrace();
                    
                }
        
            }
	
        }.start();
	}

	protected void cambioDeServidor() {
		this.controladorTotem.cambiarServidor();
		
	}

}
