package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;

public class CrearProyecto extends JFrame {

	private JPanel contentPane;
	private JTextField txtS;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Imagenes img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProyecto frame = new CrearProyecto();
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
	public CrearProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Proyecto: ");
		lblNewLabel.setBounds(76, 75, 104, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		
		txtS = new JTextField();
		txtS.setBounds(180, 75, 118, 20);
		panel.add(txtS);
		txtS.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(106, 106, 104, 14);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblDescripcin);
		
		textField = new JTextField();
		textField.setBounds(180, 131, 118, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 103, 118, 20);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(106, 134, 104, 14);
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaFin.setBounds(106, 162, 104, 14);
		panel.add(lblFechaFin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 159, 118, 20);
		panel.add(textField_2);
		
		JLabel lblNombreAdminProyecto = new JLabel("Nombre admin:");
		lblNombreAdminProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreAdminProyecto.setBounds(88, 190, 147, 14);
		panel.add(lblNombreAdminProyecto);
		
		JLabel lblCorreoAdmin = new JLabel("Correo admin:");
		lblCorreoAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreoAdmin.setBounds(98, 218, 147, 14);
		panel.add(lblCorreoAdmin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 187, 118, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 215, 118, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive - Universidad de los Andes\\Documentos\\3er Semestre\\DPOO\\Proy 1\\Proyecto_DPOO\\Proyecto 2\\Entrega 2\\src\\Graficos\\3380841.png"));
		lblNewLabel_1.setIcon(new ImageIcon(img.WORKSPACE));
		lblNewLabel_1.setBounds(380, 0, 408, 466);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Crear Proyecto");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 245, 238));
		btnNewButton.setBounds(146, 279, 118, 23);
		panel.add(btnNewButton);
	}
}
