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
import Modelo.Actividad;

public class EscogerActiAModificar extends JFrame {

	private JPanel contentPane;
	private Imagenes img;
	private String actividadSeleccionada;
	
	/**
	 * Create the frame.
	 */
	public EscogerActiAModificar(Aplicacion app) {
		setIconImage(img.BULB);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 518, 342);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoja la actividad que desea modificar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 76, 285, 32);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 119, 227, 32);
		for (String act : app.darProyectoActual().getActividades().keySet()) {
			comboBox.addItem(act);		
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				actividadSeleccionada = (String) comboBox.getSelectedItem();
			}
			});
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ModificarActividad.class.getResource("/Graficos/modificar.png")));
		lblNewLabel_1.setBounds(206, -208, 522, 500);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 216, 101, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				setVisible(false);
				app.setActividadModificar(comboBox.getSelectedItem().toString());
				app.VisibleModificarActividad(true);
			}
			});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(121, 216, 105, 23);
		contentPane.add(btnNewButton_1);
	}
}
