package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CronometrarActividad extends JFrame {

	private JPanel contentPane;
	private JFrame presente; 

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CronometrarActividad frame = new CronometrarActividad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 * @param aplicacion 
	 */
	public CronometrarActividad(Aplicacion aplicacion) {
		
		presente = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cronometro Actividades!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(41, 21, 242, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Iniciar Cronometro");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(43, 60, 186, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				aplicacion.IniciarTemporizador();
				JOptionPane.showMessageDialog(presente,"El tiempo esta corriendo");
			}
			});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pausar Cronometro");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(43, 133, 186, 47);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				aplicacion.PausarTemporizador();
				JOptionPane.showMessageDialog(presente,"Ha pausado el tiempo, oprima INICIAR CRONOMETRO para reanudarlo");
			}
			});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finalizar ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(43, 206, 186, 47);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long tiempo = aplicacion.FinalizarTemporizador();
				JOptionPane.showMessageDialog(presente,"Ha finalizado el tiempo, ha trabajado: " + String.valueOf(tiempo) + " segundos");
				setVisible(false);
				aplicacion.VisibleMenuAct();
				
			}
			});
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive - Universidad de los Andes\\Documentos\\3er Semestre\\DPOO\\Proy 1\\Proyecto_DPOO\\Proyecto 2\\Entrega 2\\src\\Graficos\\cronometro.png"));
		lblNewLabel_1.setBounds(220, 0, 343, 370);
		contentPane.add(lblNewLabel_1);
	}

}
