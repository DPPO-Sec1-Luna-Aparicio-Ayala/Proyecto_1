package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class añadirParticipante extends JFrame {

	private JPanel contentPane;
	private JTextField txtPepito;
	private JTextField txtExamplegmailcom;
	private Aplicacion app;

	/**
	 * Create the frame.
	 */
	public añadirParticipante(Aplicacion aplicacion) {
		app=aplicacion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 346);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(añadirParticipante.class.getResource("/Graficos/participe.png")));
		lblNewLabel.setBounds(-116, 0, 447, 488);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("A\u00F1adir Participante!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(279, 27, 165, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPepito = new JTextField();
		txtPepito.setForeground(new Color(128, 128, 128));
		txtPepito.setText("pepito ");
		txtPepito.setBounds(309, 95, 135, 20);
		contentPane.add(txtPepito);
		txtPepito.setColumns(10);
		
		txtExamplegmailcom = new JTextField();
		txtExamplegmailcom.setForeground(new Color(128, 128, 128));
		txtExamplegmailcom.setText("example@gmail.com");
		txtExamplegmailcom.setBounds(308, 161, 136, 20);
		contentPane.add(txtExamplegmailcom);
		txtExamplegmailcom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(309, 76, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingrese correo:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(309, 140, 94, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.setBounds(307, 220, 135, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPepito.getText().equals("") || txtExamplegmailcom.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane,"Hay una o mas casillas que siguen en blanco, rellene todas por favor");
				}
				else {
			
				String nombre = txtPepito.getText();
				String correo = txtExamplegmailcom.getText();
				if(!app.darProyectoActual().getParticipantes().isEmpty()){
					app.ejecutarAñadirParticipante(nombre,correo,false);
					setVisible(false); 
					app.VisibleMenuAct(true);
					JOptionPane.showMessageDialog(contentPane,"Se ha añadido a "+nombre+" como participante!");
				}
				
				}
			}
			});
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
