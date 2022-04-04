package Consola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		int count2= 1;
		String cambiarEncargado = input("Desea cambiar al encargado, por defecto sera usted quien quede registrado"+"\n Escriba Si o No");
		if(cambiarEncargado.equals("Si")) {
						ArrayList<Participante> participantesProyecto = proyectoActual.getParticipantes();
						
			for (Participante esParte : participantesProyecto) {
				System.out.println(count2 +". " + esParte.getNombre());
				count2+=1;	
			}
			String newEncargado =  input("Seleccione la persona que desea poner a cargo (escriba solo el numero)\n Si la persona no se encuentra en la lista añadalo como participante");//VALIDAR SI EL NOMBRE HACE PARTE DE LOS PARTICIPANTES DEL PROYECTO
			
			Participante newEncargadoo = proyectoActual.getParticipantes().get(Integer.parseInt(newEncargado)-1);
			proyectoActual.nuevaActividad(titulo, descripcion, tipo, newEncargadoo);
			System.out.println("\n Actividad creada con exito");
		}	
		else{
				proyectoActual.nuevaActividad(titulo,descripcion,tipo,participanteActual);
				System.out.println("\n Actividad creada con exito");
			}
}

	public void terminarActividad() {
		
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
