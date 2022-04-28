package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ModificarActividad extends JFrame {

	private JPanel contentPane;
	private JTextField txtDejarEnBlanco;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNewLabel_1_1_3;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarActividad frame = new ModificarActividad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarActividad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modificar Actividad!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 23, 165, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cambiar Fecha Inicio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(74, 91, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDejarEnBlanco = new JTextField();
		txtDejarEnBlanco.setForeground(new Color(119, 136, 153));
		txtDejarEnBlanco.setText("Dejar en blanco si no realizara cambios");
		txtDejarEnBlanco.setBounds(84, 109, 202, 20);
		contentPane.add(txtDejarEnBlanco);
		txtDejarEnBlanco.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Dejar en blanco si no realizara cambios");
		textField.setForeground(new Color(119, 136, 153));
		textField.setColumns(10);
		textField.setBounds(84, 172, 202, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Dejar en blanco si no realizara cambios");
		textField_1.setForeground(new Color(119, 136, 153));
		textField_1.setColumns(10);
		textField_1.setBounds(84, 280, 202, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Dejar en blanco si no realizara cambios");
		textField_2.setForeground(new Color(119, 136, 153));
		textField_2.setColumns(10);
		textField_2.setBounds(84, 336, 202, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cambiar Fecha Fin:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(74, 147, 137, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cambiar Encargado");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(71, 219, 165, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		lblNewLabel_1_1_2 = new JLabel("Introduzca su nombre:");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(88, 255, 165, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		lblNewLabel_1_1_3 = new JLabel("Introduzca su correo:");
		lblNewLabel_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_3.setBounds(84, 311, 165, 14);
		contentPane.add(lblNewLabel_1_1_3);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(84, 387, 111, 14);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ModificarActividad.class.getResource("/Graficos/enviar-mensaje.png")));
		lblNewLabel_2.setBounds(221, -20, 315, 564);
		contentPane.add(lblNewLabel_2);
	}
}
