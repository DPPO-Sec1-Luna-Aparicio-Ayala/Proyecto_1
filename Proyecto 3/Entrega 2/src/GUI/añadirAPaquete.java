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
import javax.swing.JButton;

public class añadirAPaquete extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					añadirAPaquete frame = new añadirAPaquete();
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
	public añadirAPaquete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirAPaquete = new JLabel("A\u00F1adir a Paquete!");
		lblAadirAPaquete.setForeground(Color.BLACK);
		lblAadirAPaquete.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAadirAPaquete.setBackground(Color.BLACK);
		lblAadirAPaquete.setBounds(69, 11, 175, 22);
		contentPane.add(lblAadirAPaquete);
		
		lblNewLabel = new JLabel("Paquete Actual:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(24, 58, 91, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear Actividad");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(134, 87, 171, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Actividad");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(134, 155, 171, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Crear Actividad");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(134, 221, 171, 57);
		contentPane.add(btnNewButton_2);
	}

}
