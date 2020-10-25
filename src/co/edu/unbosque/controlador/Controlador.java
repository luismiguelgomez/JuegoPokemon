package co.edu.unbosque.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import co.edu.unbosque.modelo.ManejoArchivos;
import co.edu.unbosque.modelo.Pokemon;
import co.edu.unbosque.vista.Ataque;
import co.edu.unbosque.vista.MarcoPrincipal;
import co.edu.unbosque.vista.PanelSeleccion;

/**
 * 
 * @author gomez
 *
 */
public class Controlador implements ActionListener {
	private MarcoPrincipal ventanaPrincipal;
	Ataque panelAtaque;
	private ArrayList<String[]> pokemonesprueba;
	private String[][] nombrePokemones;
	private PanelSeleccion panel;
//	private Timer lapso;
	private ManejoArchivos claseArchivos = new ManejoArchivos();

	/**
	 * <b>Precondiciones:</b> Tener credas las siguientes variables:<br>
	 * 1. lapso, Tipo: Timer<br>
	 * 2. nombrePokemones, Tipo: String[][]<br>
	 * 3. panel, Tipo: PanelSeleccion<br>
	 * 4. ventanaPrincipal, Tipo: MarcoPrincipal<br>
	 * <b>Poscondiciones:</b> Iniciar el programa por medio de Controlador
	 * @throws Exception proveniento por Timer
	 */
	public Controlador() throws Exception {
//		lapso = new Timer();
		claseArchivos = new ManejoArchivos();
		nombrePokemones = claseArchivos.getNombresPokemones();
		panel = new PanelSeleccion(nombrePokemones);
		ventanaPrincipal = new MarcoPrincipal(panel);
		pokemonesprueba = new ArrayList<String[]>();
		String[]pp = {"one","two","tree"};
		pokemonesprueba.add(pp);
		panelAtaque = new Ataque(nombrePokemones, pokemonesprueba);
		asignarOyentes1();
//		lapso.scheduleAtFixedRate(tarea, 1000, 1000);
	}
	
		private void asignarOyentes1() {
		panelAtaque.getBtnAccion().addActionListener(this);
		
	}

		TimerTask tarea = new TimerTask() {
			
			public void run() {
				if(panel.getBlnCerrar()) {
					panel.setBlnCerrar(false);
					
				}
				
				if(panel.isBlnAtaque()) {
					panelAtaque = new Ataque(nombrePokemones, pokemonesprueba);
					ventanaPrincipal.remove(panel);
					ventanaPrincipal.add(panelAtaque);
					panel.setBlnAtaque(false);
				}
				
				if(panel.isBlnTerminar()) {
					System.exit(0);
				}
				
//				if(panelAtaque.isBlnCerrarPanel()) {
//					ventanaPrincipal.remove(panelAtaque);
//					ventanaPrincipal.add(panel);
//				}
				
			}
		};
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == panelAtaque.getBtnAccion()) {
			System.out.println("toco accion");
		}
	}
	

}
