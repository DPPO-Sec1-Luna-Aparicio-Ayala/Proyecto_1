package Modelo;

import java.util.ArrayList;

public class WBS {
	private ArrayList<WorkObject> objetos;
	
	public void anadirObjetoWBS(WorkObject wo) {
		objetos.add(wo);		
	}
	
	public void eliminarObjetoWBS(WorkObject wo) {
		objetos.remove(wo);
	}
	
	public ArrayList<WorkObject> getObjetos(){
		return objetos;
	}
}
