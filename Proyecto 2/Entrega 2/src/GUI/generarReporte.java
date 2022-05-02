package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
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
import java.awt.Graphics;
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
		app = aplicacion;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Si falla poner exit
		setBounds(100, 100, 600, 700);
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
		
		
		
		
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setBounds(40, 200, 200, 25);
        btnGraficar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
            	
            	aplicacion.generarGrafico();
            	
            	repaint();
            }
        });
        contentPane.add(btnGraficar);
        
        JPanel panel22 = new JPanel();
		panel22.setBounds(39, 230, 500, 400);
		contentPane.add(panel22);
		panel22.setLayout(null);
        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(generarReporte.class.getResource("/Graficos/report.png")));
		lblNewLabel.setBounds(111, 24, 467, 474);
		contentPane.add(lblNewLabel);
        
	}
	
	public void paint(Graphics g)
    {
        super.paint(g);
        boolean bandera;
        bandera = true;
		if (bandera==true)
        {
			HashMap<String, Integer> grafico = app.generarGrafico();
			
            int v1 = grafico.get("01");
            int v2 = grafico.get("02");
            int v3 = grafico.get("03");
            int v4 = grafico.get("04");
            int v5 = grafico.get("05");
            int v6 = grafico.get("06");
            int v7 = grafico.get("07");
            int v8 = grafico.get("08");
            int v9 = grafico.get("09");
            int v10 = grafico.get("10");
            int v11 = grafico.get("11");
            int v12 = grafico.get("12");
            
            
            int suma = v1 +v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + v10 + v11 + v12;
            int grados1=v1*360/suma;
            int grados2=v2*360/suma;
            int grados3=v3*360/suma;
            int grados4=v4*360/suma;
            int grados5=v5*360/suma;
            int grados6=v6*360/suma;
            int grados7=v7*360/suma;
            int grados8=v8*360/suma;
            int grados9=v9*360/suma;
            int grados10=v10*360/suma;
            int grados11=v11*360/suma;
            int grados12=v12*360/suma;

            g.setColor(new Color(255,0,0));
            g.fillArc(100,350,200,200,0,grados1);
            g.fillRect(350,270,20,20);
            g.drawString("Enero", 400, 290);            

            g.setColor(new Color(0,128,0));
            g.fillArc(100,350,200,200,grados1,grados2);
            g.fillRect(350,310,20,20);
            g.drawString("Febrero", 400, 320);            

            g.setColor(new Color(0,0,255));
            g.fillArc(100,350,200,200,grados1+grados2,grados3);
            g.fillRect(350,340,20,20);
            g.drawString("Marzo", 400, 350);
            
            g.setColor(new Color(0,255,0));
            g.fillArc(100,350,200,200,grados1+grados2+grados3,grados4);
            g.fillRect(350,370,20,20);
            g.drawString("Abril", 400, 380);
            
            g.setColor(new Color(20,20,20));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4,grados5);
            g.fillRect(350,400,20,20);
            g.drawString("Mayo", 400, 410); 
            
            g.setColor(new Color(100,20,20));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5,grados6);
            g.fillRect(350,430,20,20);
            g.drawString("Junio", 400, 440);
            
            g.setColor(new Color(20,100,20));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5+grados6,grados7);
            g.fillRect(350,480,20,20);
            g.drawString("Julio", 400, 470);
            
            g.setColor(new Color(20,20,100));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5+grados6+grados7,grados8);
            g.fillRect(350,510,20,20);
            g.drawString("Agosto", 400, 500);
            
            g.setColor(new Color(100,100,100));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5+grados6+grados7+grados8,grados9);
            g.fillRect(350,540,20,20);
            g.drawString("Septiembre", 400, 530);
            
            g.setColor(new Color(200,200,200));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5+grados6+grados7+grados8+grados9,grados10);
            g.fillRect(350,570,20,20);
            g.drawString("Octubre", 400, 560);
            
            g.setColor(new Color(255,255,255));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5+grados6+grados7+grados8+grados9+grados10,grados11);
            g.fillRect(350,600,20,20);
            g.drawString("Noviembre", 400, 590);
            
            g.setColor(new Color(255,0,255));
            g.fillArc(100,350,200,200,grados1+grados2+grados3+grados4+grados5+grados6+grados7+grados8+grados9+grados10+grados11,grados12);
            g.fillRect(350,630,20,20);
            g.drawString("Diciembre", 400, 620);
            
        }
        
    }
    

}