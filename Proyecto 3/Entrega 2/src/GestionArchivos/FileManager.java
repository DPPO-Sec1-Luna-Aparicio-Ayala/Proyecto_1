package GestionArchivos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import Modelo.Actividad;
import Modelo.Paquete;
import Modelo.Participante;
import Modelo.Proyecto;
import Modelo.Tarea;
import Modelo.WorkObject;

public class FileManager {
	//private HashMap<String, Tarea> wbsProys;
	public void write(ArrayList<Proyecto> proyectos, String nombre) {
	File f;
	FileWriter writer;
	BufferedWriter bw;
	PrintWriter ww;
	
	try {
		f = new File(nombre);
		writer = new FileWriter(f);
		bw = new BufferedWriter(writer);
		ww = new PrintWriter(bw);
		
		ww.write("");
		
		for (Proyecto proyectoActual : proyectos) {
				ww.append(proyectoActual.getNombre());
				ww.append(";");
				ww.append(proyectoActual.getDescripcion());
				ww.append(";");
				ww.append(proyectoActual.getFechaInicio());
				ww.append(";");
				ww.append(proyectoActual.getFechaFin());
				ww.append(";");
				
					ArrayList<String> tiposActividad = proyectoActual.gettypeActividades();
					for (String tipoActual : tiposActividad) {
						ww.append(tipoActual);
						ww.append(",");
					}
				
				ww.append(";");
				
					ArrayList<Participante> participantes = proyectoActual.getParticipantes();
					for (Participante partActual : participantes) {
						ww.append(partActual.getNombre());
						ww.append("·");
						ww.append(partActual.getCorreo());
						ww.append("·");
						
						if (partActual.esDuenio()) {
							ww.append("true");
						}
						else if (partActual.esDuenio() == false) {
							ww.append("false");
						}
						ww.append("·");			
						ww.append(",");
				        }
				ww.append(";");
				
				Map<String,ArrayList<Actividad>> actividadesMap = proyectoActual.getActividades();
				Iterator<Map.Entry<String, ArrayList<Actividad>>> entries = actividadesMap.entrySet().iterator();
				while (entries.hasNext()) {
					Map.Entry<String, ArrayList<Actividad>> entry = entries.next();
					ArrayList<Actividad> actividades = entry.getValue();
					for (Actividad actActual : actividades) {
						ww.append(actActual.getTitle());
						ww.append("·");
						ww.append(actActual.getDescripcion());
						ww.append("·");
						ww.append(actActual.getFechaI());
						ww.append("·");
						ww.append(actActual.getFechaF());
						ww.append("·");
						
						Participante responsable = actActual.getResponsable();
						ww.append(responsable.getNombre());
						ww.append("#");
						ww.append(responsable.getCorreo());
						ww.append("#");
						
						if (responsable.esDuenio()) {
							ww.append("true");
						}
						else if (responsable.esDuenio() == false) {
							ww.append("false");
						}
						ww.append("·");
						
						ww.append(actActual.getType());
						ww.append("·");
						ww.append(",");
					}
				}
				ww.append(";");
				ww.append("\n");
		}
		
		ww.close();
		bw.close();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ha sucedido un error: " + e);
	}
}
	/*
	public void writeWBS(String nombre, ArrayList<Proyecto> proyectos) {
		File f;
		FileWriter writer;
		BufferedWriter bw;
		PrintWriter ww;
		
		try {
			f = new File(nombre);
			writer = new FileWriter(f);
			bw = new BufferedWriter(writer);
			ww = new PrintWriter(bw);
			ww.write("");
			
			for (Proyecto proyecto : proyectos) {			
				HashMap<String, WorkObject> workObjects = proyecto.getWBS().getWBS();
				Set<String> keys = workObjects.keySet();
				ww.append(writeWBSline(keys, workObjects, proyecto.getNombre()));
			}
			
			ww.close();
			bw.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha sucedido un error: " + e);
		}
	}
	
	public void readWBS(String nombreArchivo, ArrayList<Proyecto> proyectos) {
		File archivo;
		FileReader fr;
		BufferedReader br;
		HashMap<String, WBS> wbss = new ArrayList<Proyecto>();
		
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null) {
				ArrayList<Participante> participantes = new ArrayList<Participante>();
				Map<String,ArrayList<Actividad>> actividades = new HashMap<String,ArrayList<Actividad>>();
				ArrayList<String> tiposActividad = new ArrayList<String>();
				
				
				String[] atributos = linea.split(";");
				ArrayList<String> wbsobs = new ArrayList<String>();
				for (String atr : atributos){
					wbsobs.add(atr);
				}
				String proyectoNombre = wbsobs.get(0);
				for (int i = 1; i <= wbsobs.size(); i++){
					String workobj = wbsobs.get(i);
					String[] atrs = workobj.split(",");
					ArrayList<String> objatr = new ArrayList<String>();
					for (String atr : atrs){
						objatr.add(atr);
					}
					String paquete = objatr.get(0);
					if (paquete.equals("0")){
						boolean esPaquete = false;
						String nombre = objatr.get(1);
						String descripcion = objatr.get(2);
						String padreNombre = objatr.get(3);
						String pathStr = objatr.get(4);
						String[] pathColl = pathStr.split("-");
						ArrayList<String> path = new ArrayList<String>();
						for (String a : pathColl){
							path.add(a);
						}
						String tipo = objatr.get(5);
						double tiempoEstimado = Double.parseDouble(objatr.get(6));
						String fecha = objatr.get(7);
						String encargados = objatr.get(8);
						String[] miembros = encargados.split("-");
						for (String participanteStr : miembros) {
							if (participanteStr != "") {
								String[] atributosPart = participanteStr.split("·");
								String nombreParticipante = atributosPart[0];
								String correo = atributosPart[1];
								String duenio = atributosPart[2];
								boolean esDuenio;
								
								if (duenio == "true") {
									esDuenio = true;								
								} else {
									esDuenio = false;
								}
								
								Participante participanteActual = new Participante(correo, nombreParticipante, esDuenio);
								participantes.add(participanteActual);
							}
						}
						String actividadesStr = objatr.get(9);
								if (actsString != "") {
							String[] actividadesStr = actsString.split("-");
								for (String actividadStr : actividadesStr) {
									Participante responsable = null;
									
									String[] atributosAct = actividadStr.split("·");
									
									String tituloAct = atributosAct[0];
									String descripcionAct = atributosAct[1];
									String fechaI = atributosAct[2];
									String fechaF = null;
									if (atributosAct[3] == "") {
										fechaF = "0";
									} else if ( atributosAct[3] != "") {
										fechaF =  atributosAct[3];
									}
									
									String encargado = atributosAct[4];
										if (encargado != "") {
											String[] atributosEnc = encargado.split("#");
											String nombreResp = atributosEnc[0];
											String correoResp = atributosEnc[1];
											String duenioResp = atributosEnc[2];
											boolean esDuenio;
											
											if (duenioResp == "true") {
												esDuenio = true;								
											} else {
												esDuenio = false;
											}
											
											responsable = new Participante(correoResp, nombreResp, esDuenio);
										}
									
									String tipoActividad = atributosAct[5];
									
									Actividad actividadActual = new Actividad(tituloAct, descripcionAct, tipoActividad, fechaI, fechaF, responsable);
									if (actividades.containsKey(actividadActual.getTitle())) {
										actividades.get(actividadActual.getTitle()).add(actividadActual);
									}
									else {
										ArrayList<Actividad> actis= new ArrayList<Actividad>();
										actis.add(actividadActual);
										actividades.put(actividadActual.getTitle(),actis);
									}
									
									
									}
					} else if (paquete.equals("1")){
						boolean esPaquete = true;	
						String nombre = objatr.get(1);
						String descripcion = objatr.get(2);
						String padreNombre = objatr.get(3);
						String pathStr = objatr.get(4);
						String[] pathColl = pathStr.split("-");
						ArrayList<String> path = new ArrayList<String>();
						for (String a : pathColl){
							path.add(a);
						}					
					}
				}
				

				
				
				String tiposAct = atributos[4];
				String[] tipos = tiposAct.split(",");
					for (String tipo : tipos) {
						if (tipo != "") {
						tiposActividad.add(tipo);
						}
					}
				
					
				String integrantes = atributos[5];
				
					
				if (atributos.length >= 7) {
				String actsString = atributos[6];
				
				} }
				
					Proyecto proyectoActual = new Proyecto (nombre, descripcion, fechaInicio, fechaFin, tiposActividad);
					proyectoActual.setActividades(actividades);
					proyectoActual.setParticipantes(participantes);
					proyectos.add(proyectoActual);
					}
					
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo: "+ e);
		}

		return proyectos;
	}*/
	
