package co.edu.unbosque.modelo;

import java.util.ArrayList;

public class Usuario {
	private ArrayList<Pokemon> bolsillo;

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
