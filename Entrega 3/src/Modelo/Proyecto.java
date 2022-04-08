package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Proyecto implements Serializable{
	//ATRIBUTOS//
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList<String> tiposActividad;
	private String reporte;
	private ArrayList<Participante> participantes;
	private Map<String,ArrayList<Actividad>> actividades;
	public Actividad actividadActual;
	
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
	public void generarReporte() {
		//ArrayList<HashMap>reportefinal = new ArrayList<HashMap>();
		HashMap<String,HashMap<String,Double>> reporteActividad = new HashMap<String,HashMap<String,Double>>();
		for(ArrayList<Actividad>actividadlista: actividades.values()) {
			for(Actividad actual:actividadlista) {
				if (reporteActividad.containsKey(actual.getType())) {

					HashMap<String,Double>tiempoParticipantes=reporteActividad.get(actual.getType());// obtiene el mapa de participantes y sus tiempos por actividad
					String mail= actual.getResponsable().getCorreo();
					if(tiempoParticipantes.containsKey(mail)) {
						double tiempoHastaAhora=tiempoParticipantes.get(mail);
						double tiempoASumar=actual.getTiempo();
						tiempoHastaAhora+=tiempoASumar;
						tiempoParticipantes.put(mail, tiempoHastaAhora); 
					}
					else {
						tiempoParticipantes.put(mail, actual.getTiempo());
						
					}
				}
				else {
					HashMap<String,Double>tiempoParticipante= new HashMap<String,Double>();
					tiempoParticipante.put(actual.getResponsable().getCorreo(), actual.getTiempo());
					reporteActividad.put(actual.getType(), tiempoParticipante);
				}
		}
			
			
			
			/*if(reporteActividad.containsKey(tividad)) {
				ArrayList<Actividad> tipoActividad = actividades.get(tividad);
				for(Actividad actual:tipoActividad) {
				
				String participant=actual.getResponsable().getNombre();
				if(reporteActividad.containsKey(participant))	{
					double tiempoContado= reporteActividad.get(participant);
					tiempoContado+= actual.getTiempo();
					reporteActividad.put(participant, tiempoContado);
				}
				else {
					reporteActividad.put(participant, actual.getTiempo());
				} 
				
						
				}
			}*/
		}
		System.out.println("REPORTE POR TIPO ACTIVIDAD");
		for(String tipo:reporteActividad.keySet()) {
			System.out.println("Tipo Atividad: "+ tipo);
			int count =1;
			for(String correo:reporteActividad.get(tipo).keySet()) {
				System.out.println("\n"+count+ ". "+correo+"\tTiempo: "+reporteActividad.get(tipo).get(correo));
				count+=1;
			}
			
		}
		// 
		
		HashMap<String, String> reporteHPersonas = new HashMap<String, String>();
		HashMap<String, String> Apoyo = new HashMap<String, String>();
		for(ArrayList<Actividad> Actividades: actividades.values()) {
			for(Actividad actual: Actividades) {
			
			Participante personas = actual.getResponsable();
			String nom = personas.getNombre();
			String corr = personas.getCorreo();
			double tiempo_tot = actual.getTiempo();
			
			String llave = nom+corr;
			String contenido = "Nombre: " + nom + "\n" + "Correo: " + corr + "\n" + "Tiempo total: " + tiempo_tot + " min";
			
			if(reporteHPersonas.containsKey(llave) == false)	{
				reporteHPersonas.put(llave, contenido);
				Apoyo.put(llave, ""+tiempo_tot);

			}
			else {
				
				String n = Apoyo.get(llave);
				double tiempoViejo = Double.parseDouble(n);
				double tiempoNuevo = tiempoViejo + tiempo_tot;
				String Ncontenido = "Nombre: " + nom + "\n" + "Correo: " + corr + "\n" + "Tiempo total: " + tiempoNuevo + " min";
				reporteHPersonas.put(llave, Ncontenido);
				Apoyo.put(llave, ""+tiempoNuevo);
			} 
			
					
			}
		}
		System.out.println("REPORTE POR PERSONA");
		for (String msj: reporteHPersonas.values()){
			System.out.println("\n");
			System.out.println(msj);
			System.out.println("\n");
		}
		
		
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

	public Actividad getActividadActual(){
		return this.actividadActual;
	}
	
	
	public void terminarActividad() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		String fechaF = LocalDateTime.now().format(formatter);
		actividadActual.setFechaFin(fechaF); 
		System.out.println(fechaF);
	}
	
	public void modificarActividad(String tipoCambio,Participante newEncargado,String nuevaFechaI,String nuevaFechaF, Actividad actividadModificar) {
		actividadActual=actividadModificar; 
		if (tipoCambio.equals("1")|| tipoCambio.equals("3")) {
			actividadActual.setEncargado(newEncargado);
		}
		if (tipoCambio.equals("2")|| tipoCambio.equals("3")) {
			if(!nuevaFechaI.equals("")) {
				actividadActual.setFechaInicio(nuevaFechaI);
			}
			if(!nuevaFechaF.equals("")) {
				actividadActual.setFechaFin(nuevaFechaF);
			}
		}
		
		
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
	
	public String getFechaInicio() {
		return this.fechaInicio;
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	
	public void setParticipantes(ArrayList<Participante> miembros) {
		participantes = miembros;
		
	}
	
	public void setActividades(Map<String,ArrayList<Actividad>> activs) {
		actividades = activs;
		
	}
}
