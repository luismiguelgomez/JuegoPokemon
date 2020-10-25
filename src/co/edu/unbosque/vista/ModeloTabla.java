package co.edu.unbosque.vista;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	String[] titulos;
	Object[][] datos;

	//
	// Determina el modelo con el que se va a construir la tabla
	// @param datos
	// @param titulos
	//
	/**
	 * <b>Precondiciones:</b> Tener como parametros Object[][]datos, String []
	 * titulos <b>Poscondiciones:</b> Iniciar el programa por medio de Controlador
	 * 
	 * @param datos   Object[][]
	 * @param titulos String []
	 */
	public ModeloTabla(Object[][] datos, String[] titulos) {
		super();
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}

	/**
	 * <b>Precondiciones:</b> Tener como parametros String[] args
	 * <b>Poscondiciones:</b> Iniciar el programa por medio de Controlador
	 * 
	 * @param row    entero
	 * @param column entero
	 */
	public boolean isCellEditable(int row, int column) {
		// Definimos si una celda puede ser o no editable
		if (column == 0) {
			return false;
		} else {
			return true;
		}
	}
}
