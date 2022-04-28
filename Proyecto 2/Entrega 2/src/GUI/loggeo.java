package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;

public class loggeo extends JFrame {

	private JPanel contentPane;
	private Imagenes img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loggeo frame = new loggeo();
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
	public loggeo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(175, 57, 225, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Aqui escribir proyecto actual");
		lblNewLabel_1.setBackground(new Color(105, 105, 105));
		lblNewLabel_1.setBounds(10, 11, 174, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Proyecto seleccionado: ");
		lblNewLabel.setBounds(40, 57, 133, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblIngrese = new JLabel("Ingrese el correo con el que se registro: ");
		lblIngrese.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngrese.setBounds(247, 109, 243, 14);
		contentPane.add(lblIngrese);
		
		JFormattedTextField frmtdtxtfldExamplehotmailcom = new JFormattedTextField();
		frmtdtxtfldExamplehotmailcom.setForeground(new Color(105, 105, 105));
		frmtdtxtfldExamplehotmailcom.setText("example@hotmail.com");
		frmtdtxtfldExamplehotmailcom.setBounds(247, 133, 243, 20);
		contentPane.add(frmtdtxtfldExamplehotmailcom);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(247, 164, 107, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		//lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive - Universidad de los Andes\\Documentos\\3er Semestre\\DPOO\\Proy 1\\Proyecto_DPOO\\Proyecto 2\\Entrega 2\\src\\Graficos\\2721273.png"));
		lblNewLabel_2.setIcon(new ImageIcon(img.LOG));
		lblNewLabel_2.setBounds(25, 169, 148, 136);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(175, 282, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
