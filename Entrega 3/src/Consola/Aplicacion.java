package Consola;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import GestionArchivos.FileManager;
import Modelo.Proyecto;
import Modelo.Actividad;
import Modelo.Cronometro;
import Modelo.Participante;
import Modelo.Reporte;

public class Aplicacion implements Serializable {
	//ATRIBUTOS//
	private ArrayList<Proyecto> proyectos;
	private Proyecto proyectoActual;
	private Participante participanteActual;
	private Actividad actividadActual;
	private Cronometro cronometro;
	
	
	ArrayList<String> proyectosGuardados = new ArrayList<String>();
	
	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("GESTOR DE PROYECTOS\n");
		

		prepararAplicacion();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
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
					terminarActividad();
				else if (opcion_seleccionada == 6 && proyectoActual != null)
					ejecutarModificarActividad();
				else if (opcion_seleccionada == 7 && proyectoActual != null)
					ejecutarMostrarReporte();
				else if (opcion_seleccionada == 8 && proyectoActual != null)
					ejecutarIniciarTemporizador();
				else if (opcion_seleccionada == 9 && actividadActual != null)
					ejecutarFinalizarTemporizador();
				else if (opcion_seleccionada == 10 && actividadActual != null)
					ejecutarPausarTemporizador();
				else if (opcion_seleccionada == 11)
				{
					persistenciaArchivoGuardar();
					System.out.println("Saliendo de la aplicación...");
					continuar = false;
				}
				else if (proyectoActual == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe escoger un proyecto");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	private void ejecutarPausarTemporizador() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarFinalizarTemporizador() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarIniciarTemporizador() {
		// TODO Auto-generated method stub
		int count = 1;
		for (String actividad: proyectoActual.getActividades().keySet()) {
			System.out.println(count +". " + actividad);
			count+=1;
		}
		String acti = input("Escriba el titulo de la actividad que desea modificar (tal cual aparece en pantalla)");
		
		if(proyectoActual.getActividades().containsKey(acti)) {
		
				cronometro.start();
				System.out.println("Empezo el Cronometro");
				System.out.println("\n");
				boolean prueba = true;
				while (prueba) {
				System.out.println("Si desea pausar el cronometro oprima 1");
				System.out.println("Si desea detener el cronometro oprima 2");
				int opcion = Integer.parseInt(input("Cuando desee oprima una opcion: "));
				long var = 0;
				if (opcion == 1) {
					cronometro.stop();
					var = cronometro.getElapsedHours();
					int cont = Integer.parseInt(input("Cuando desee renaudar el cronometro oprima 1"));
					if (cont == 1) {
						cronometro.start();
					}
				}
				else if (opcion == 2) {
					cronometro.stop();
					var += cronometro.getElapsedHours();
					prueba = false;
				}
				else { System.out.println("Escribio mal el numero");
				}
		}
				//actividadActual = proyectoActual.getActividades().get(acti);	
		}
		else {
			System.out.println("Escribio mal el título de la actividad, intente de nuevo");
		}
		
	}

	//MÉTODOS//

	
	
	public void persistenciaArchivoGuardar() throws IOException {
		FileManager fileManager = new FileManager();
		fileManager.write(proyectos, "appData.txt");
		/*
	for (Proyecto proyGuardar: proyectos) {
	String nomProyecto = proyGuardar.getNombre();
	proyectosGuardados.add(nomProyecto);
	FileOutputStream file = new FileOutputStream("C:\\Users\\santi\\Documents\\Poryecto 1 DPOO\\Proyecto_1\\data" + nomProyecto + ".ser"); //lograr poner la ruta del archivo
	ObjectOutputStream out = new ObjectOutputStream(file); //cambiar nombres si se puede
	out.writeObject(proyectoActual);
	out.close();
	file.close();
	System.out.println("Informacion del proyecto guardada " + proyGuardar.getNombre()); //pq no carga nada
	
	}
	*/ 
		/*String nom = "Aplicacion";
		FileOutputStream file = new FileOutputStream("C:\\Users\\santi\\Documents\\Poryecto 1 DPOO\\Proyecto_1\\data" + nom + ".ser"); //lograr poner la ruta del archivo
		ObjectOutputStream out = new ObjectOutputStream(file); //cambiar nombres si se puede
		out.writeObject(this);
		out.close();
		file.close();
		System.out.println("Informacion del proyecto guardada"); //pq no carga nada*/
	}
	
	// TO DO: Cronometro -> Var tiempo -> Funcion Tiempo -> Dos opciones menu de empezar/pausar/continuar cronometro
	// TO DO: Persistencia -> Hacer opcion de guardar proyectos o que sea automatico al cambiar/cerrar proyecto
	// TO DO: Persistencia -> Cargar informacion
	
