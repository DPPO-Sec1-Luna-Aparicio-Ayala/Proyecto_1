package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;

public class reportes extends JFrame {

	private JPanel contentPane;
	private Aplicacion app;
	private Imagenes img;
	

	/**
	 * Create the frame.
	 * @param reporteHPersonas 
	 * @param reporteActividad 
	 */
	public reportes(Aplicacion aplicacion, HashMap<String, HashMap<String, Double>> reporteActividad, HashMap<String, String> reporteHPersonas) {
		setIconImage(img.BULB);
		app = aplicacion;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Si falla poner exit
		setBounds(100, 100, 600, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//System.out.println("REPORTE POR TIPO ACTIVIDAD"); pasar a label
		for(String tipo:reporteActividad.keySet()) {
			//System.out.println("Tipo Atividad: "+ tipo);
			int count =1;
			for(String correo:reporteActividad.get(tipo).keySet()) {
				//System.out.println("\n"+count+ ". "+correo+"\tTiempo: "+reporteActividad.get(tipo).get(correo));
				String combo = "Tipo Actividad: " + tipo + " " +count+ ". "+correo+"\tTiempo: "+reporteActividad.get(tipo).get(correo);
				count+=1;
			}
		}
		
		for (String msj: reporteHPersonas.values()){
			
		}
		
		JButton btnReporteMensual = new JButton("Reporte Mensual");
		btnReporteMensual.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReporteMensual.setBounds(26, 346, 171, 57);
		btnReporteMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					
					
					
					app.setGenerarReporte(reporteActividad, reporteHPersonas);
					app.VisibleGenerarReporte(true);
					setVisible(false);
			} 
			});
		contentPane.add(btnReporteMensual);
		
		JButton btnSumUpProyecto = new JButton("Sum Up Proyecto");
		btnSumUpProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSumUpProyecto.setBounds(26, 278, 171, 57);
		btnSumUpProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					
					
					
					app.setReporteSumups();
					app.ReporteSumup(true);
					setVisible(false);
			} 
			});
		contentPane.add(btnSumUpProyecto);
		
		JButton btnRendimientoEquipo = new JButton("Rendimiento Equipo");
		btnRendimientoEquipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRendimientoEquipo.setBounds(26, 210, 171, 57);
		btnRendimientoEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					
					
					
					app.setReporteEquipo();
					app.VisibleReporteEquipo(true);
					setVisible(false);
			} 
			});
		contentPane.add(btnRendimientoEquipo);
		
		JButton btnCalidadPlaneacin = new JButton("Calidad Planeaci\u00F3n");
		btnCalidadPlaneacin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalidadPlaneacin.setBounds(26, 143, 171, 57);
		btnCalidadPlaneacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					
					
					
					app.setReporteCalidadPlanning();
					app.VisibleReporteCalidadPlanning(true);
					setVisible(false);
			} 
			});
		contentPane.add(btnCalidadPlaneacin);
		
		JButton btnAvanceProyecto = new JButton("Avance Proyecto");
		btnAvanceProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAvanceProyecto.setBounds(26, 77, 171, 57);
		btnAvanceProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					
					
					
					app.setReporteAvanceProy();
					app.VisibleReporteAvaceProy(true);
					setVisible(false);
			} 
			});
		contentPane.add(btnAvanceProyecto);
		
		JLabel lblNewLabel_1 = new JLabel("Generador de Reportes!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(21, 24, 176, 22);
		contentPane.add(lblNewLabel_1);
        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(reportes.class.getResource("/Graficos/report.png")));
		lblNewLabel.setBounds(111, 24, 467, 474);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setBounds(26, 426, 89, 23);
		contentPane.add(btnNewButton);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				app.VisibleMenuAct(true);
			}
		});
        
	}
	
    

}