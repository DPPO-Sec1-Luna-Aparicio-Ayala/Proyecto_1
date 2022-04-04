package Modelo;

import java.util.ArrayList;

public class Participante {
	//ATRIBUTOS//
	private String correo;
	private String nombre;
	private boolean dueño;
	private ArrayList<Actividad> actividades;
	
	public Participante(String mail, String name, boolean owner) {
		this.correo=mail;
		this.nombre= name;
		this.dueño=owner;
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
}
