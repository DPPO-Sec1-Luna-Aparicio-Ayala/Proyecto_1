package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import Graficos.Imagenes;
import Modelo.Proyecto;

public class menuProyecto extends JFrame {

	private JPanel contentPane;
	private Imagenes img;
	public boolean crearAct;
	

	/**
	 * Create the frame.
	 * @param principal 
	 * @param escogerActividad 
	 * @param crearActividad 
	 * @param aplicacion 
	 */
	public menuProyecto(Aplicacion app) {
		setIconImage(img.BULB);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEN\u00DA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(303, 34, 97, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_Proy = new JLabel("Proyecto Actual: " + app.darProyectoActual().getNombre());
		lblNewLabel_Proy.setForeground(new Color(255, 255, 255));
		lblNewLabel_Proy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Proy.setBounds(210, 260, 280, 40);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        lblNewLabel_Proy.setBorder(border);
		contentPane.add(lblNewLabel_Proy);
		
		JButton btnNewButton_4 = new JButton("Atr\u00E1s");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBounds(372, 328, 105, 23);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				app.VisiblePrincipal(true);
				setVisible(false);
			}
			});
		contentPane.add(btnNewButton_4);
		
		
		JButton btnNewButton_5 = new JButton("Salir");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(493, 328, 97, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					app.persistenciaArchivoGuardar();
					System.exit(EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			});
		contentPane.add(btnNewButton_5);
		
		/*
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\4245516.png"));
		lblNewLabel_1.setIcon(new ImageIcon(img.WELCOME));
		//lblNewLabel_1.setBounds(22, 190, 140, 233);
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\4245516.png"));
		lblNewLabel_1.setBounds(48, 230, 140, 233);
		contentPane.add(lblNewLabel_1);*/
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(157, 114, 378, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Actividad");
		btnNewButton.setBounds(11, 8, 171, 57);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				app.setCrearActividad();
				app.VisibleCrearActividad(true);
				setVisible(false);
			}
			});
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_6 = new JButton("Modificar Actividad");
		btnNewButton_6.setBounds(198, 8, 171, 57);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(app.darProyectoActual().getActividades().size() != 0) {
					app.setEscogerActividad();
					app.VisibleEscogerActividad(true); 
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(contentPane,"Primero cree una actividad.");	
				}
			} 
			});
		panel.add(btnNewButton_6);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_6_1 = new JButton("A\u00F1adir Participante");
		btnNewButton_6_1.setBounds(12, 72, 171, 57);
		panel.add(btnNewButton_6_1);
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_6_1_1 = new JButton("Generar Reporte");
		btnNewButton_6_1_1.setBounds(197, 72, 171, 57);
		btnNewButton_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					app.setGenerarReporte();
					app.VisibleGenerarReporte(true); //Verificar si reporte si queda visible
					setVisible(false);
			} 
			});
		panel.add(btnNewButton_6_1_1);
		btnNewButton_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(img.WELCOME));
		lblNewLabel_2.setBounds(10, 230, 152, 121);
		contentPane.add(lblNewLabel_2);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try {
					app.persistenciaArchivoGuardar();
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

	public boolean CrearAct() {
		return crearAct;
	}
	
	
	

}
