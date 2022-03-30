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
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opci�n"));
				if (opcion_seleccionada == 1)
					crearProyecto();
				else if (opcion_seleccionada == 2)
					escogerProyecto();
				else if (opcion_seleccionada == 3 && proyectoActual != null)
					ejecutarA�adirParticipante();
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
					System.out.println("Saliendo de la aplicaci�n...");
					continuar = false;
				}
				else if (proyectoActual == null)
				{
					System.out.println("Para poder ejecutar esta opci�n primero debe escoger un proyecto");
				}
				else
				{
					System.out.println("Por favor seleccione una opci�n v�lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los n�meros de las opciones.");
			}
		}
	}
	
	//M�TODOS//
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
			
			String p = input("Por favor ingrese el n�mero de la opci�n deseada");
			int ip = Integer.parseInt(p);
			
			Proyecto proyectoElegido = proyectos.get(ip-1);
			proyectoActual = proyectoElegido;
		}
		
	}
	
	public void crearProyecto() {
		System.out.println("Por favor diligencie los siguientes datos ");
		String nombre = input("Escriba el nombre de su proyecto");
		String descripcion = input ("Escriba una descripci�n para su proyecto");
		String fechaI= input("Por favor registre la fecha de inicio del proyecto");
		String fechaF = input ("Por favor registre la fecha final de su proyecto\n(Si aun no lo tiene escriba 0)");
		String tiposAc = input ("Separando por comas y sin espacios escriba los tipos de actividades que se realizaran en su proyecto ");
		String[] tiposAcList = tiposAc.split(",");
		ArrayList<String> tiposAcAr = new ArrayList<String>();
		for (String actividad : tiposAcList)
		{
			tiposAcAr.add(actividad);
		}
		
		Proyecto newProyect= new Proyecto(nombre,descripcion,fechaI,fechaF,tiposAcAr);
		this.proyectos.add(newProyect);
	}
	
	public void ejecutarNuevaActividad() {
		
		
	}

	public void terminarActividad() {
		
	}
	
	public void ejecutarA�adirParticipante() {
		
		System.out.println("Por favor diligencie los siguientes datos ");
		String correo = input ("Diligencie su correo");
		String nombre = input("Escriba su nombre");
		boolean owner= false;
		if (proyectoActual.getParticipantes().isEmpty())
		{
			owner = true;
		}
		proyectoActual.a�adirParticipante(correo,nombre,owner);
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
		System.out.println("\nOpciones de la aplicaci�n\n");
		System.out.println("1. Crear nuevo proyecto");
		System.out.println("2. Seleccionar proyecto");
		System.out.println("3. A�adir participante al proyecto");
		System.out.println("4. Agregar actividad");
		System.out.println("5. Finalizar una actividad");
		System.out.println("6. Modificar una actividad");
		System.out.println("7. Mostrar reporte");
		System.out.println("8. Salir de la aplicaci�n"); 
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
