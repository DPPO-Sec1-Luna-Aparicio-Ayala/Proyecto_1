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
	private Tarea tarea;
	
	public Actividad (String title, String descrip, String type, String fechaI,String fechaF, Participante encargado, Tarea tarea ) {
		this.titulo=title;
		this.descripcion=descrip;
		this.tipo=type;
		this.fechaInicio=fechaI;
		this.fechaFin=fechaF;
		this.responsable=encargado;
		this.tarea =tarea;
	}
	
	//M�TODOS//
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
	
	public String getFechaF() {
		return this.fechaFin;
	}
	
	public String getType() {
		return this.tipo;
	}

	public void setTiempo(long tiempoc) {
		this.tiempo = tiempoc;
	}
	
	public void setFechaInicio(String nuevaFecha) {
		this.fechaInicio = nuevaFecha;
		
	}
	
	public void setFechaFin(String nuevaFecha) {
		
		this.fechaFin = nuevaFecha;
		
	}
	public void setEncargado(Participante encargado) {
		 this.responsable=encargado;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
