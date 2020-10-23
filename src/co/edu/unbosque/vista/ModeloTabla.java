package co.edu.unbosque.vista;
import javax.swing.table.DefaultTableModel;
public class ModeloTabla extends DefaultTableModel{

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
	 public ModeloTabla(Object[][] datos, String[] titulos) {
	  super();
	  this.titulos=titulos;
	  this.datos=datos;
	  setDataVector(datos, titulos);
	 }
	 

	 public boolean isCellEditable (int row, int column)
	 {
	  //Definimos si una celda puede ser o no editable
	  if (column ==0){   
	         return false; 
	        }else{
	         return true;
	        }
	 }
	}

