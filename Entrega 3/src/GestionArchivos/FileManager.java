package GestionArchivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
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
			ww.append("\n");
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
						
							ArrayList<Actividad> acts = partActual.getActividades();
							for (Actividad actActual : acts) {
								ww.append(actActual.getTitle());
								ww.append("#");
								ww.append(actActual.getDescripcion());
								ww.append("#");
								ww.append(actActual.getFechaI());
								ww.append("#");
								ww.append(actActual.getFechaF());
								ww.append("#");
								
								Participante responsable = actActual.getResponsable();
									ww.append(responsable.getNombre());
									ww.append("*");
									ww.append(responsable.getCorreo());
									ww.append("*");
								
									if (responsable.esDuenio()) {
										ww.append("true");
									}
									else if (responsable.esDuenio() == false) {
										ww.append("false");
									}
								ww.append("#");
							
								ww.append(actActual.getType());
								ww.append("·");
						}
					
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
						ww.append(",");
					}
				}
				ww.append(";");
		}
		
		ww.close();
		bw.close();
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ha sucedido un error: " + e);
	}
}
}
