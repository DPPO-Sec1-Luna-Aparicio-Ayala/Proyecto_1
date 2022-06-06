package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class añadirAPaquete extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private Aplicacion app;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param aplicacion 
	 */
	public añadirAPaquete(Aplicacion aplicacion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 195, 16);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Paquete Actual:");
		lblNewLabel.setBounds(0, 0, 89, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAadirAPaquete = new JLabel("A\u00F1adir a Paquete!");
		lblAadirAPaquete.setBounds(10, 11, 175, 22);
		lblAadirAPaquete.setForeground(Color.WHITE);
		lblAadirAPaquete.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAadirAPaquete.setBackground(Color.BLACK);
		contentPane.add(lblAadirAPaquete);
		
		JButton btnNewButton = new JButton("A\u00F1adir Tarea");
		btnNewButton.setBounds(14, 87, 171, 57);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				app.setCrearAñadirTarea();
				app.VisibleCrearAñadirTarea(true); 
				setVisible(false);
		} 
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir Paquete");
		btnNewButton_1.setBounds(14, 153, 171, 57);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				app.setCrearAñadirPaquete();
				app.VisibleCrearAñadirPaquete(true); 
				setVisible(false);
		} 
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Escoger Paquete");
		btnNewButton_2.setBounds(14, 221, 171, 57);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				app.setListaPaquetes();
				app.VisibleListaPaquetes(true); 
				setVisible(false);
		} 
		});
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(125, 0, 384, 459);
		lblNewLabel_1.setIcon(new ImageIcon(añadirAPaquete.class.getResource("/Graficos/open-box.png")));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.setBounds(26, 356, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
