package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class CrearActividad extends JFrame {

	private JPanel contentPane;

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
		
		JFormattedTextField frmtdtxtfldActividad = new JFormattedTextField();
		frmtdtxtfldActividad.setForeground(new Color(105, 105, 105));
		frmtdtxtfldActividad.setText("Actividad1...");
		frmtdtxtfldActividad.setBounds(507, 46, 106, 20);
		contentPane.add(frmtdtxtfldActividad);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo Actividad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(406, 49, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcin.setBounds(431, 74, 106, 14);
		contentPane.add(lblDescripcin);
		
		JFormattedTextField frmtdtxtfldRealice = new JFormattedTextField();
		frmtdtxtfldRealice.setText("Realice...");
		frmtdtxtfldRealice.setForeground(SystemColor.controlDkShadow);
		frmtdtxtfldRealice.setBounds(507, 71, 106, 20);
		contentPane.add(frmtdtxtfldRealice);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(507, 99, 106, 22);
		contentPane.add(comboBox);
		
		JLabel lblTipoActividad = new JLabel("Tipo Actividad:");
		lblTipoActividad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoActividad.setBounds(418, 103, 106, 14);
		contentPane.add(lblTipoActividad);
	}

}
