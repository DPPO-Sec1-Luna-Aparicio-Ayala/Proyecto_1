package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class WBS {
	private HashMap<String, WorkObject> objetos;
	private HashMap<String, Tarea> tareas;
	
	public WBS() {
		objetos = new HashMap<String, WorkObject>();
		tareas = new HashMap<String, Tarea>();
	}
	
	public void anadirObjetoWBS(WorkObject wo) {
		objetos.put(wo.getNombre(), wo);	
		if (!wo.esPaquete()) {
			Tarea ta = (Tarea) wo;
			tareas.put(ta.getNombre(), ta);
		}
	}
	
	public void eliminarObjetoWBS(WorkObject wo) {
		objetos.remove(wo.getNombre());
		if (!wo.esPaquete()) {
			Tarea ta = (Tarea) wo;
			tareas.remove(ta.getNombre());
		}
	}
	
	public HashMap<String, WorkObject> getWBS(){
		return objetos;
	}
	
	public HashMap<String, Tarea> getTareas(){
		return tareas;
	}
}
