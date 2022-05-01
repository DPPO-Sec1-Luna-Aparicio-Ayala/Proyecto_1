package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GestionArchivos.FileManager;
import Graficos.Imagenes;
import Modelo.Actividad;
import Modelo.Cronometro;
import Modelo.Participante;
import Modelo.Proyecto;

public class Aplicacion implements Serializable, ActionListener {
	//ATRIBUTOS//
	private ArrayList<Proyecto> proyectos;
	private Proyecto proyectoActual;
	private Participante participanteActual;
	private Actividad actividadActual;
	//private Cronometro cronometro;
	Cronometro cronometro = new Cronometro();
	ArrayList<String> proyectosGuardados = new ArrayList<String>();
	private int cronometrando;
	
	//GUI//
	private VentanaPrincipal principal;
	private ModificarActividad modificar;
	private menuProyecto menuProyecto;
	private loggeo login;
	private EscogerActiAModificar escogerActividad;
	private CronometrarActividad cronometrar;
	private CrearProyecto crearProyecto;
	private CrearActividad crearActividad;
	private añadirParticipante añadirParticipante; 
	private generarReporte generarReporte;
	
	//CONSTANTES//
	public static final int PAUSADO = 1;
	public static final int APAGADO = 0;
	public static final int CRONOMETRANDO = 2;
	
	public Aplicacion() throws IOException{
		prepararAplicacion();
		cronometrando = APAGADO;
		
		principal = new VentanaPrincipal(this);
		principal.setVisible(true);
		
		modificar = new ModificarActividad(this);
		
		cronometrar = new CronometrarActividad(this);
		
		crearProyecto = new CrearProyecto(this);
		}
	
	long tiempo = 0;
	//boolean primera = false;
	
	public void IniciarTemporizador() {
		cronometrando = CRONOMETRANDO;
		cronometro.start();
		tiempo = 0;
		//primera = true;
		
	}
	
	public void PausarTemporizador() {
		cronometrando = PAUSADO;
		cronometro.stop();
		tiempo += cronometro.getElapsedSeconds();
		
	}
	
	public long FinalizarTemporizador() {
		cronometrando = APAGADO;
		cronometro.stop();
		tiempo += cronometro.getElapsedSeconds();
		actividadActual.setTiempo(tiempo);
		long devolver = tiempo;
		tiempo = 0;
		return devolver;
		
	}
	
	/*private void ejecutarIniciarTemporizador(Actividad actividadActual) {
			
				int op = Integer.parseInt(input("Para iniciar el cronometro oprima cualquier numero"));
				
				cronometro.start();
				System.out.println("Empezó el Cronómetro");
				System.out.println("\n");
				boolean prueba = true;
				long var = 0;
				
				while (prueba) {
				System.out.println("Si desea pausar el cronometro oprima 1");
				System.out.println("Si desea finalizar la actividad oprima 2");
				int opcion = Integer.parseInt(input("Cuando desee oprima una opcion: "));
				if (opcion == 1) {
					cronometro.stop();
					var = cronometro.getElapsedMinutes();
					int cont = Integer.parseInt(input("Cuando desee renaudar el cronometro oprima 1"));
					if (cont == 1) {
						cronometro.start();
					}
				}
				else if (opcion == 2) {
					cronometro.stop();
					var += cronometro.getElapsedMinutes();
					prueba = false;
					terminarActividad();
				}
				else { System.out.println("Escribio mal el numero");
				}
		}
				
		actividadActual.setTiempo(var);
		JOptionPane.showMessageDialog(principal,proyectoActual.actividadActual.getTiempo() + " min"+"\nHa finalizado el tiempo.");	
	}*/

	//No crear nueva actividad hasta q no termine otra
	//MÉTODOS//
	public void persistenciaArchivoGuardar() throws IOException {
		FileManager fileManager = new FileManager();
		fileManager.write(proyectos, "appData.txt");
	}
	
	public void persistenciaArchivoCargar() throws IOException, ClassNotFoundException {
		FileManager fileManager = new FileManager();
		proyectos = fileManager.read("appData.txt");
	}
	
