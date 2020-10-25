package co.edu.unbosque.modelo;

import java.io.Serializable;

/**
 * 
 * @author Grupo 2 - Proyecto Corte 2 - Programación 1
 * 
 *         <b>Descripcion: </b>La clase Pokemon maneja toda la información
 *         necesaria para que los pokemones puedan enfrentarse y manejarse en la
 *         interfaz
 */
public class Pokemon implements Serializable{
	private String nombre;
	private String tipo;
	private String velocidad;
	private String ataque;
	private String defensa;
	private String salud;

	/**
	 * <b>Precondicion: </b>Ingresan todos los datos necesarios para el funcionamiento del Pokemon
	 * 
	 * <b>Postcondicion: </b>Se asigna toda la información recibida a los atributos correspondientes.
	 * @param nombre Nickname del pokemon
	 * @param tipo Tipo de pokemon que determina sus ataques
	 * @param velocidad Entero que representa el nivel en velocidad
	 * @param ataque Entero que representa el nivel en ataque
	 * @param defensa Entero que representa el nivel en defensa
	 * @param salud Entero que representa el nivel en salud
	 */
	public Pokemon(String nombre, String tipo, String velocidad, String ataque, String defensa, String salud) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.velocidad = velocidad;
		this.ataque = ataque;
		this.defensa = defensa;
		this.salud = salud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	public String getAtaque() {
		return ataque;
	}

	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}

	public String getDefensa() {
		return defensa;
	}

	public void setDefensa(String defensa) {
		this.defensa = defensa;
	}

	public String getSalud() {
		return salud;
	}

	public void setSalud(String salud) {
		this.salud = salud;
	}

//	Array list poderes.

}
