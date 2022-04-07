package Consola;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Modelo.Proyecto;
import Modelo.Actividad;
import Modelo.Participante;
import Modelo.Reporte;

public class Aplicacion {
	//ATRIBUTOS//
	private ArrayList<Proyecto> proyectos;
	private Proyecto proyectoActual;
	private Participante participanteActual;
	
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
				else if (opcion_seleccionada == 8)
				{
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
	
	//MÉTODOS//
	
	/*
	public void persistenciaArchivo() {
		//bucle entrar a cada proyecto, en cada proyecto bucle por actividad
		CSVWriter writer = new CSVWriter(new FileWriter("C://output.csv"));
	      //Writing data to a csv file
	      String line1[] = {"id", "name", "salary", "start_date", "dept"};
	      String line2[] = {"1", "Krishna", "2548", "2012-01-01", "IT"};
	      String line3[] = {"2", "Vishnu", "4522", "2013-02-26", "Operations"};
	      String line4[] = {"3", "Raja", "3021", "2016-10-10", "HR"};
	      String line5[] = {"4", "Raghav", "6988", "2012-01-01", "IT"};
	      //Instantiating the List Object
	      List list = new ArrayList();
	      list.add(line1);
	      list.add(line2);
	      list.add(line3);
	      list.add(line4);
	      list.add(line5);
	      //Writing data to the csv file
	      writer.writeAll(list);
	      writer.flush();
	      System.out.println("Data entered");
		for (Proyecto proyectoActual : proyectos) {
			
			for (Actividad actividadActual: proyectoActual.getActividades()) {
				  
				    // first create file object for file placed at location
				    // specified by filepath
					
				    
				    
			
			}
			
			
			Proyecto newProyect= new Proyecto(nombre,descripcion,fechaI,fechaF,tiposAcAr);
			newProyect.añadirParticipante(ownerMail, ownerName, true);
			Actividad nuevaActividad = new Actividad(titulo, descripcionActividad, tipo, fechaI, fechaF, responsable);
			
			
		}
	}
	*/

	
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
					
		
					if(cambio.equals("1") || cambio.equals("3")) {
						int count2= 1;
						ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();			
						for (Participante esParte : participantesProyecto) {
							System.out.println(count2 +". " + esParte.getNombre());
							count2+=1;	
						}
						String newEncargado =  input("Seleccione la persona que desea poner a cargo (escriba solo el numero)\n Si la persona no se encuentra en la lista añadalo como participante");//VALIDAR SI EL NOMBRE HACE PARTE DE LOS PARTICIPANTES DEL PROYECTO
						Participante newEncargadoo = proyectoActual.getParticipantes().get(Integer.parseInt(newEncargado)-1);
						proyectoActual.modificarEncargado(newEncargadoo, actividadAModificar);
						
						System.out.println("\n El nuevo encargado es: "+ newEncargadoo.getNombre());
					}
					if (cambio.equals("2") || cambio.equals("3")) {
						int count4=1;
						String nuevaFechaI = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar");
						String nuevaFechaF = input("Diligencia la fecha de inicio de su actividad, use este formato  06-04-2022 21:38 \n o escriba MANTENER si no desea modificar"); 
						proyectoActual.modificarFecha(nuevaFechaI,nuevaFechaF,actividadAModificar);
						System.out.println("\n Las nuevas fechas son: \n Fecha inicio: "+ nuevaFechaI+"\n Fecha fin: "+ nuevaFechaF);
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
		System.out.println("8. Salir de la aplicación"); 
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
