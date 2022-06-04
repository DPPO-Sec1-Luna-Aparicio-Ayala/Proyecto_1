package Modelo;

import java.util.ArrayList;

public class Paquete extends WorkObject{
	private ArrayList<Tarea> tareas;
	
	public Paquete(String nombre, String descripcion, Paquete paquete) {
		setEsPaquete(true);
		tareas = new ArrayList<Tarea>();
		setNombre(nombre);
		setDescripcion(descripcion);
		setPadre(paquete);
	}
	
	
	public void agregarTarea(Tarea t) {
		tareas.add(t);
	}
	
	public void eliminarTarea(Tarea t) {
		tareas.remove(t);
	}
	
	public void setTareas(ArrayList<Tarea> t) {
		tareas = t;
	}
	
	public ArrayList<Tarea> getTareas(){
		return tareas;
	}
	
}
