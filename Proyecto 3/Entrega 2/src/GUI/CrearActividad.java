package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;
import Modelo.Participante;
import Modelo.Tarea;

public class CrearActividad extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Imagenes img;
	private ArrayList<String> ListaTipos;
	private Participante participanteActual;
	private JFrame presente; 
	private String tipoSeleccionado;
	private Tarea tareaSeleccionada;
	private JComboBox tiposActividad;
	private JComboBox tareas;
	private Aplicacion app;
	
	/**
	 * Create the frame.
	 * @param cronometrar 
	 * @param aplicacion 
	 */
	public CrearActividad(Aplicacion ap) {
		app = ap;
		setIconImage(img.BULB);
		presente = new JFrame();
		ListaTipos = app.darProyectoActual().gettypeActividades();
		participanteActual = app.getParticipante();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 697, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(img.IDEA));
		lblNewLabel_1.setBounds(-55, 0, 480, 440);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(419, 0, 262, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTipoActividad = new JLabel("Tipo Actividad:");
		lblTipoActividad.setBounds(33, 164, 83, 14);
		panel.add(lblTipoActividad);
		lblTipoActividad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tiposActividad = new JComboBox();
		tiposActividad.setBounds(126, 160, 106, 22);
		for (String tipo : ListaTipos) 
		{ 
			tiposActividad.addItem(tipo);
		}
		tiposActividad.addActionListener(this);
		panel.add(tiposActividad);
		
		
		
		
		JLabel lblTarea = new JLabel("Tarea:");
		lblTarea.setBounds(33, 180, 83, 14);
		panel.add(lblTarea);
		lblTarea.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tareas = new JComboBox();
		tareas.setBounds(126, 180, 106, 22);
		if (app.getWBS().getTareas().isEmpty()) {
			JOptionPane.showMessageDialog(presente,"Primero cree una tarea, por favor.");
		}
		else {
		for (Tarea tarea : app.getWBS().getTareas()) 
		{ 
			tareas.addItem(tarea.getNombre());
		}}
		tareas.addActionListener(this);
		panel.add(tareas);
		/*
		JFormattedTextField frmtdtxtfldRealice = new JFormattedTextField();
		frmtdtxtfldRealice.setBounds(126, 118, 106, 20);
		panel.add(frmtdtxtfldRealice);
		frmtdtxtfldRealice.setText("Realice...");
		frmtdtxtfldRealice.setForeground(SystemColor.controlDkShadow);
		//Corregir esto y hacer el if para cuando las boxes esten vacias
		//usar el ejemplo de tipos actividad (Jlabel 5 en Crear Proyecto)
		*/
		
		JTextField frmtdtxtfldRealice = new JTextField();
		frmtdtxtfldRealice.setColumns(10);
		frmtdtxtfldRealice.setBounds(126, 118, 106, 20);
		panel.add(frmtdtxtfldRealice);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(53, 121, 106, 14);
		panel.add(lblDescripcin);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo Actividad:");
		lblNewLabel.setBounds(33, 82, 106, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		/*
		JFormattedTextField frmtdtxtfldActividad = new JFormattedTextField();
		frmtdtxtfldActividad.setBounds(126, 79, 106, 20);
		panel.add(frmtdtxtfldActividad);
		frmtdtxtfldActividad.setForeground(new Color(105, 105, 105));
		frmtdtxtfldActividad.setText("Actividad1...");
		*/
		
		JTextField frmtdtxtfldActividad = new JTextField();
		frmtdtxtfldActividad.setColumns(10);
		frmtdtxtfldActividad.setBounds(126, 79, 106, 20);
		panel.add(frmtdtxtfldActividad);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(143, 335, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frmtdtxtfldActividad.getText().equals("") || frmtdtxtfldRealice.getText().equals("")) {
					JOptionPane.showMessageDialog(presente,"Hay una o mas casillas que siguen en blanco, rellene todas por favor");
				}
				else {
				String tipo = tiposActividad.getSelectedItem().toString();
				String titulo = frmtdtxtfldRealice.getText();
				String descripcion = frmtdtxtfldActividad.getText();
				Integer indexTarea = tareas.getSelectedIndex();
				Tarea tarea = app.getWBS().getTareas().get(indexTarea);				
				app.setCronometro();
				app.ejecutarNuevaActividad(titulo, descripcion, tipo, participanteActual, tarea);
				setVisible(false); //recibir los inputs
				app.getCronometro().setVisible(true);
				}
			}
			});
		panel.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(tiposActividad)) {
			tipoSeleccionado = tiposActividad.getSelectedItem().toString();
		}
		else if (e.getSource().equals(tareas)) {
			Integer indexTarea = tareas.getSelectedIndex();
			tareaSeleccionada = app.getWBS().getTareas().get(indexTarea);
		}
	}
}
