package Modelo;

import java.util.ArrayList;

public class Paquete extends WorkObject{
	private ArrayList<WorkObject> PyT;
	
	public Paquete(String nombre, String descripcion, Paquete paquete) {
		setEsPaquete(true);
		PyT = new ArrayList<WorkObject>();
		setNombre(nombre);
		setDescripcion(descripcion);
		setPadre(paquete);
	}
	
	
	public void agregarTareaoPaquete(WorkObject t) {
		PyT.add(t);
	}
	
	public void eliminarTareaoPaquete(WorkObject t) {
		PyT.remove(t);
	}
	
	public void setTareas(ArrayList<WorkObject> t) {
		PyT = t;
	}
	
	public ArrayList<WorkObject> getTareasyPaquetes(){
		return PyT;
	}
	
}
