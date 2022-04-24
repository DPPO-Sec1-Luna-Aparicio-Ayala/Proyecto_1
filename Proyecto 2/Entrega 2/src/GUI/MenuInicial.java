package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Modelo.Proyecto;

public class MenuInicial extends JPanel {
	private JLabel proyectoActual;
	private Aplicacion aplicacion;
	private JComboBox<String> proyectos;
	
	public MenuInicial(Aplicacion app) {
		aplicacion = app;
		BorderLayout bl = new BorderLayout();
        setLayout(bl);
		proyectoActual = new JLabel("PROYECTO ACTUAL:");
		proyectoActual.setPreferredSize(new Dimension(150,30));
		proyectos = new JComboBox<String>();
		proyectos.setBounds(80,80,320,80);
		if (aplicacion.darProyectos().size() != 0) {
			for (Proyecto proyecto : aplicacion.darProyectos()) {
				proyectos.addItem(proyecto.getNombre());
			}
		} else {
			JOptionPane.showMessageDialog(this,"Por favor, cree un proyecto.");			
		}
		
		add(proyectoActual, bl.NORTH);
		add(proyectos, bl.CENTER);
	}
	
	/*private void actualizarProyectoActual() {
		if (aplicacion.darProyectoActual() != null) {
			proyectoActual.setText(aplicacion.darProyectoActual().getNombre());
		}
	}*/

}
