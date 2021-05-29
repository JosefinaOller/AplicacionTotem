package modelo;



public class Totem {
	
	private int puerto;
	
	public Totem(int puerto) {
		super();
		this.setPuerto(puerto);
	}




	public boolean isValid(String document) {  //chequea si el documento es valido o no
		boolean retorno = false;
		
		if (document.length() <=8 && !document.equals(""))
			retorno = true;
		
		return retorno;
		
	}




	public int getPuerto() {
		return puerto;
	}




	public void setPuerto(int puerto) {
		this.puerto = puerto + 1240;
	}
	
	
}
