package main;

import controladorTotem.ControladorTotem;
import monitoreoTotem.ErroresTotem;

public class Main {

	public static void main(String[] args) {
		ControladorTotem controlador= new ControladorTotem();
		ErroresTotem errores= new ErroresTotem(controlador);
	}

}
