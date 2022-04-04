package Modelo;

import java.util.ArrayList;

public class Participante {
	//ATRIBUTOS//
	private String correo;
	private String nombre;
	private boolean due�o;
	private ArrayList<Actividad> actividades;
	
	public Participante(String mail, String name, boolean owner) {
		this.correo=mail;
		this.nombre= name;
		this.due�o=owner;
		this.actividades = new ArrayList<Actividad>();
	}
	
	//M�TODOS//
	public ArrayList<Actividad> getActividades(){
		return actividades;
	}
	
	public void setActividades() {
		
	}
	
	public void setEsDue�o() {
		
	}
	public String getCorreo() {
		return this.correo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
