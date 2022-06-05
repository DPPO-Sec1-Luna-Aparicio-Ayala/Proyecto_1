package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class añadirPaquete {

	private JFrame frame;
	private JTextField txtPack;
	private JTextField txtSeDiseoPara;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					añadirPaquete window = new añadirPaquete();
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
	public añadirPaquete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Enviar");
		btnNewButton_1.setBounds(179, 209, 101, 22);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.setBounds(298, 209, 101, 22);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Crear Paquete!");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(61, 11, 175, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Paquete: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(61, 61, 110, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(añadirPaquete.class.getResource("/Graficos/boxes.png")));
		lblNewLabel_2.setBounds(154, -15, 309, 294);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtPack = new JTextField();
		txtPack.setForeground(new Color(105, 105, 105));
		txtPack.setText("Pack1");
		txtPack.setBounds(60, 76, 128, 20);
		frame.getContentPane().add(txtPack);
		txtPack.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripci\u00F3n Paquete: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(61, 107, 127, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtSeDiseoPara = new JTextField();
		txtSeDiseoPara.setText("Se dise\u00F1o para...");
		txtSeDiseoPara.setForeground(SystemColor.controlDkShadow);
		txtSeDiseoPara.setColumns(10);
		txtSeDiseoPara.setBounds(61, 122, 128, 20);
		frame.getContentPane().add(txtSeDiseoPara);
		frame.setBounds(100, 100, 463, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
