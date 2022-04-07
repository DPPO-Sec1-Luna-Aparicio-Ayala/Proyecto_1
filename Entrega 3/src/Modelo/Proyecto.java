package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Proyecto {
	//ATRIBUTOS//
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList<String> tiposActividad;
	private String reporte;
	private ArrayList<Participante> participantes;
	private Map<String,ArrayList<Actividad>> actividades;
	private Actividad actividadActual;
	
	//Constructor//
	public Proyecto (String name, String descrip, String feIni,String feFin, ArrayList<String> typeActi) 
	{
		this.nombre=name;
		this.descripcion= descrip;
		this.fechaInicio=feIni;
		this.fechaFin=feFin;
		this.tiposActividad=typeActi;
		this.participantes = new ArrayList<Participante>();
		this.actividades =  new HashMap<String,ArrayList<Actividad>>();
		
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
		Participante responsable = encargado; 
		Actividad nuevaActividad = new Actividad(titulo, descripcionActividad, tipo, fechaI, fechaF, responsable);
		if (actividades.containsKey(nuevaActividad.getTitle())) {
			actividades.get(nuevaActividad.getTitle()).add(nuevaActividad);
		}
		else {
			ArrayList<Actividad> actis= new ArrayList<Actividad>();
			actis.add(nuevaActividad);
			actividades.put(nuevaActividad.getTitle(),actis);
		}
		System.out.println(fechaI);
		actividadActual = nuevaActividad;
	}
	
	public void terminarActividad() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		String fechaF = LocalDateTime.now().format(formatter);
		actividadActual.setFechaFin(fechaF); 
		System.out.println(fechaF);
	}
	
	public void modificarActividad(Participante newEncargado) {
		
	}
	
	public void añadirParticipante(String correo, String nombre,boolean owner) {
		
		Participante newParticipant = new Participante (correo,nombre,owner);
		this.participantes.add(newParticipant);
	}

	public ArrayList<Participante> getParticipantes(){
		return this.participantes;
	}
	
	public Map<String,ArrayList<Actividad>> getActividades(){
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
