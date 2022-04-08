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
	
	//MÉTODOS//	

	//MÉTODOS//	
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
