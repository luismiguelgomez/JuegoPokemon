package co.edu.unbosque.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * @author Juan Vargas
 *
 */
public class Dto {

	private File archivo;

	/**
	 * <b>precondiciones:</b> tener la ruta hacia datos.dat
	 * <br>
	 * <b>poscondiciones</b> crear el archivo .dat
	 * @param pokemones ArrayList de Pokemon
	 */
	public Dto(ArrayList<Pokemon> pokemones) {

		archivo = new File("archivosExternos\\datos.dat");
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mostrarPokemon(pokemones);
	}

	/**
	 * <b>precondiciones:</b> pokemones ArrayList de Pokemon
	 * <br>
	 * <b>poscondiciones</b> Toma array list de pokemones, lo muestra en el archivo y cierra archivo 
	 * @param pokemones ArrayList de Pokemon
	 */
	public void mostrarPokemon(ArrayList<Pokemon> pokemones) {
		FileOutputStream fo;
		ObjectOutputStream ob;
		try {
			fo = new FileOutputStream(archivo);
			ob = new ObjectOutputStream(fo);

			ob.writeObject(pokemones);

			ob.close();
			fo.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}