package co.edu.unbosque.modelo;

public class Batalla {
	
	private Pokemon pokeUsuario;
	private Pokemon pokeSistema;
	private int sangreUsuario;
	private int sangreSistema;
	private int ataqueUsuario;
	private int ataqueSistema;
	private int defensaUsuario;
	private int defensaSistema;
	
	public Batalla(Pokemon pokemonSistema, Pokemon pokemonUsuario) {
		pokeUsuario=pokemonUsuario;
		pokeSistema=pokemonSistema;
		sangreUsuario = Integer.parseInt(pokeUsuario.getSalud());
		sangreSistema = Integer.parseInt(pokeSistema.getSalud());
		ataqueUsuario = Integer.parseInt(pokeUsuario.getAtaque());
		ataqueSistema = Integer.parseInt(pokeSistema.getAtaque());
		defensaUsuario = Integer.parseInt(pokeUsuario.getDefensa());
		defensaSistema = Integer.parseInt(pokeSistema.getDefensa());
		
	}
	
	public Pokemon combate () {
		switch(pokeUsuario.getTipo()) {
		case "agua":
			if(pokeSistema.getTipo()=="planta"){ataqueUsuario-=10;};
			if(pokeSistema.getTipo()=="fuego"){ataqueUsuario+=10;}break;
		case "fuego":
			if(pokeSistema.getTipo()=="agua"){ataqueUsuario-=10;};
			if(pokeSistema.getTipo()=="planta"){ataqueUsuario+=10;}break;
		case "electrico":
			if(pokeSistema.getTipo()=="roca"){ataqueUsuario-=10;};
			if(pokeSistema.getTipo()=="volador"){ataqueUsuario+=10;}break;
		case "volador":
			if(pokeSistema.getTipo()=="electrico"){ataqueUsuario-=10;};
			if(pokeSistema.getTipo()=="roca"){ataqueUsuario+=10;}break;
		case "roca":
			if(pokeSistema.getTipo()=="volador"){ataqueUsuario-=10;};
			if(pokeSistema.getTipo()=="electrico"){ataqueUsuario+=10;}break;
		case "planta":
			if(pokeSistema.getTipo()=="fuego"){ataqueUsuario-=10;};
			if(pokeSistema.getTipo()=="agua"){ataqueUsuario+=10;}break;
		
		}
		if(ataqueUsuario > ataqueSistema){
			
			int dano = (defensaSistema - ataqueUsuario);
			sangreSistema+= dano;
			pokeSistema.setSalud(""+sangreSistema);
			return pokeSistema;
			} else {
				int dano = (defensaUsuario - ataqueSistema);
				sangreUsuario+= dano;
				pokeUsuario.setSalud(""+sangreUsuario);
				return pokeUsuario;
			}
		
		
	
	}
	

}
