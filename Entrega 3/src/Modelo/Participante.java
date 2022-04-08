package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Participante implements Serializable{
	//ATRIBUTOS//
	private String correo;
	private String nombre;
	private boolean duenio;
	
	public Participante(String mail, String name, boolean owner) {
		this.correo=mail;
		this.nombre= name;
		this.duenio=owner;
	}
	
<<<<<<< HEAD
	//MÉTODOS//	
=======
	//MÉTODOS//
	public ArrayList<Actividad> getActividades(){
		return actividades;
	}
	
	public void setActividades(Actividad actividad) {
		actividades.add(actividad);
	}
>>>>>>> b8233ed7db6aab917460472c71cfc3703cf93bbc
	
	public void setEsDueño() {
		
	}
	
	public String getCorreo() {
		return this.correo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean esDuenio() {
		return this.duenio;
	}
}
