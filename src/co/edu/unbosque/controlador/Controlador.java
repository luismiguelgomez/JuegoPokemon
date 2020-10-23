package co.edu.unbosque.controlador;

import javax.swing.JPanel;

import co.edu.unbosque.modelo.ManejoArchivos;
import co.edu.unbosque.vista.Ataque;
import co.edu.unbosque.vista.MarcoPrincipal;
import co.edu.unbosque.vista.PanelSeleccion;

public class Controlador {
	private  MarcoPrincipal ventanaPrincipal;
	private  Ataque panelAtaque;
	private String[][] nombrePokemones;
	private PanelSeleccion panel;
	private ManejoArchivos claseArchivos = new ManejoArchivos();

	public Controlador() throws Exception {
		claseArchivos = new ManejoArchivos();
		nombrePokemones = claseArchivos.getNombresPokemones();
		panel = new PanelSeleccion(nombrePokemones);
		panelAtaque = new Ataque();
		ventanaPrincipal = new MarcoPrincipal(panel);	
		


	}
	
	
	public  void cerrar() {
		System.exit(0);
		//ventanaPrincipal.dispose();
	}
//	public  void abrirPanel(JPanel panel) {
//
//		if(panel.getClass().getName()==panelInicial.getClass().getName()) {
//			ventanaPrincipal.add(panelAtaque);
//			ventanaPrincipal.remove(panel);
//		} else {
//			ventanaPrincipal.add(panelInicial);
//			ventanaPrincipal.remove(panel);
//		}
//	}
	

}
