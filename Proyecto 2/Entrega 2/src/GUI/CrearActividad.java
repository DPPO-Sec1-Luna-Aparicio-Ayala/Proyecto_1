package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;

public class CrearActividad extends JFrame {

	private JPanel contentPane;
	private Imagenes img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearActividad frame = new CrearActividad();
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
	public CrearActividad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(img.IDEA));
		lblNewLabel_1.setBounds(-55, 0, 480, 440);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(419, 0, 262, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTipoActividad = new JLabel("Tipo Actividad:");
		lblTipoActividad.setBounds(33, 164, 83, 14);
		panel.add(lblTipoActividad);
		lblTipoActividad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 160, 106, 22);
		panel.add(comboBox);
		
		JFormattedTextField frmtdtxtfldRealice = new JFormattedTextField();
		frmtdtxtfldRealice.setBounds(126, 118, 106, 20);
		panel.add(frmtdtxtfldRealice);
		frmtdtxtfldRealice.setText("Realice...");
		frmtdtxtfldRealice.setForeground(SystemColor.controlDkShadow);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(53, 121, 106, 14);
		panel.add(lblDescripcin);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo Actividad:");
		lblNewLabel.setBounds(33, 82, 106, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JFormattedTextField frmtdtxtfldActividad = new JFormattedTextField();
		frmtdtxtfldActividad.setBounds(126, 79, 106, 20);
		panel.add(frmtdtxtfldActividad);
		frmtdtxtfldActividad.setForeground(new Color(105, 105, 105));
		frmtdtxtfldActividad.setText("Actividad1...");
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(143, 335, 89, 23);
		panel.add(btnNewButton);
	}
}
