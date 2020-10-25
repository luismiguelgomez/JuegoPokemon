package co.edu.unbosque.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


/**
 * @author gomez
 *
 */
public class ManejoArchivos {
	
	//Properties
	private File f;
	private Properties pro;
	private Pokemon pokemon;
	private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
	private String [][] nombresPokemones = new String [15][1];
	private Dto dto;
	
	/**
	 * <b>precondiciones:</b> variable tipo Properties llamada pro y metodo cargarFichero() 
	 * <br>
	 * <b>poscondiciones</b> Conllevar a cargarFichero()
	 * @throws Exception proveniente de cargar archivo
	 */
	public ManejoArchivos () throws Exception{
		pro = new Properties();
		pro = cargarFichero();
	}
	
	/**
	 * <b>precondiciones:</b> Variable f de tipo File, 
	 * <br>
	 * <b>poscondiciones</b> cargar el properties para despues comenzarlo a leer 
	 * @return properties null como valor por defecto
	 * @throws Exception FileNotFoundException y IOException generados gracias al properties
	 */
	public Properties cargarFichero() throws Exception {
		try {
			pro.load(new FileReader
					("archivosExternos\\agendaFisica.properties"));
			listar();
			dto = new Dto(pokemones);
		} catch (FileNotFoundException e) {
			throw new Exception("La ruta del archivo no se pudo encontrar");
		} catch (IOException e) {
			throw new Exception("Error al leer la informaci�n");
		}
		
		return null;
	}

	
	/**
	 * <b>precondiciones:</b> haber utilizado el metodo: cargarFichero
	 * <br>
	 * <b>poscondiciones</b> Listar archivos y guardarlos
	 * @return String nombresPokemones[][] 
	 */
	public String [][] listar(){
		
		
		int fila = 0;
		
		for (int i = 1; i < 15; i++) {
			String nombre = pro.getProperty("pokemon.nombre" + i);
			String tipo = pro.getProperty("pokemon.tipo" + i); 
			String velocidad = pro.getProperty("pokemon.velocidad" + i);
			String ataque = pro.getProperty("pokemon.ataque" + i);
			String defensa = pro.getProperty("pokemon.defensa" + i);
			String salud = pro.getProperty("pokemon.salud" + i);
			
			nombresPokemones[fila][0] = nombre;
			fila = fila + 1;
			
			System.out.println("pokemon "+ i + ":" + nombre);
			pokemon = new Pokemon(nombre,tipo,velocidad,ataque,defensa,salud);
			pokemones.add(pokemon);
		}
		
		return nombresPokemones;
	}

	/**
	 * get de nombre de pokemones
	 * @return String[][] con los nombre de los pokemones
	 */
	public String[][] getNombresPokemones() {
		return nombresPokemones;
	}

	/**
	 * Set de nombre de pokemones
	 * @param nombresPokemones String[][] de nombre pokemones
	 */
	public void setNombresPokemones(String[][] nombresPokemones) {
		this.nombresPokemones = nombresPokemones;
	}
	/**
	 * get de pokemones
	 * @return Arraylist de Pokemon
	 */
	public ArrayList<Pokemon> getPokemones() {
		return pokemones;
	}
	
	/**
	 * Set de pokemones
	 * @param pokemones Arraylist de pokemones
	 */
	public void setPokemones(ArrayList<Pokemon> pokemones) {
		this.pokemones = pokemones;
	}

}
