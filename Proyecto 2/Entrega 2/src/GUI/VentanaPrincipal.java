package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Imagenes img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(img.BULB));
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive - Universidad de los Andes\\Documentos\\3er Semestre\\DPOO\\Proy 1\\Proyecto_DPOO\\Proyecto 2\\Entrega 2\\src\\Graficos\\1087815.png"));
		lblNewLabel.setBounds(371, 0, 347, 420);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escoger proyecto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(45, 134, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(100);
		comboBox.setToolTipText("");
		comboBox.setBounds(168, 131, 125, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(168, 164, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCrearNuevoProyecto = new JButton("Crear Nuevo Proyecto");
		btnCrearNuevoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearNuevoProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearNuevoProyecto.setBounds(59, 224, 181, 22);
		contentPane.add(btnCrearNuevoProyecto);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenido a Proyect Manager!");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(44, 40, 317, 38);
		contentPane.add(lblNewLabel_2);
	}
}
