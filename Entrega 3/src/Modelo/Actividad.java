package Modelo;

public class Actividad {
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
	
	public Participante getResponsable() {
		return this.responsable;
	}

	public void setTiempo() {
		
	}
	
	public void setHoraInicio() {
		
	}
	
	public void setHoraFin() {
		
	}
}