	public void crearProyecto(String nombre, String descripcion, String fechaI, String fechaF, String ownerName, String ownerMail, String tiposAc) {
		String[] tiposAcList = tiposAc.split(",");
		ArrayList<String> tiposAcAr = new ArrayList<String>();
		for (String actividad : tiposAcList)
		{
			tiposAcAr.add(actividad);
		}		
		Proyecto newProyect= new Proyecto(nombre,descripcion,fechaI,fechaF,tiposAcAr);
		this.proyectos.add(newProyect);
		newProyect.añadirParticipante(ownerMail, ownerName, true);
		JOptionPane.showMessageDialog(principal,"¡El proyecto ha sido creado con éxito!");	
	}
	
	public void ejecutarNuevaActividad(String titulo, String descripcion, String tipo, Participante participante) {
			proyectoActual.nuevaActividad(titulo,descripcion,tipo, participante);
			actividadActual = proyectoActual.getActividadActual();
			JOptionPane.showMessageDialog(principal,"La actividad se creó con éxito.");				
}

	public void terminarActividad() {
	
		proyectoActual.terminarActividad();
	
	}
	
	public void ejecutarAñadirParticipante() {
		/*
		System.out.println("Por favor diligencie los siguientes datos ");
		String correo = input ("Diligencie su correo");
		String nombre = input("Escriba su nombre");
		boolean owner= false;
		if (proyectoActual.getParticipantes().isEmpty())
		{
			owner = true;
		}
		proyectoActual.añadirParticipante(correo,nombre,owner);*/
	}
	
	public void ejecutarMostrarReporte() {
		//tiempo promedio x tipo de actividad
		
		proyectoActual.generarReporte();
	}
	
	
	public void ejecutarModificarActividad(Actividad actividadAModificar,String[] modificaciones, boolean[] cambiaron,Modelo.Participante acargo) {		
		proyectoActual.modificarActividad(actividadAModificar,modificaciones,cambiaron,acargo);
		
		
		/*	
				
				
				if(cambiaron[0]) {
						int count2= 1;
						/*
						ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();			
						for (Participante esParte : participantesProyecto) {
							System.out.println(count2 +". " + esParte.getNombre());
							count2+=1;	
						}
						String newEncargado =  input("Seleccione la persona que desea poner a cargo (escriba solo el numero)\n Si la persona no se encuentra en la lista añadalo como participante");//VALIDAR SI EL NOMBRE HACE PARTE DE LOS PARTICIPANTES DEL PROYECTO
						Participante newEncargadoo = proyectoActual.getParticipantes().get(Integer.parseInt(newEncargado)-1);
						
						Participante newEncargadoo = new Participante(cambios[3], cambios[2], true);
						proyectoActual.modificarActividad(cambio, newEncargadoo,"","", actividadAModificar);
						
						JOptionPane.showMessageDialog(principal," El nuevo encargado es: "+ newEncargadoo.getNombre());
					}
					if (cambio == 2) {

						String nuevaFechaI = cambios[0];
						proyectoActual.modificarActividad(cambio,participanteActual,nuevaFechaI,"", actividadAModificar);
						JOptionPane.showMessageDialog(principal,"La nueva fecha de inicio es "+nuevaFechaI);
					}
					
					if (cambio == 3) {
						String nuevaFechaF = cambios[1]; 
						proyectoActual.modificarActividad(cambio,participanteActual,"",nuevaFechaF, actividadAModificar);
						JOptionPane.showMessageDialog(principal,"La nueva fecha de finalización es "+nuevaFechaF);
					}
					
					if(cambio == 4) {
						int count2= 1;
						ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();			
						for (Participante esParte : participantesProyecto) {
							System.out.println(count2 +". " + esParte.getNombre());
							count2+=1;	
						}
						Participante newEncargadoo = new Participante(cambios[3], cambios[2], true);
						String nuevaFechaI = cambios[0];
						String nuevaFechaF = cambios[1];
						
						JOptionPane.showMessageDialog(principal,"\nEl nuevo encargado es: "+ newEncargadoo.getNombre() +"\nLas nuevas fechas son:\nFecha inicio: "+ nuevaFechaI+"\nFecha fin: "+ nuevaFechaF);
					}
		*/}
		

	
	//Cambiar visibilidad de las ventanas
		public void VisibleMenuAct(boolean o) {
			menuProyecto.setVisible(o);
		}
		
