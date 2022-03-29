package Modelo;

import java.util.ArrayList;

public class Proyecto {
	//ATRIBUTOS//
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList<String> tiposActividad;
	private Reporte reporte;
	private ArrayList<Participante> participantes;
	private ArrayList<Actividad> actividades;
	
	//MÉTODOS//
	public String generarReporte() {
		
	}
	
	public void nuevaActividad() {
		
	}
	
	public void modificarActividad() {
		
	}
	
	public void añadirParticipante() {
		
	}

	public ArrayList<Participante> getParticipantes(){
		return participantes;
	}
	
	public ArrayList<Actividad> getActividades(){
		return actividades;
	}
}
