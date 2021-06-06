package monitoreoTotem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import controladorTotem.ControladorTotem;

public class ErroresTotem {
	
	
	private ControladorTotem controladorTotem;
	private int puerto;
	
	
	
	public ErroresTotem(ControladorTotem controladorTotem) {
		super();
		this.controladorTotem = controladorTotem;
		this.setPuerto(controladorTotem.modelo.getNum());
		recibirError();
	}

	public void recibirError() {
		new Thread() {
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(getPuerto()); //serverSocket de totem desde el monitor
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

	public ControladorTotem getControladorTotem() {
		return controladorTotem;
	}

	public void setControladorTotem(ControladorTotem controladorTotem) {
		this.controladorTotem = controladorTotem;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto + 2060;
	}
	

}
