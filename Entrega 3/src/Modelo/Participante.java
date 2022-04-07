package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Participante implements Serializable{
	//ATRIBUTOS//
	private String correo;
	private String nombre;
	private boolean duenio;
	private ArrayList<Actividad> actividades;
	
	public Participante(String mail, String name, boolean owner) {
		this.correo=mail;
		this.nombre= name;
		this.duenio=owner;
		this.actividades = new ArrayList<Actividad>();
	}
	
	//MÉTODOS//
	public ArrayList<Actividad> getActividades(){
		return actividades;
	}
	
	public void setActividades() {
		
	}
	
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
