package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class crearAñadirPaquete {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearAñadirPaquete window = new crearAñadirPaquete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public crearAñadirPaquete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.getContentPane().setLayout(null);
		
		JLabel lblWbs = new JLabel("W ");
		lblWbs.setForeground(new Color(255, 255, 255));
		lblWbs.setFont(new Font("Tahoma", Font.BOLD, 75));
		lblWbs.setBounds(317, 39, 443, 74);
		frame.getContentPane().add(lblWbs);
		
		JButton btnNewButton = new JButton("Nuevo Paquete");
		btnNewButton.setToolTipText("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 194, 126, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnModificarPaqueteExistente = new JButton("Editar paquete");
		btnModificarPaqueteExistente.setBounds(136, 194, 131, 23);
		frame.getContentPane().add(btnModificarPaqueteExistente);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(crearAñadirPaquete.class.getResource("/Graficos/planner.png")));
		lblNewLabel.setBounds(-212, 0, 521, 535);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblB = new JLabel("B");
		lblB.setForeground(new Color(255, 255, 255));
		lblB.setFont(new Font("Tahoma", Font.BOLD, 87));
		lblB.setBounds(327, 111, 278, 74);
		frame.getContentPane().add(lblB);
		
		JLabel lblS = new JLabel("S");
		lblS.setForeground(new Color(255, 255, 255));
		lblS.setFont(new Font("Tahoma", Font.BOLD, 87));
		lblS.setBounds(326, 187, 313, 74);
		frame.getContentPane().add(lblS);
		
		JButton btnModificarPaqueteExistente_1 = new JButton("Regresar");
		btnModificarPaqueteExistente_1.setBounds(317, 306, 103, 23);
		frame.getContentPane().add(btnModificarPaqueteExistente_1);
		frame.setBounds(100, 100, 450, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
