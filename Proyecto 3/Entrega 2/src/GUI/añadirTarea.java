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
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class añadirTarea extends JFrame {

	private JPanel contentPane;
	private JTextField txtT;
	private JTextField txtSeRealizo;
	private JTextField txtminutos;
	private JTextField txtDdmmaa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					añadirTarea frame = new añadirTarea();
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
	public añadirTarea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(148, 148, 134, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(148, 107, 134, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tipo Tarea:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1_1_1.setBounds(149, 89, 110, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("A\u00F1adir Tarea:");
		lblNewLabel_1.setBounds(10, 11, 571, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 39, 238, 36);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Paquete Actual:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(0, 11, 115, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Tarea: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 89, 110, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtT = new JTextField();
		txtT.setForeground(new Color(105, 105, 105));
		txtT.setText("T1");
		txtT.setBounds(10, 108, 110, 20);
		contentPane.add(txtT);
		txtT.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(añadirTarea.class.getResource("/Graficos/completed-task.png")));
		lblNewLabel_2.setBounds(233, 11, 348, 540);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Descripci\u00F3n: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(10, 132, 110, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtSeRealizo = new JTextField();
		txtSeRealizo.setText("Se realizo..");
		txtSeRealizo.setForeground(SystemColor.controlDkShadow);
		txtSeRealizo.setColumns(10);
		txtSeRealizo.setBounds(10, 149, 110, 20);
		contentPane.add(txtSeRealizo);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tiempo estimado:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1.setBounds(10, 176, 110, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtminutos = new JTextField();
		txtminutos.setText("(minutos)");
		txtminutos.setForeground(SystemColor.controlDkShadow);
		txtminutos.setColumns(10);
		txtminutos.setBounds(10, 189, 110, 20);
		contentPane.add(txtminutos);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Fecha finalizaci\u00F3n:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1_1.setBounds(10, 220, 110, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtDdmmaa = new JTextField();
		txtDdmmaa.setText("DD/MM/AA");
		txtDdmmaa.setForeground(SystemColor.controlDkShadow);
		txtDdmmaa.setColumns(10);
		txtDdmmaa.setBounds(10, 235, 110, 20);
		contentPane.add(txtDdmmaa);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Encargado:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(149, 132, 110, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(10, 348, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(110, 348, 89, 23);
		contentPane.add(btnRegresar);
	}
}
