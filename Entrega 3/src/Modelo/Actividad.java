package Modelo;

import java.io.Serializable;

public class Actividad implements Serializable{
	//ATRIBUTOS//
	private String titulo;
	private String descripcion;
	private String tipo;
	private String fechaInicio;
	private String fechaFin;
	private Participante responsable;
	private double tiempo;
	
	public Actividad (String title, String descrip, String type, String fechaI,String fechaF, Participante encargado ) {
		this.titulo=title;
		this.descripcion=descrip;
		this.tipo=type;
		this.fechaInicio=fechaI;
		this.fechaFin=fechaF;
		this.responsable=encargado;
	}
	
	//MÉTODOS//
	public double getTiempo() {
		return this.tiempo;
	}
	public String getFechaI() {
		return this.fechaInicio;
	}
	public String getTitle() {
		return this.titulo;
	}
	
	public Participante getResponsable() {
		return this.responsable;
	}

	public void setTiempo() {
		
	}
	
	public void setFechaInicio(String nuevaFecha) {
		
	}
	
	public void setFechaFin(String nuevaFecha) {
		
		this.fechaFin = nuevaFecha;
		
	}
	public void setEncargado(Participante encargado) {
		 this.responsable=encargado;
	}
}