	public void persistenciaArchivoCargar() throws IOException, ClassNotFoundException {
		if (proyectosGuardados != null) {
			for (String guardados: proyectosGuardados) {
				String nombre = "data"+ guardados;
				FileInputStream file = new FileInputStream("C:\\Users\\santi\\Documents\\Poryecto 1 DPOO\\Proyecto_1\\data" + nombre +".ser");
				ObjectInputStream in = new ObjectInputStream(file);
				proyectoActual = (Proyecto) in.readObject();
				proyectos.add(proyectoActual);
				file.close();
				in.close();
		}
		}
		System.out.println(proyectos);
	}

	
	public void escogerProyecto() {
		
		if (proyectos.isEmpty()) {
			System.out.println("No hay proyectos registrados.");
		}
		else {
			int h = 1;
			for (Proyecto proyectoActual : proyectos) {
				System.out.println(h + ". " + proyectoActual.getNombre());
				h ++;
			}
			
			String p = input("Por favor ingrese el número de la opción deseada");
			int ip = Integer.parseInt(p);
			
			Proyecto proyectoElegido = proyectos.get(ip-1);
			proyectoActual = proyectoElegido;
			String login = input("Por favor ingrese el correo con el que se registro en este proyecto");
			ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();
			for (Participante esParte : participantesProyecto) {
				String correo = esParte.getCorreo();
				if (!correo.equals(login)) {
					System.out.println("Usted no hace parte de este proyecto, intente con otro correo o pida ser añadido");
				}
				else {
					System.out.println("Ha ingresado correctamente al sistema");
					this.participanteActual=esParte;
				}
			}
		}
		
	}
	
	public void crearProyecto() {
		System.out.println("Por favor diligencie los siguientes datos ");
		String nombre = input("Escriba el nombre de su proyecto");
		String descripcion = input ("Escriba una descripción para su proyecto");
		String fechaI= input("Por favor registre la fecha de inicio del proyecto");
		String fechaF = input ("Por favor registre la fecha final de su proyecto\n(Si aun no lo tiene escriba 0)");
		String tiposAc = input ("Separando por comas y sin espacios escriba los tipos de actividades que se realizaran en su proyecto ");
		String[] tiposAcList = tiposAc.split(",");
		ArrayList<String> tiposAcAr = new ArrayList<String>();
		for (String actividad : tiposAcList)
		{
			tiposAcAr.add(actividad);
		}
		String ownerName = input("Por favor escriba el nombre del dueño del proyecto");
		String ownerMail = input("Por favor escriba el correo del dueño del proyecto");
		
		Proyecto newProyect= new Proyecto(nombre,descripcion,fechaI,fechaF,tiposAcAr);
		this.proyectos.add(newProyect);
		newProyect.añadirParticipante(ownerMail, ownerName, true);
		System.out.println("\n Su proyecto ha sido creado con exitó!");
	}
	
	public void ejecutarNuevaActividad() {
		
		
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
			proyectoActual.nuevaActividad(titulo,descripcion,tipo,participanteActual);
			System.out.println("\n Actividad creada con exito");
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
		
	}
	
	public void ejecutarModificarActividad() {
		int count = 1;
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
						System.out.println(count3+". "+activity.getFechaI());
						count3+=1;
					}
					String cualActividad = input("Escoja la actividad a modificar");
					Actividad actividadAModificar = proyectoActual.getActividades().get(acti).get(Integer.parseInt(cualActividad)-1);
					
		
					if(cambio.equals("1")) {
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
						String nuevaFechaI = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar");
						String nuevaFechaF = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar"); 
						proyectoActual.modificarActividad(cambio,participanteActual,nuevaFechaI,nuevaFechaF, actividadAModificar);
						System.out.println("\n Las nuevas fechas son: \n Fecha inicio: "+ nuevaFechaI+"\n Fecha fin: "+ nuevaFechaF);
					}
					
					if(cambio.equals("3")) {
						int count2= 1;
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
					
					
					else {
						System.out.println("La opción ingresada no es válida");
					}
		}
		else {
			System.out.println("Escribio mal el título de la actividad, intente de nuevo");
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
		System.out.println("5. Finalizar una actividad");
		System.out.println("6. Modificar una actividad");
		System.out.println("7. Mostrar reporte");
		System.out.println("8. Manejar cronometro");
		System.out.println("9. Pausar cronometro");
		System.out.println("10. Finalizar cronometro");
		System.out.println("11. Salir de la aplicación"); 
	}
	
	public void prepararAplicacion(){
		this.proyectos = new ArrayList<Proyecto>();
	}
	
	public static void main(String[] args) throws IOException
	
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}

}