	public ArrayList<Proyecto> read(String nombreArchivo) {
		File archivo;
		FileReader fr;
		BufferedReader br;
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
		ArrayList<Proyecto> WBSproyectos;
		
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null) {
				ArrayList<Participante> participantes = new ArrayList<Participante>();
				Map<String,ArrayList<Actividad>> actividades = new HashMap<String,ArrayList<Actividad>>();
				ArrayList<String> tiposActividad = new ArrayList<String>();
				
				
				String[] atributos = linea.split(";");
				String nombre = atributos[0];
				String descripcion = atributos[1];
				String fechaInicio = atributos[2];
				String fechaFin = atributos[3];
				
				
				String tiposAct = atributos[4];
				String[] tipos = tiposAct.split(",");
					for (String tipo : tipos) {
						if (tipo != "") {
						tiposActividad.add(tipo);
						}
					}
				
					
				String integrantes = atributos[5];
				String[] miembros = integrantes.split(",");
					for (String participanteStr : miembros) {
						if (participanteStr != "") {
							String[] atributosPart = participanteStr.split("·");
							String nombreParticipante = atributosPart[0];
							String correo = atributosPart[1];
							String duenio = atributosPart[2];
							boolean esDuenio;
							
							if (duenio == "true") {
								esDuenio = true;								
							} else {
								esDuenio = false;
							}
							
							Participante participanteActual = new Participante(correo, nombreParticipante, esDuenio);
							participantes.add(participanteActual);
						}
					}
					
				if (atributos.length >= 7) {
				String actsString = atributos[6];
				if (actsString != "") {
				String[] actividadesStr = actsString.split(",");
					for (String actividadStr : actividadesStr) {
						Participante responsable = null;
						
						String[] atributosAct = actividadStr.split("·");
						
						String tituloAct = atributosAct[0];
						String descripcionAct = atributosAct[1];
						String fechaI = atributosAct[2];
						String fechaF = null;
						if (atributosAct[3] == "") {
							fechaF = "0";
						} else if ( atributosAct[3] != "") {
							fechaF =  atributosAct[3];
						}
						
						String encargado = atributosAct[4];
							if (encargado != "") {
								String[] atributosEnc = encargado.split("#");
								String nombreResp = atributosEnc[0];
								String correoResp = atributosEnc[1];
								String duenioResp = atributosEnc[2];
								boolean esDuenio;
								
								if (duenioResp == "true") {
									esDuenio = true;								
								} else {
									esDuenio = false;
								}
								
								responsable = new Participante(correoResp, nombreResp, esDuenio);
							}
						
						String tipoActividad = atributosAct[5];
						
						Actividad actividadActual = new Actividad(tituloAct, descripcionAct, tipoActividad, fechaI, fechaF, responsable);
						if (actividades.containsKey(actividadActual.getTitle())) {
							actividades.get(actividadActual.getTitle()).add(actividadActual);
						}
						else {
							ArrayList<Actividad> actis= new ArrayList<Actividad>();
							actis.add(actividadActual);
							actividades.put(actividadActual.getTitle(),actis);
						}
						
						
						}
				} }
				
					Proyecto proyectoActual = new Proyecto (nombre, descripcion, fechaInicio, fechaFin, tiposActividad);
					proyectoActual.setActividades(actividades);
					proyectoActual.setParticipantes(participantes);
					proyectos.add(proyectoActual);
					}
					
			
			br.close();
			fr.close();
			
