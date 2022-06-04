package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;
import Modelo.Proyecto;

public class loggeo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Imagenes img;
	private Aplicacion app;
	private JLabel proyectoActual;
	private JFormattedTextField frmtdtxtfldExamplehotmailcom;
	private JButton LogInBtn;
	private JButton returnBtn;

	/**
	 * Create the frame.
	 */
	public loggeo(Aplicacion aplicacion) {
		setIconImage(img.BULB);
		app = aplicacion;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 525, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(175, 21, 225, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		proyectoActual = new JLabel(app.darProyectoActual().getNombre());
		proyectoActual.setBackground(new Color(105, 105, 105));
		proyectoActual.setBounds(10, 11, 174, 14);
		panel.add(proyectoActual);
		
		JLabel lblNewLabel = new JLabel("Proyecto seleccionado: ");
		lblNewLabel.setBounds(40, 21, 133, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblIngrese = new JLabel("Ingrese el correo con el que se registro: ");
		lblIngrese.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngrese.setBounds(247, 109, 243, 14);
		contentPane.add(lblIngrese);
		
		frmtdtxtfldExamplehotmailcom = new JFormattedTextField();
		frmtdtxtfldExamplehotmailcom.setForeground(new Color(105, 105, 105));
		frmtdtxtfldExamplehotmailcom.setText("example@hotmail.com");
		frmtdtxtfldExamplehotmailcom.setBounds(247, 133, 243, 20);
		contentPane.add(frmtdtxtfldExamplehotmailcom);
		
		LogInBtn = new JButton("Log in");
		LogInBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		LogInBtn.setBounds(247, 164, 107, 34);
		LogInBtn.addActionListener(app);
		contentPane.add(LogInBtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(img.LOG));
		lblNewLabel_2.setBounds(25, 169, 148, 136);
		contentPane.add(lblNewLabel_2);
		
		returnBtn = new JButton("Regresar");
		returnBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		returnBtn.setBounds(175, 282, 89, 23);
		returnBtn.addActionListener(this);
		contentPane.add(returnBtn);
	}
	
	public JButton getLogInBtn() {
		return LogInBtn;
	}
	
	public String getEmail() {
		String textoIngresado = frmtdtxtfldExamplehotmailcom.getText();
		String textoCorregido = textoIngresado.replace(" ", "");
		return textoCorregido;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==returnBtn) {
			setVisible(false);
		}
		
	}
}
