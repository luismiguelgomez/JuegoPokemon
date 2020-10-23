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
	private ArrayList<String> pokemones = new ArrayList<String>();
	private String [][] nombresPokemones = new String [15][1];
	
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
					("src/archivosExternos/agendaFisica.properties"));
			listar();
		} catch (FileNotFoundException e) {
			throw new Exception("La ruta del archivo no se pudo encontrar");
		} catch (IOException e) {
			throw new Exception("Error al leer la informaci�n");
		}
		
		return null;
	}

	/**
	 * <b>precondiciones:</b> haber utilizado el metodo  cargarFichero()
	 * <br>
	 * <b>poscondiciones</b> Listar archivos y guardarlos
	 * @throws Exception 
	 */
	public String [][] listar() throws Exception {
		
		
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
			
			pokemones.add(nombre);
			pokemones.add(tipo);
			pokemones.add(velocidad);
			pokemones.add(ataque);
			pokemones.add(defensa);
			pokemones.add(salud);
		}
		
		return nombresPokemones;
	}

	public String[][] getNombresPokemones() {
		return nombresPokemones;
	}

	public void setNombresPokemones(String[][] nombresPokemones) {
		this.nombresPokemones = nombresPokemones;
	}

}
