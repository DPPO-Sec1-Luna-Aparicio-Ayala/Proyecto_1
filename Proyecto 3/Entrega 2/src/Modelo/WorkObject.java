package Modelo;

public class WorkObject {
	private boolean esPaquete;
	private String nombre;
	private String descripcion;
	private Paquete padre;
	
	public boolean esPaquete() {
		return esPaquete;
	}
	public void setEsPaquete(boolean esPaquete) {
		this.esPaquete = esPaquete;
	}
	public String getNombre() {
		return nombre;
	}  
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPadre(Paquete p) {
		padre = p;
	}
	
	public Paquete getPadre() {
		return padre;
	}
	
}
