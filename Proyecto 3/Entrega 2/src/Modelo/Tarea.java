package Modelo;

import java.util.ArrayList;

public class Tarea extends WorkObject{
	private String tipo;
	private double tiempoEstimado;
	private String fechaEstimada;
	private ArrayList<Participante> responsables;
	private ArrayList<Actividad> actividades;
	private boolean esFinal;
	
	public Tarea(String nombre, String descripcion, Paquete paquete, boolean fin) {
		setEsPaquete(false);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPadre(paquete);
		setEsFinal(fin);
		construirPath(paquete);		
	}
	
	public void anadirActividad(Actividad a) {
		actividades.add(a);
	}
	
	public void eliminarActividad(Actividad a) {
		actividades.remove(a);
	}
	
	public void anadirResponsable(Participante r) {
		responsables.add(r);
	}
	
	public void eliminarResponsable(Participante r) {
		responsables.remove(r);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(double tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	
	public void actualizarTiempo() {
		double total = 0.0;
		for (Actividad a : actividades) {
			double t = a.getTiempo();
			total += t;
		}
		setTiempoEstimado(total);
	}

	public String getFechaEstimada() {
		return fechaEstimada;
	}

	public void setFechaEstimada(String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}

	public ArrayList<Participante> getResponsables() {
		return responsables;
	}

	public void setResponsables(ArrayList<Participante> responsables) {
		this.responsables = responsables;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public void setEsFinal(boolean f) {
		esFinal = f;
	}
	
	public boolean esFinal() {
		return esFinal;
	}
	
}
