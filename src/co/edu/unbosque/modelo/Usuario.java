package co.edu.unbosque.modelo;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Grupo 2 - Proyecto Corte 2 - Programación 1
 * 
 *         <b>Descripcion: </b> La clase usuario se contiene la información de
 *         todos los pokemones y sus respectivos poderes
 * 
 */
public class Usuario {

	private ArrayList<Pokemon> bolsillo;

	/**
	 * <b>Precondicion: </b>Ingresa un bolsillo, que son los 5 pokemones que el usuario podrá usar en batalla
	 * <b>Postcondicion: </b>Se asigna el bolsillo a la variable correspondiente para ser utilizada por el Usuario
	 * @param bolsillo ArrayList con modificador de tipo Pokemon
	 */
	public Usuario(ArrayList<Pokemon> bolsillo) {
		super();
		this.bolsillo = bolsillo;
	}

	public ArrayList<Pokemon> getBolsillo() {
		return bolsillo;
	}

	public void setBolsillo(ArrayList<Pokemon> bolsillo) {
		this.bolsillo = bolsillo;
	}

}
