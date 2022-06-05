package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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
	private a�adirParticipante a�adirParticipante; 
	private ReporteMensual generarReporte;
	private crearA�adirPaquete crearA�andirPaquete;
	
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
	
	public HashMap<String, Integer> generarGrafico(){
		
		HashMap<String, Integer> grafico = proyectoActual.generarGrafico();
		return grafico;
		
	}
	
	/*private void ejecutarIniciarTemporizador(Actividad actividadActual) {
			
				int op = Integer.parseInt(input("Para iniciar el cronometro oprima cualquier numero"));
				
				cronometro.start();
				System.out.println("Empez� el Cron�metro");
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
	//M�TODOS//
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
		newProyect.a�adirParticipante(ownerMail, ownerName, true);
		JOptionPane.showMessageDialog(principal,"�El proyecto ha sido creado con �xito!");	
		System.out.print(newProyect.getWBS());
	}
	
	public void ejecutarNuevaActividad(String titulo, String descripcion, String tipo, Participante participante) {
			proyectoActual.nuevaActividad(titulo,descripcion,tipo, participante);
			actividadActual = proyectoActual.getActividadActual();
			JOptionPane.showMessageDialog(principal,"La actividad se cre� con �xito.");				
}

	public void terminarActividad() {
	
		proyectoActual.terminarActividad();
	
	}
	
	public void ejecutarA�adirParticipante(String correo,String nombre,boolean owner) {
		proyectoActual.a�adirParticipante(correo, nombre, owner);
	}
	
	public HashMap<String,HashMap<String,Double>> ejecutarMostrarReporteActividad() {
		//tiempo promedio x tipo de actividad
		
		return proyectoActual.generarReporteTipoActividad();
	}
	
	public HashMap<String, String> ejecutarMostrarReportePersonas() {
		//tiempo promedio x tipo de actividad
		
		return proyectoActual.generarReportePersonas();
	}
	
	
	public void ejecutarModificarActividad(Actividad actividadAModificar,String[] modificaciones, boolean[] cambiaron,Modelo.Participante acargo) {		
		proyectoActual.modificarActividad(actividadAModificar,modificaciones,cambiaron,acargo);

		}
		

	
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
		
		public void VisibleA�adirParticipante(boolean o) {
			a�adirParticipante.setVisible(o);
		}
		
		public void VisibleCrearA�adirPaquete(boolean o) {
			crearA�andirPaquete.setVisible(o);
			
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
					JOptionPane.showMessageDialog(principal,"El participante actual es "+participanteActual.getNombre());
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
				JOptionPane.showMessageDialog(principal,"Usted no hace parte de este proyecto, intente con otro correo o pida ser a�adido");
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
	
	public void setCrearA�adirPaquete() {
		crearA�andirPaquete = new crearA�adirPaquete();
	}
	
	public void setEscogerActividad() {
		escogerActividad = new EscogerActiAModificar(this);
	}
	
	public void setModificarActividad() {
		modificar = new ModificarActividad(this);
	}
	
	public void setMenuProyecto() {
		menuProyecto = new menuProyecto(this); 
	}
		
	public void setCronometro() {
		cronometrar = new CronometrarActividad(this);
	}
	
	public void setA�adirParticipante() {
		a�adirParticipante= new a�adirParticipante(this);
	}
	
	public void setGenerarReporte (HashMap<String, HashMap<String, Double>> reporteActividad, HashMap<String, String> reporteHPersonas) {
		generarReporte = new ReporteMensual(this, reporteActividad,  reporteHPersonas);
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
