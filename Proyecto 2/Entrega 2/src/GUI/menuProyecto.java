package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;

public class menuProyecto extends JFrame {

	private JPanel contentPane;
	private Imagenes img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuProyecto frame = new menuProyecto();
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
	public menuProyecto() {
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
		
		JButton btnNewButton_4 = new JButton("Regresar Inicio");
		btnNewButton_4.setBounds(372, 328, 105, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Salir App");
		btnNewButton_5.setBounds(493, 328, 97, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
<<<<<<< HEAD
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\4245516.png"));
		lblNewLabel_1.setIcon(new ImageIcon(img.WELCOME));
		lblNewLabel_1.setBounds(22, 190, 140, 233);
=======
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Downloads\\4245516.png"));
		lblNewLabel_1.setBounds(48, 230, 140, 233);
>>>>>>> 9236633e5379ea756cba7b0872042014b9346a06
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(157, 114, 378, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Actividad");
		btnNewButton.setBounds(11, 8, 171, 57);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_6 = new JButton("Modificar Actividad");
		btnNewButton_6.setBounds(198, 8, 171, 57);
		panel.add(btnNewButton_6);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_6_1 = new JButton("A\u00F1adir Participante");
		btnNewButton_6_1.setBounds(12, 72, 171, 57);
		panel.add(btnNewButton_6_1);
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_6_1_1 = new JButton("Generar Reporte");
		btnNewButton_6_1_1.setBounds(197, 72, 171, 57);
		panel.add(btnNewButton_6_1_1);
		btnNewButton_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(menuProyecto.class.getResource("/Graficos/4245516.png")));
		lblNewLabel_2.setBounds(10, 230, 152, 121);
		contentPane.add(lblNewLabel_2);
	}

}
