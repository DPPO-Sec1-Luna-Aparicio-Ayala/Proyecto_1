package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Proyecto;

public class MenuEscogerProyecto extends JFrame implements ActionListener{
	private JLabel proyectoActual;
	private Aplicacion aplicacion;
	private JComboBox<String> proyectos;
	private JButton salir;
	private JPanel panel;
	private JPanel panel2;
	private JButton nuevo;
	private static final JPanel panelVacio = new JPanel();
	
	public MenuEscogerProyecto(Aplicacion app) {
		aplicacion = app;
		
		setIconImage(aplicacion.icono);
		setTitle("Gestor de Proyectos");
		setSize(900, 700);
		setResizable(false);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel2 = new JPanel();
		BorderLayout bl = new BorderLayout();
        panel.setLayout(bl);
        
		proyectoActual = new JLabel("PROYECTO ACTUAL:");
		proyectoActual.setPreferredSize(new Dimension(300,30));
		
		proyectos = new JComboBox<String>();
		proyectos.setPreferredSize(new Dimension(500,100));
		if (aplicacion.darProyectos().size() != 0) {
			for (Proyecto proyecto : aplicacion.darProyectos()) {
				proyectos.addItem(proyecto.getNombre());
			}
		} else {
			JOptionPane.showMessageDialog(panel,"Por favor, cree un proyecto.");			
		}
		
		salir = new JButton("Salir de la aplicación");
		salir.addActionListener(aplicacion);
		
		nuevo = new JButton("Crear nuevo proyecto");
		
		panel.add(proyectoActual, bl.NORTH);
		panel.add(proyectos, bl.CENTER);
		panel2.add(salir, bl.SOUTH);
		panel2.add(nuevo, bl.NORTH);
		
		add(panel, bl.CENTER);
		add(panel2, bl.SOUTH);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try {
					aplicacion.persistenciaArchivoGuardar();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	/*private void actualizarProyectoActual() {
		if (aplicacion.darProyectoActual() != null) {
			proyectoActual.setText(aplicacion.darProyectoActual().getNombre());
		}
	}*/
	public JComboBox<String> getComboProyectos(){
		return proyectos;
	}
	
	public int darIndexProyecto() {
		int proyectoIndex = proyectos.getSelectedIndex();
		return proyectoIndex;						
	}
	
	public JButton darBotonNuevo() {
		return nuevo;
	}

	public JButton darBotonSalir() {
		return salir;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();
		
		if (fuente == proyectos) {
			proyectoActual.setText("PROYECTO ACTUAL: "+aplicacion.darProyectoActual().getNombre());
		}
		
	}
}
