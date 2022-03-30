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
				else if (opcion_seleccionada == 3 && proyectoActual ! null)
					ejecutarAñadirParticipante();
				else if (opcion_seleccionada == 4 && proyectoActual != null)
					ejecutarNuevaActividad();
				else if (opcion_seleccionada == 5 && proyectoActual != null)
					terminarActividad();
				else if (opcion_seleccionada == 6 && proyectoActual != null)
					ejecutarModificarActividad();
				else if (opcion_seleccionada == 7)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (restaurante == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar los archivos.");
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
		else if{
			for (Proyecto proyectoActual : proyectos) {
				System.out.println(proyectoActual.getNombre());
			}
		}
		
	}
	
	public void crearProyecto() {
		
	}
	
	public void ejecutarNuevaActividad() {
		
	}

	public void terminarActividad() {
		
	}
	
	public void ejecutarAñadirParticipante() {
		
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
	
	public static void main(String[] args) throws IOException
	
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}

}
