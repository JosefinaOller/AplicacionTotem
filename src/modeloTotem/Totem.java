package modeloTotem;



public class Totem {
	
	private int puerto;
	private int num;
	
	public Totem(int numTotem) {
		super();
		this.puerto= numTotem + 1240;
		this.num=numTotem;
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
		this.puerto = puerto;
	}




	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
