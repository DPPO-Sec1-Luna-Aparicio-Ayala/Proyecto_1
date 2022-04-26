package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Proyecto;

public class MenuEscogerProyecto extends JPanel {
	private JLabel proyectoActual;
	private Aplicacion aplicacion;
	private JComboBox<String> proyectos;
	private JButton salir;
	
	public MenuEscogerProyecto(Aplicacion app) {
		aplicacion = app;
		BorderLayout bl = new BorderLayout();
        setLayout(bl);
		proyectoActual = new JLabel("PROYECTO ACTUAL");
		proyectoActual.setPreferredSize(new Dimension(300,30));
		proyectos = new JComboBox<String>();
		salir = new JButton("Salir de la aplicación");
		salir.addActionListener(aplicacion);
		if (aplicacion.darProyectos().size() != 0) {
			for (Proyecto proyecto : aplicacion.darProyectos()) {
				proyectos.addItem(proyecto.getNombre());
			}
		} else {
			JOptionPane.showMessageDialog(this,"Por favor, cree un proyecto.");			
		}
		
		add(proyectoActual, bl.NORTH);
		add(proyectos, bl.CENTER);
		add(salir, bl.SOUTH);
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

}
