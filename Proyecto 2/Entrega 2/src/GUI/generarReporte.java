package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;

public class generarReporte extends JFrame {

	private JPanel contentPane;
	private Aplicacion app;
	

	/**
	 * Create the frame.
	 * @param reporteHPersonas 
	 * @param reporteActividad 
	 */
	public generarReporte(Aplicacion aplicacion, HashMap<String, HashMap<String, Double>> reporteActividad, HashMap<String, String> reporteHPersonas) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Si falla poner exit
		setBounds(100, 100, 576, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Reporte por actividades, desplegar por favor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(38, 70, 176, 22);
		contentPane.add(lblNewLabel_2);
		
		JComboBox tiposActividad = new JComboBox();
		tiposActividad.setBounds(40, 90, 400, 25);
		
		//System.out.println("REPORTE POR TIPO ACTIVIDAD"); pasar a label
		for(String tipo:reporteActividad.keySet()) {
			//System.out.println("Tipo Atividad: "+ tipo);
			int count =1;
			for(String correo:reporteActividad.get(tipo).keySet()) {
				//System.out.println("\n"+count+ ". "+correo+"\tTiempo: "+reporteActividad.get(tipo).get(correo));
				String combo = "Tipo Actividad: " + tipo + " " +count+ ". "+correo+"\tTiempo: "+reporteActividad.get(tipo).get(correo);
				tiposActividad.addItem(combo);
				count+=1;
			}
		}
		
		//tiposActividad.addActionListener(this);
		contentPane.add(tiposActividad);
		
		JComboBox Personas = new JComboBox();
		Personas.setBounds(40, 150, 400, 25);
		
		System.out.println("REPORTE POR PERSONA"); // pasar a label
		for (String msj: reporteHPersonas.values()){
			
			Personas.addItem(msj);
			
		}
		
		//tiposActividad.addActionListener(this);
		contentPane.add(Personas);
		
		JLabel lblNewLabel_1 = new JLabel("Generador de Reportes!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(38, 52, 176, 22);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 124, 244, 15);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Reporte por personas, desplegar por favor");
		lblNewLabel_3.setBounds(0, 0, 240, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(generarReporte.class.getResource("/Graficos/report.png")));
		lblNewLabel.setBounds(111, 24, 467, 474);
		contentPane.add(lblNewLabel);
	}
}