		public void VisiblePrincipal(boolean o) {
			principal.setVisible(o);
		}
		
		public void VisibleCrearActividad(boolean o) {
			crearActividad.setVisible(o);
		}
		
		public void VisibleEscogerActividad(boolean o) {
			escogerActividad.setVisible(o);
		}
		
		public void VisibleModificarActividad(boolean o) {
			modificar.setVisible(o);
		}

		public void VisibleGenerarReporte(boolean o) {
			generarReporte.setVisible(o);
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();
		
		if (fuente == principal.getComboBox()) {
			proyectoActual = proyectos.get(principal.darIndexProyecto());
		}
		
		else if (fuente == principal.getBtnLogin()) {
			if (proyectos.size()!=0) {
				login = new loggeo(this);
				login.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(principal,"Por favor, cree un proyecto.");			
			}
		}
		
		else if (fuente == principal.getBtnCrear()) {
			crearProyecto = new CrearProyecto(this);
			crearProyecto.setVisible(true);
			principal.setVisible(false);
			//Hacer un btn de retorno!!!
		}
		
		else if (fuente == login.getLogInBtn()) {
			String email = login.getEmail();
			ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();
			boolean encontrado = false;
			int h = 0;
			
			while (encontrado == false && h<participantesProyecto.size()) {
				Participante actual = participantesProyecto.get(h);
				String correo = actual.getCorreo();
				if (correo.equals(email)) {
					JOptionPane.showMessageDialog(principal,"Ha ingresado correctamente al sistema.");
					
					participanteActual=actual;
					JOptionPane.showMessageDialog(principal,"El participante actual es"+participanteActual.getNombre());
					login.setVisible(false);
					principal.setVisible(false);
					setMenuProyecto();
					menuProyecto.setVisible(true);
					encontrado = true;
				} else {
					h++;
				}
				
				}
			
			if (encontrado == false) {
				JOptionPane.showMessageDialog(principal,"Usted no hace parte de este proyecto, intente con otro correo o pida ser añadido");
			}
			
		}
	}
	

	public void actualizarProyActual(){
		proyectoActual = proyectos.get(0);
	}
	
	
	public Proyecto darProyectoActual() {
		return proyectoActual;
	}
	
	public ArrayList<Proyecto> darProyectos(){
		return proyectos;
	}
	
	public  Participante getParticipante() {
		return participanteActual;
	}
	
	public menuProyecto darMenuProyecto() {
		return menuProyecto;
	}
	
	public CronometrarActividad getCronometro() {
		return cronometrar;
	}
	
	public int estaCronometrando() {
		return cronometrando;
	}
	
	public void setCrearActividad() {
		crearActividad = new CrearActividad(this);
	}
	
	public void setEscogerActividad() {
		escogerActividad = new EscogerActiAModificar(this);
	}
	
	public void setMenuProyecto() {
		menuProyecto = new menuProyecto(this); 

	}
	public void setAñadirParticipante() {
		añadirParticipante= new añadirParticipante(this);
	}
	
	public void setGenerarReporte () {
		generarReporte = new generarReporte(this);
	}
	
	public void setActividadModificar(String param) {
		modificar.setNombreActividad(param);
	}
	
	public void prepararAplicacion(){
		this.proyectos = new ArrayList<Proyecto>();
		FileManager fileManager = new FileManager();
		proyectos = fileManager.read("appData.txt");
		if (proyectos.size() != 0){
			proyectoActual = proyectos.get(0);
		}
	}
	
	public static void main(String[] args) throws IOException	
	{
		new Aplicacion();
	}

}
