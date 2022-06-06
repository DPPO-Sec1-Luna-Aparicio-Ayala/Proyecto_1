package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class listaPaquetes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	public listaPaquetes(Aplicacion aplicacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(listaPaquetes.class.getResource("/Graficos/magic.png")));
		lblNewLabel.setBounds(165, -14, 389, 430);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione Paquete:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 81, 167, 29);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 109, 145, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(10, 276, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(109, 276, 89, 23);
		contentPane.add(btnRegresar);
	}
}
