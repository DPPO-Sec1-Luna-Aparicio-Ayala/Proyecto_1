package GestionArchivos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import Modelo.Actividad;
import Modelo.Participante;
import Modelo.Proyecto;

public class FileManager {
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
<<<<<<< HEAD
				ww.append(";");
				ww.append("\n");
=======
		ww.append(";");
		ww.append("\n");
>>>>>>> b8233ed7db6aab917460472c71cfc3703cf93bbc
		}
		
		ww.close();
		bw.close();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ha sucedido un error: " + e);
	}
}
	
	public ArrayList<Proyecto> read(String nombreArchivo) {
		File archivo;
		FileReader fr;
		BufferedReader br;
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
		
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
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo: "+ e);
		}

		return proyectos;
		
		
	}
}
