package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Graficos.Imagenes;
import java.awt.SystemColor;

public class CrearProyecto extends JFrame {

	private JPanel contentPane;
	private JTextField txtS;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtCamila;
	private JTextField txtExamplegmailcom;
	private JTextField textField_5;
	private Imagenes img;
	private JFrame presente; 

	/**
	 * Launch the application.
	 */ /*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProyecto frame = new CrearProyecto();
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
	 * @param menuProyecto 
	 * @param aplicacion 
	 */
	public CrearProyecto(Aplicacion aplicacion) {
		setIconImage(img.BULB);
		presente = new JFrame();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 824, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Proyecto: ");
		lblNewLabel.setBounds(76, 75, 104, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		
		txtS = new JTextField();
		txtS.setText("Proyecto1");
		txtS.setForeground(new Color(119, 136, 153));
		txtS.setBounds(180, 75, 180, 20);
		panel.add(txtS);
		txtS.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(106, 106, 104, 14);
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblDescripcin);
		
		/*
		textField = new JTextField();
		textField.setBounds(180, 131, 118, 20);
		textField.setColumns(10);
		panel.add(textField);
		*/
		
		textField = new JFormattedTextField();
		textField.setForeground(new Color(112, 128, 144));
		//sacar la fecha
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime date = LocalDateTime.now();
		String fechaI = LocalDateTime.now().format(formatter);
		textField.setText(fechaI);
		textField.setBounds(180, 131, 180, 20);
		textField.setColumns(10);
		panel.add(textField);
		
		
		
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(112, 128, 144));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setBounds(180, 103, 180, 20); //descripcion
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(106, 134, 104, 14);
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaFin.setBounds(106, 162, 104, 14);
		panel.add(lblFechaFin);
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 159, 180, 20);
		panel.add(textField_2);
		
		/*
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(180, 187, 118, 20);
		panel.add(textField_5);
		*/
		
		
		
		textField_5 = new JFormattedTextField();
		textField_5.setForeground(new Color(105, 105, 105));
		textField_5.setBounds(180, 187, 180, 20);
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		String initialText = "ej:diseño,codigo,pruebas";
		textField_5.setText(initialText);
		
		textField_5.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		       if (textField_5.getText().equals(initialText)) {
		          textField_5.selectAll();
		       }
		    }
		});
		
		JLabel tiposProyecto = new JLabel("Tipos actividades:");
		tiposProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiposProyecto.setBounds(70, 190, 147, 14);
		panel.add(tiposProyecto);
		
	
		
		JLabel lblNombreAdminProyecto = new JLabel("Nombre admin:");
		lblNombreAdminProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreAdminProyecto.setBounds(93, 253, 147, 14);
		panel.add(lblNombreAdminProyecto);
		
		JLabel lblCorreoAdmin = new JLabel("Correo admin:");
		lblCorreoAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreoAdmin.setBounds(93, 281, 147, 14);
		panel.add(lblCorreoAdmin);
		
		txtCamila = new JTextField();
		txtCamila.setForeground(new Color(128, 128, 128));
		txtCamila.setText("camila");
		txtCamila.setColumns(10);
		txtCamila.setBounds(180, 250, 180, 20);
		panel.add(txtCamila);
		
		txtExamplegmailcom = new JTextField();
		txtExamplegmailcom.setText("example@gmail.com");
		txtExamplegmailcom.setForeground(new Color(119, 136, 153));
		txtExamplegmailcom.setColumns(10);
		txtExamplegmailcom.setBounds(180, 278, 180, 20);
		panel.add(txtExamplegmailcom);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\OneDrive - Universidad de los Andes\\Documentos\\3er Semestre\\DPOO\\Proy 1\\Proyecto_DPOO\\Proyecto 2\\Entrega 2\\src\\Graficos\\3380841.png"));
		lblNewLabel_1.setIcon(new ImageIcon(CrearProyecto.class.getResource("/Graficos/3380841.png")));
		lblNewLabel_1.setBounds(380, 0, 408, 466);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Crear Proyecto");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || txtCamila.getText().equals("") || txtExamplegmailcom.getText().equals("") || txtS.getText().equals("") || textField_5.getText().equals("ej:diseño,codigo,pruebas")) {
					JOptionPane.showMessageDialog(presente,"Hay una o mas casillas que siguen en blanco. Complete todas, por favor.");
				}
				else {
				String nombreProyecto = txtS.getText();
				String descripcionProyecto = textField_1.getText();
				String fechaIProyecto = textField.getText();
				String fechaFProyecto = textField_2.getText();
				String nombreAdmin = txtCamila.getText();
				String correoAdmin = txtExamplegmailcom.getText();
				String tiposProyecto = textField_5.getText();				
				
				
				
				
				setVisible(false);
				aplicacion.crearProyecto(nombreProyecto, descripcionProyecto, fechaIProyecto, fechaFProyecto, nombreAdmin, correoAdmin, tiposProyecto);
				aplicacion.actualizarProyActual();
				aplicacion.setMenuProyecto();
				aplicacion.darMenuProyecto().setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 245, 238));
		btnNewButton.setBounds(180, 309, 156, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Regresar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(31, 360, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				aplicacion.VisiblePrincipal(true);
				setVisible(false);
			}
			});
		panel.add(btnNewButton_1);
		
		JFormattedTextField textField_5_1 = new JFormattedTextField();
		textField_5_1.setText("ej:dise\u00F1o,codigo,pruebas");
		textField_5_1.setForeground(SystemColor.controlDkShadow);
		textField_5_1.setColumns(10);
		textField_5_1.setBounds(180, 218, 180, 24);
		panel.add(textField_5_1);
		
		JLabel lblTiposTareas = new JLabel("Tipos tareas:");
		lblTiposTareas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiposTareas.setBounds(93, 223, 147, 14);
		panel.add(lblTiposTareas);
	}
}
