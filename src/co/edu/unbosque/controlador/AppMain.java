package co.edu.unbosque.controlador;

/**
 * 
 * @author gomez
 *
 */
public class AppMain {

	/**
	 * <b>Precondiciones:</b> Tener como parametros String[] args
	 * <b>Poscondiciones:</b> Iniciar el programa por medio de Controlador
	 * @param args normal en el main 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//		Poderes p = new Poderes();
			Controlador controlador = new Controlador();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
