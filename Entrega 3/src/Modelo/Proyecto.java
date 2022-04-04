package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Proyecto {
	//ATRIBUTOS//
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList<String> tiposActividad;
	private String reporte;
	private ArrayList<Participante> participantes;
	private ArrayList<Actividad> actividades;
	
	//Constructor//
	public Proyecto (String name, String descrip, String feIni,String feFin, ArrayList<String> typeActi) 
	{
		this.nombre=name;
		this.descripcion= descrip;
		this.fechaInicio=feIni;
		this.fechaFin=feFin;
		this.tiposActividad=typeActi;
		this.participantes = new ArrayList<Participante>();
		this.actividades = new ArrayList<Actividad>();
		
	}
	
	//MÉTODOS//
	public String generarReporte() {
		return null;
		
	}
	
	public void nuevaActividad(String titulo, String descripcionActividad, String tipo, Participante encargado) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		String fechaI = LocalDateTime.now().format(formatter); //Hora/fecha inicio se autocompleta...  
		String fechaF = "" ; //Hora/fecha fin se rellenaria al oprimir acabar actividad... 
		Participante responsable = encargado; //Autocompletado
		
		Actividad nuevaActividad = new Actividad(titulo, descripcionActividad, tipo, fechaI, fechaF, responsable);
		System.out.println(fechaI);
		
	}
	
	public void modificarActividad() {
		
	}
	
	public void añadirParticipante(String correo, String nombre,boolean owner) {
		
		Participante newParticipant = new Participante (correo,nombre,owner);
		this.participantes.add(newParticipant);
	}

	public ArrayList<Participante> getParticipantes(){
		return this.participantes;
	}
	
	public ArrayList<Actividad> getActividades(){
		return this.actividades;
	}
	
	public ArrayList<String> gettypeActividades(){
		return this.tiposActividad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
