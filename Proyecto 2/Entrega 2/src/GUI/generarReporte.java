package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class generarReporte extends JFrame {

	private JPanel contentPane;
	private Aplicacion app;
	

	/**
	 * Create the frame.
	 */
	public generarReporte(Aplicacion aplicacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Generar Reporte");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(53, 171, 201, 68);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(generarReporte.class.getResource("/Graficos/report.png")));
		lblNewLabel.setBounds(111, 24, 467, 474);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Generador de Reportes!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(38, 52, 176, 22);
		contentPane.add(lblNewLabel_1);
	}
}
