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
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//cambiar muchas de las visiblidades a solo funciones con la aplicacion para evitar tanto enlace de que todos se tengan como parametros
	//!!!!!!!!!!!!!!!!!!!!!!
	//!!!!!!!!!!!!!!!!!!!!!
	//"""""""""""""""""""""
	
	
	
	//GUI//
	private VentanaPrincipal principal;
	private ModificarActividad modificar;
	private menuProyecto menuProyecto;
	private MenuEscogerProyecto escogerProyecto;
	private loggeo login;
	private EscogerActiAModificar escogerActividad;
	private CronometrarActividad cronometrar;
	private CrearProyecto crearProyecto;
	private CrearActividad crearActividad;
	
	public Aplicacion() throws IOException{
		prepararAplicacion();
		principal = new VentanaPrincipal(this);
		modificar = new ModificarActividad();
		
		escogerProyecto = new MenuEscogerProyecto(this);
		escogerActividad = new EscogerActiAModificar();
		cronometrar = new CronometrarActividad(this);
		
		crearActividad = new CrearActividad(cronometrar, this);
		menuProyecto = new menuProyecto(principal, crearActividad, escogerActividad, this); //falta la ventana del reporte y de añadir participante
		crearProyecto = new CrearProyecto(menuProyecto, this);
		principal.setVisible(true);
		
		
	/*
				mostrarOpciones();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					crearProyecto();
				else if (opcion_seleccionada == 2)
					escogerProyecto();
				else if (opcion_seleccionada == 3 && proyectoActual != null)
					ejecutarAñadirParticipante();
				else if (opcion_seleccionada == 4 && proyectoActual != null)
					ejecutarNuevaActividad();
				else if (opcion_seleccionada == 5 && proyectoActual != null)
					ejecutarModificarActividad();
				else if (opcion_seleccionada == 6 && proyectoActual != null)
					ejecutarMostrarReporte();
				else if (opcion_seleccionada == 7)
				{
				}
				else if (proyectoActual == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe escoger un proyecto");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}*/
		}
	
	long tiempo = 0;
	//boolean primera = false;
	
	public void IniciarTemporizador() {
		
		cronometro.start();
		tiempo = 0;
		//primera = true;
		
	}
	
	public void PausarTemporizador() {
		
		cronometro.stop();
		tiempo += cronometro.getElapsedSeconds();
		
	}
	
	public long FinalizarTemporizador() {
		
		cronometro.stop();
		tiempo += cronometro.getElapsedSeconds();
		actividadActual.setTiempo(tiempo);
		System.out.println(proyectoActual.actividadActual.getTiempo() + " seg");
		System.out.println("Ha finalizado el tiempo");
		long devolver = tiempo;
		tiempo = 0;
		return devolver;
		
	}
	
	
	
	private void ejecutarIniciarTemporizador(Actividad actividadActual) {
		
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
		System.out.println(proyectoActual.actividadActual.getTiempo() + " min");
		System.out.println("Ha finalizado el tiempo");
				
		
	}

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
		/*
		System.out.println("Por favor diligencie los siguientes datos ");
		String nombre = input("Escriba el nombre de su proyecto");
		String descripcion = input ("Escriba una descripción para su proyecto");
		String fechaI= input("Por favor registre la fecha de inicio del proyecto");
		String fechaF = input ("Por favor registre la fecha final de su proyecto\n(Si aun no lo tiene escriba 0)");
		String tiposAc = input ("Separando por comas y sin espacios escriba los tipos de actividades que se realizaran en su proyecto ");
		*/
		String[] tiposAcList = tiposAc.split(",");
		ArrayList<String> tiposAcAr = new ArrayList<String>();
		for (String actividad : tiposAcList)
		{
			tiposAcAr.add(actividad);
		}
		/*
		String ownerName = input("Por favor escriba el nombre del dueño del proyecto");
		String ownerMail = input("Por favor escriba el correo del dueño del proyecto");
		*/
		
		Proyecto newProyect= new Proyecto(nombre,descripcion,fechaI,fechaF,tiposAcAr);
		this.proyectos.add(newProyect);
		newProyect.añadirParticipante(ownerMail, ownerName, true);
		System.out.println("\n Su proyecto ha sido creado con exitó!");
	}
	
	public void ejecutarNuevaActividad(String titulo, String descripcion, String tipo, Participante participante) {
		
			/*
			System.out.println("Por favor diligencie los siguientes datos ");
			String titulo = input("Escriba el titulo de su actividad");
			String descripcion = input ("Escriba una descripción para su actividad");
	
			int count=1;
			for(String actividad : proyectoActual.gettypeActividades()) {
				System.out.println(count + ". "+actividad);
				count+=1;	
			}
			
			
			String numtipo= input("Por favor elija el tipo de actividad a relaizar e ingrese el numero");
			String tipo = proyectoActual.gettypeActividades().get(Integer.parseInt(numtipo)-1);
			*/
			proyectoActual.nuevaActividad(titulo,descripcion,tipo, participante);
			actividadActual = proyectoActual.getActividadActual();
			System.out.println("Se creo con exito");
			/*
			ejecutarIniciarTemporizador(actividadActual);
			System.out.println("\n Actividad creada con exito");
			*/
			
}

	public void terminarActividad() {
	
		proyectoActual.terminarActividad();
	
	}
	
	public void ejecutarAñadirParticipante() {
		
		System.out.println("Por favor diligencie los siguientes datos ");
		String correo = input ("Diligencie su correo");
		String nombre = input("Escriba su nombre");
		boolean owner= false;
		if (proyectoActual.getParticipantes().isEmpty())
		{
			owner = true;
		}
		proyectoActual.añadirParticipante(correo,nombre,owner);
	}
	
	public void ejecutarMostrarReporte() {
		//tiempo promedio x tipo de actividad
		
		proyectoActual.generarReporte();
	}
	
	public void ejecutarModificarActividad() {
		int count = 1;
		boolean b=false;
		for (String actividad: proyectoActual.getActividades().keySet()) {
			System.out.println(count +". " + actividad);
			count+=1;
		}
		String acti = input("Escriba el titulo de la actividad que desea modificar (tal cual aparece en pantalla)");
		
		if(proyectoActual.getActividades().containsKey(acti)) {
					
					System.out.println("\n Escriba el numero de la acción que desea hacer");
					String cambio = input("Desea modificar el encargado de la actividad (1) o la hora de realización(2) o (3) para ambas");
					int count3=1;
					for (Actividad activity : proyectoActual.getActividades().get(acti)) {
						System.out.println(count3+". Titulo:"+activity.getTitle()+"\tEncargado: "+activity.getResponsable().getNombre()+" \tFecha: "+activity.getFechaI());
						count3+=1;
					}
					String cualActividad = input("Escoja la actividad a modificar");
					Actividad actividadAModificar = proyectoActual.getActividades().get(acti).get(Integer.parseInt(cualActividad)-1);
					
		
					if(cambio.equals("1")) {
						b=true;
						int count2= 1;
						ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();			
						for (Participante esParte : participantesProyecto) {
							System.out.println(count2 +". " + esParte.getNombre());
							count2+=1;	
						}
						String newEncargado =  input("Seleccione la persona que desea poner a cargo (escriba solo el numero)\n Si la persona no se encuentra en la lista añadalo como participante");//VALIDAR SI EL NOMBRE HACE PARTE DE LOS PARTICIPANTES DEL PROYECTO
						Participante newEncargadoo = proyectoActual.getParticipantes().get(Integer.parseInt(newEncargado)-1);
						
						proyectoActual.modificarActividad(cambio, newEncargadoo,"","", actividadAModificar);
						
						
						System.out.println("\n El nuevo encargado es: "+ newEncargadoo.getNombre());
					}
					if (cambio.equals("2")) {
						b=true;
						String nuevaFechaI = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar");
						String nuevaFechaF = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar"); 
						proyectoActual.modificarActividad(cambio,participanteActual,nuevaFechaI,nuevaFechaF, actividadAModificar);
						System.out.println("\n Las nuevas fechas son: \n Fecha inicio: "+ nuevaFechaI+"\n Fecha fin: "+ nuevaFechaF);
					}
					
					if(cambio.equals("3")) {
						int count2= 1;
						b=true;
						ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();			
						for (Participante esParte : participantesProyecto) {
							System.out.println(count2 +". " + esParte.getNombre());
							count2+=1;	
						}
						String newEncargado =  input("Seleccione la persona que desea poner a cargo (escriba solo el numero)\n Si la persona no se encuentra en la lista añadalo como participante");//VALIDAR SI EL NOMBRE HACE PARTE DE LOS PARTICIPANTES DEL PROYECTO
						Participante newEncargadoo = proyectoActual.getParticipantes().get(Integer.parseInt(newEncargado)-1);
						String nuevaFechaI = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar");
						String nuevaFechaF = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar"); 
						System.out.println("\n El nuevo encargado es: "+ newEncargadoo.getNombre() +"\n Las nuevas fechas son: \n Fecha inicio: "+ nuevaFechaI+"\n Fecha fin: "+ nuevaFechaF);
					}
					
					
					else if (!b) {
						System.out.println("La opción ingresada no es válida");
					}
		}
		else {
			System.out.println("Escribió mal el título de la actividad, intente de nuevo");
		}
		
	}
	
	private String input(String mensaje) {
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public void mostrarOpciones()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Crear nuevo proyecto");
		System.out.println("2. Seleccionar proyecto");
		System.out.println("3. Añadir participante al proyecto");
		System.out.println("4. Agregar actividad");
		System.out.println("5. Modificar una actividad");
		System.out.println("6. Mostrar reporte");
		System.out.println("7. Salir de la aplicación"); 
	}
	
	public void prepararAplicacion(){
		this.proyectos = new ArrayList<Proyecto>();
		FileManager fileManager = new FileManager();
		proyectos = fileManager.read("appData.txt");
		proyectoActual = proyectos.get(0);
	}
	
	
	public Proyecto darProyectoActual() {
		return proyectoActual;
	}
	
	public ArrayList<Proyecto> darProyectos(){
		return proyectos;
	}
	
	public void VisibleMenuAct() {
		menuProyecto.setVisible(true);
	}
	
	public  Participante getParticipante() {
		return this.participanteActual;
	}
	
	
	public static void main(String[] args) throws IOException	
	{
		new Aplicacion();
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
			crearProyecto = new CrearProyecto(menuProyecto, this);
			crearProyecto.setVisible(true);
			principal.setVisible(false);
			//Hacer un btn de retorno!!!
			//crearProyecto();
		}
		
		else if (fuente == login.getLogInBtn()) {
			String email = login.getEmail();
			ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();
			for (Participante esParte : participantesProyecto) {
				String correo = esParte.getCorreo();
				if (!correo.equals(email)) {
					JOptionPane.showMessageDialog(principal,"Usted no hace parte de este proyecto, intente con otro correo o pida ser añadido");
				}
				else {
					JOptionPane.showMessageDialog(principal,"Ha ingresado correctamente al sistema.");
					this.participanteActual=esParte;
					login.setVisible(false);
					principal.setVisible(false);
					menuProyecto.setVisible(true);
				}
			}
		}
		//else if (fuente == menuProyecto.get)
	}

}
