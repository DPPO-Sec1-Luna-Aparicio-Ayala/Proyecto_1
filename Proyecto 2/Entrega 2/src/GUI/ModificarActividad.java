package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;
import Modelo.Actividad;
import javax.swing.JComboBox;

public class ModificarActividad extends JFrame {
	private Imagenes img;
	private JPanel contentPane;
	private JTextField txtDejarEnBlanco;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private String aModificar;
	private int modificaciones;
	private String encargado;
	private Modelo.Participante acargo;
	private Aplicacion app;

	public static final int ENCARGADO = 1;
	public static final int FECHA_INICIO = 2;
	public static final int FECHA_FIN = 3;
	public static final int FECHAS = 4;
	public static final int TODO = 5;

	/**
	 * Create the frame.
	 */
	public ModificarActividad(Aplicacion aplicacion) {
		app = aplicacion;
		setIconImage(img.BULB);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 552, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modificar Actividad!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 23, 165, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cambiar Fecha Inicio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(74, 91, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDejarEnBlanco = new JTextField();
		txtDejarEnBlanco.setForeground(new Color(119, 136, 153));
		txtDejarEnBlanco.setText("Dejar en blanco si no realizara cambios");
		txtDejarEnBlanco.setBounds(84, 109, 202, 20);
		contentPane.add(txtDejarEnBlanco);
		txtDejarEnBlanco.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Dejar en blanco si no realizara cambios");
		textField.setForeground(new Color(119, 136, 153));
		textField.setColumns(10);
		textField.setBounds(84, 172, 202, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cambiar Fecha Fin:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(74, 147, 137, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cambiar Encargado");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(71, 219, 165, 14);
		contentPane.add(lblNewLabel_1_1_1);
		JComboBox comboBox = new JComboBox();
		for (Modelo.Participante partipante : app.darProyectoActual().getParticipantes()) {
			String nombre = partipante.getNombre();
			comboBox.addItem(nombre);		
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				encargado = (String) comboBox.getSelectedItem();
				
				for (Modelo.Participante parti: app.darProyectoActual().getParticipantes()) {
					if (parti.getNombre().equals(encargado)) {
						acargo = parti;
					}

				}
			}
			});
		comboBox.setBounds(84, 251, 137, 22);
		contentPane.add(comboBox);
		String cambiosfecha[]= {txtDejarEnBlanco.getText(),textField.getText()};
		boolean cmb1 = (!cambiosfecha[0].equals("Dejar en blanco si no realizara cambios") && !cambiosfecha[0].equals(""));
		boolean cmb2 = (!cambiosfecha[1].equals("Dejar en blanco si no realizara cambios") && !cambiosfecha[1].equals(""));
		boolean[] seCambiafecha = {cmb1, cmb2};
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(84, 387, 111, 14);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(encargado!=null) {
					Actividad actividadAModificar = app.darProyectoActual().getActividades().get(aModificar).get(0);
					app.ejecutarModificarActividad(actividadAModificar, cambiosfecha, seCambiafecha,acargo);
					setVisible(false);
					app.VisibleMenuAct(true);
					JOptionPane.showMessageDialog(contentPane,"La actividad se modifico con éxito. El encargado es: "+encargado);
					}
				else {
					JOptionPane.showMessageDialog(contentPane,"Por favor elija un encargado");
				}
				
				
			}
			});
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ModificarActividad.class.getResource("/Graficos/enviar-mensaje.png")));
		lblNewLabel_2.setBounds(221, -20, 315, 564);
		contentPane.add(lblNewLabel_2);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				app.VisibleMenuAct(true);
			}
		});
	}
	
	public void setNombreActividad(String param) {
		aModificar = param;
	}
	
}