			//WBSproyectos = readWBS(proyectos);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo: "+ e);
		}

		//return WBSproyectos;
		return proyectos;
		
	}
	/*
	private String writeWBSline(Set<String> keys, HashMap<String, WorkObject> workObjects, String proy){
		String ww = "";
		boolean nextLevel = false;
		ww += proy;
		ww += ";";
		for(String key : keys) {
					WorkObject wo = workObjects.get(key);
					if (wo.esPaquete()) {
						nextLevel = true;
						ww += "1";
						ww += ",";
						ww += wo.getNombre();
						ww += ",";
						ww += wo.getDescripcion();
						ww += ",";
						ww += wo.getPadre().getNombre();
						ww += ",";
						for (String ancestro : wo.getPath()) {
							ww += ancestro;
							ww += "-";
						}
						ww += ",";
						
					}
					else if (!wo.esPaquete()) {
						ww += "0";
						ww += ",";
						ww += wo.getNombre();
						ww += ",";
						ww += wo.getDescripcion();
						ww += ",";
						ww += wo.getPadre().getNombre();
						ww += ",";
						for (String ancestro : wo.getPath()) {
							ww += ancestro;
							ww += "-";
						}
						ww += ",";
						Tarea ta = (Tarea) wo;
						ww += ta.getTipo();
						ww += ",";
						ww += Double.toString(ta.getTiempoEstimado());
						ww += ",";
						ww += ta.getFechaEstimada();
						ww += ",";
						ArrayList<Participante> participantes = ta.getResponsables();
						for (Participante partActual : participantes) {
							ww += partActual.getNombre();
							ww += "·";
							ww += partActual.getCorreo();
							ww += "·";
							
							if (partActual.esDuenio()) {
								ww += "true";
							}
							else if (partActual.esDuenio() == false) {
								ww += "false";
							}
							ww += "·";			
							ww += "-";}
							ww += ",";
					    ArrayList<Actividad> actividades = ta.getActividades();    
					    for (Actividad actActual : actividades) {
							ww += actActual.getTitle();
							ww += "·";
							ww += actActual.getDescripcion();
							ww += "·";
							ww += actActual.getFechaI();
							ww += "·";
							ww += actActual.getFechaF());
							ww += "·";
							
							Participante responsable = actActual.getResponsable();
							ww += responsable.getNombre();
							ww += "#";
							ww += responsable.getCorreo();
							ww += "#";
							
							if (responsable.esDuenio()) {
								ww += "true";
							}
							else if (responsable.esDuenio() == false) {
								ww += "false";
							}
							ww += "·";
							
							ww += actActual.getType();
							ww += "·";
							ww += "-";
					}	ww += ",";						
					}
				
				ww += ";";
				ww += "\n";
				}
		if (nextLevel){
			for (String key : keys){
				if (workObjects.get(key).esPaquete()){
					Paquete pack = (Paquete) workObjects.get(key);
					ArrayList<WorkObject> objetos = pack.getTareasyPaquetes();
					ww += writeWBSlineList(objetos, proy);
				}
			}
		}
				
		return ww;
	}
	
	private String writeWBSlineList(ArrayList<WorkObject> workObjects, String proy){
		String ww = "";
		boolean nextLevel = false;
		ww += proy;
		ww += ";";
		for(String wo : workObjects) {
					if (wo.esPaquete()) {
						nextLevel = true;
						ww += "1";
						ww += ",";
						ww += wo.getNombre();
						ww += ",";
						ww += wo.getDescripcion();
						ww += ",";
						ww += wo.getPadre().getNombre();
						ww += ",";
						for (String ancestro : wo.getPath()) {
							ww += ancestro;
							ww += "-";
						}
						ww += ",";
						
					}
					else if (!wo.esPaquete()) {
						ww += "0";
						ww += ",";
						ww += wo.getNombre();
						ww += ",";
						ww += wo.getDescripcion();
						ww += ",";
						ww += wo.getPadre().getNombre();
						ww += ",";
						for (String ancestro : wo.getPath()) {
							ww += ancestro;
							ww += "-";
						}
						ww += ",";
						ww += ",";
						Tarea ta = (Tarea) wo;
						ww += ta.getTipo();
						ww += ",";
						ww += Double.toString(ta.getTiempoEstimado());
						ww += ",";
						ww += ta.getFechaEstimada();
						ww += ",";
						ArrayList<Participante> participantes = ta.getResponsables();
						for (Participante partActual : participantes) {
							ww += partActual.getNombre();
							ww += "·";
							ww += partActual.getCorreo();
							ww += "·";
							
							if (partActual.esDuenio()) {
								ww += "true";
							}
							else if (partActual.esDuenio() == false) {
								ww += "false";
							}
							ww += "·";			
							ww += "-";}
							ww += ",";
					    ArrayList<Actividad> actividades = ta.getActividades();    
					    for (Actividad actActual : actividades) {
							ww += actActual.getTitle();
							ww += "·";
							ww += actActual.getDescripcion();
							ww += "·";
							ww += actActual.getFechaI();
							ww += "·";
							ww += actActual.getFechaF());
							ww += "·";
							
							Participante responsable = actActual.getResponsable();
							ww += responsable.getNombre();
							ww += "#";
							ww += responsable.getCorreo();
							ww += "#";
							
							if (responsable.esDuenio()) {
								ww += "true";
							}
							else if (responsable.esDuenio() == false) {
								ww += "false";
							}
							ww += "·";
							
							ww += actActual.getType();
							ww += "·";
							ww += "-";
					}	ww += ",";						
					}
				
				ww += ";";
				ww += "\n";
				}
		if (nextLevel){
			for (String key : keys){
				if (workObjects.get(key).esPaquete()){
					Paquete pack = (Paquete) workObjects.get(key);
					ArrayList<WorkObject> objetos = pack.getTareasyPaquetes();
					ww += writeWBSlineList(objetos, proy);
				}
			}
		}
				
		return ww;

	}*/
}

