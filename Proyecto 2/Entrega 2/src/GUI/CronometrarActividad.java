package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;

public class CronometrarActividad extends JFrame {

	private JPanel contentPane;
	private JFrame presente; 
	private Imagenes img;
	private Aplicacion app;

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
		app = aplicacion;
		setIconImage(img.CRONOMETRO);
		presente = new JFrame();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Si falla poner exit
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
				if(app.estaCronometrando() == app.PAUSADO || app.estaCronometrando() == app.APAGADO) {
					app.IniciarTemporizador();
					JOptionPane.showMessageDialog(presente,"El tiempo está corriendo.");
				} else {
					JOptionPane.showMessageDialog(presente,"El cronómetro ya está corriendo.");
				}
			}
			});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pausar Cronometro");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(43, 133, 186, 47);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (app.estaCronometrando() == app.CRONOMETRANDO) {
					app.PausarTemporizador();
					JOptionPane.showMessageDialog(presente,"Ha pausado el tiempo, oprima INICIAR CRONOMETRO para reanudarlo");
				} else if (app.estaCronometrando() == app.APAGADO){
					JOptionPane.showMessageDialog(presente,"Primero inicie el cronómetro.");
				} else if (app.estaCronometrando() == app.PAUSADO){
					JOptionPane.showMessageDialog(presente,"El tiempo ya está pausado.");
				}
				
			}
			});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finalizar ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(43, 206, 186, 47);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(app.estaCronometrando() == app.PAUSADO || app.estaCronometrando() == app.CRONOMETRANDO) {
					long tiempo = aplicacion.FinalizarTemporizador();
					JOptionPane.showMessageDialog(presente,"Ha finalizado el tiempo. a trabajado: " + String.valueOf(tiempo) + " segundos");
					setVisible(false);
					aplicacion.terminarActividad();
					aplicacion.VisibleMenuAct(true);
				} else {
					JOptionPane.showMessageDialog(presente,"Primero inicie el cronómetro.");
				}
				
			}
			});
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CronometrarActividad.class.getResource("/Graficos/cronometro.png")));
		lblNewLabel_1.setBounds(169, 0, 394, 448);
		contentPane.add(lblNewLabel_1);
	}

}
