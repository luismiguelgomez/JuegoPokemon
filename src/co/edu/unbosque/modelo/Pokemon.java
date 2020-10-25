package co.edu.unbosque.modelo;


public class Pokemon {
	private String nombre;
	private String tipo;
	private String velocidad;
	private String ataque;
	private String defensa;
	private String salud;
    
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
