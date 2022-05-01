package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;
import Modelo.Proyecto;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Imagenes img;
	private Aplicacion app;
	private JComboBox proyectos;
	private JButton loginBtn;
	private JButton crearBtn;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(Aplicacion appl) {
		setIconImage(img.BULB);
		app = appl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(img.BULB));
		lblNewLabel.setBounds(371, 0, 347, 420);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escoger proyecto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(45, 134, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(100);
		comboBox.setToolTipText("");
		comboBox.setBounds(168, 131, 125, 22);
		if (app.darProyectos().size() != 0) {
			for (Proyecto proyecto : app.darProyectos()) {
				comboBox.addItem(proyecto.getNombre());
			}
		} else {
			JOptionPane.showMessageDialog(contentPane,"Por favor, cree un proyecto.");			
		}
		comboBox.addActionListener(app);
		proyectos = comboBox;
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(168, 164, 89, 23);
		btnNewButton.addActionListener(app);
		loginBtn = btnNewButton;
		contentPane.add(btnNewButton);
		
		
		JButton btnCrearNuevoProyecto = new JButton("Crear Nuevo Proyecto");
		btnCrearNuevoProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearNuevoProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearNuevoProyecto.setBounds(59, 224, 181, 22);
		btnCrearNuevoProyecto.addActionListener(app);
		crearBtn = btnCrearNuevoProyecto;
		contentPane.add(btnCrearNuevoProyecto);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenido a Proyect Manager!");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(44, 40, 317, 38);
		contentPane.add(lblNewLabel_2);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try {
					app.persistenciaArchivoGuardar();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public JComboBox getComboBox() {
		return proyectos;		
	}
	
	public JButton getBtnLogin() {
		return loginBtn;
	}
	
	public JButton getBtnCrear() {
		return crearBtn;
	}
	
	public int darIndexProyecto() {
		int proyectoIndex = proyectos.getSelectedIndex();
		return proyectoIndex;						
	}
}
