/**
 * 
 */
package co.edu.unbosque.controlador;

import co.edu.unbosque.modelo.ManejoArchivos;
import co.edu.unbosque.vista.pnlPanelSeleccion;

/**
 * @author gomez
 *
 */
public class Controller {

	private String[][] nombrePokemones;
	private pnlPanelSeleccion panel;
	private ManejoArchivos claseArchivos = new ManejoArchivos();
	
	/**
	 * @throws Exception
	 * 
	 */
	public Controller() throws Exception {
		
		claseArchivos = new ManejoArchivos();
		nombrePokemones = claseArchivos.getNombresPokemones();
		int fila = 5;
		int columna = 1;
		panel = new pnlPanelSeleccion(nombrePokemones);
//		nombrePokemones = claseArchivos.listar();
		
		
	}

}
