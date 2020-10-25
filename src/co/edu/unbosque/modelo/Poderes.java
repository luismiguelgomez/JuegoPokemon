package co.edu.unbosque.modelo;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Grupo 2 - Proyecto Corte 2 - Programación 1
 * 
 *         <b>Descripcion: </b> La clase Poder maneja la información de los
 *         distintos estilos de ataque que puede tener cada Pokemon dependiendo
 *         de su tipo
 */
public class Poderes {

	private String[][] fuego = new String[5][1];
	private String[][] agua = new String[5][1];
	private String[][] volador = new String[5][1];
	private String[][] electrico = new String[5][1];
	private String[][] planta = new String[5][1];
	private String[][] roca = new String[5][1];
	private ArrayList<String[][]> poderes;
	private String[][] poder;

	/**
	 * <b>Precondicion: </b> Ingresa el tipo del pokemon.
	 * <b>Postcondicion: </b> Se crea una matriz con todos los ataques por poder y se carga al metodo cargar
	 * para asignar los ataques correspondientes.
	 * @param tipo String que representa el tipo del pokemon
	 */
	public Poderes(String tipo) {

		fuego[0][0] = "fuego";
		fuego[1][0] = "Lanzallamas";
		fuego[2][0] = "Girofuego";
		fuego[3][0] = "Bomba";
		fuego[4][0] = "Embestida";

		agua[0][0] = "agua";
		agua[1][0] = " Burbuja";
		agua[2][0] = "Acua jet";
		agua[3][0] = "Hidrobomba";
		agua[4][0] = "Embestida";

		volador[0][0] = "volador";
		volador[1][0] = "LÃ¡tigo de aire";
		volador[2][0] = "RÃ¡faga";
		volador[3][0] = "Torbellino";
		volador[4][0] = "Embestida";

		electrico[0][0] = "electrico";
		electrico[1][0] = "Impactrueno";
		electrico[2][0] = "LÃ¡tigo";
		electrico[3][0] = "Onda Trueno";
		electrico[4][0] = "Embestida";

		planta[0][0] = "planta";
		planta[1][0] = "Hoja afilada";
		planta[2][0] = "floral";
		planta[3][0] = "Latigazo";
		planta[4][0] = "Embestida";

		roca[0][0] = "roca";
		roca[1][0] = "Lanzarroca";
		roca[2][0] = "placaje";
		roca[3][0] = "terremoto";
		roca[4][0] = "embestida";
		poderes = new ArrayList<String[][]>();
		poderes.add(fuego);
		poderes.add(electrico);
		poderes.add(agua);
		poderes.add(planta);
		poderes.add(volador);
		poderes.add(roca);
		cargar(tipo);
	}

	/**
	 * <b>Precondicion: </b> Utiliza la matriz anteriormente creada en el constructor, también en el constructor se
	 * llama a este método para cargar los poderes.
	 * <b>Postcondicion: </b> Carga todos los ataques correspondientes al tipo.
	 * @param tipo String que representa el tipo del pokemon
	 */
	public void cargar(String tipo) {

		for (String[][] p : poderes) {
			if (tipo == p[0][0]) {
				poder = p;
			}
		}

	}

	public String[][] getPoder() {
		return poder;
	}

	public void setPoder(String[][] poder) {
		this.poder = poder;
	}

	public ArrayList<String[][]> getPoderes() {
		return poderes;
	}

	public void setPoderes(ArrayList<String[][]> poderes) {
		this.poderes = poderes;
	}

}
