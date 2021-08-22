package Formula;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Proyecto.SQLUsuarios;
import Proyecto.Usuarios;

public class Ventana_Actualizacion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField Contrasena;
	private JPasswordField Confirmacion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Actualizacion frame = new Ventana_Actualizacion();
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
	public Ventana_Actualizacion() {
		setTitle("Formulario de Dawn Company");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 522);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizar");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 11, 101, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 111, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(23, 154, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de usuario");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(23, 197, 134, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(23, 331, 92, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(221, 108, 146, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(221, 151, 146, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(221, 194, 146, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Confirmacion de contrase\u00F1a");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(23, 374, 184, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarActualizar();
				
			}
				 public void validarActualizar(){
						
						SQLUsuarios modSql = new SQLUsuarios();
						Usuarios usr1 = new Usuarios();
						
						String pass = new String(Contrasena.getPassword());
						String passCon = new String(Confirmacion.getPassword());
						if(pass.equals(passCon)){
								 modSql.Registrar(usr1); 
								 usr1.setIdventana_Registro((int) IntegerparseInt(txtId.getText()));
								 usr1.setNombre(txtNombre.getText());
								 usr1.setApellido(txtApellido.getText());
								 usr1.setNombre_Usuario(txtUsuario.getText());
					             usr1.setTelefono(txtTelefono.getText());
					             usr1.setCorreo_electronico(txtCorreo.getText());
								 usr1.setContraseña(pass);
								 usr1.setConfirmacio_contraseña(passCon);
								
								 dispose();
								 JOptionPane.showMessageDialog(null, "Registro guardado y actualizado", "EXITO",
										JOptionPane.INFORMATION_MESSAGE);
								 Ventana_gestion_usuarios Vgu = new Ventana_gestion_usuarios();
								 Vgu.setVisible(true);
							
						 }else {
								JOptionPane.showMessageDialog(null, "Las Contraseñas no coinciden", "ERROR",
										JOptionPane.INFORMATION_MESSAGE);
					   } 
						
			} 
		});
		btnNewButton.setBounds(41, 425, 134, 32);
		contentPane.add(btnNewButton);
		
		Contrasena = new JPasswordField();
		Contrasena.setBounds(221, 328, 146, 20);
		contentPane.add(Contrasena);
		
		Confirmacion = new JPasswordField();
		Confirmacion.setBounds(221, 371, 146, 20);
		contentPane.add(Confirmacion);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(23, 243, 92, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Correo electronico");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_7.setBounds(23, 288, 128, 14);
		contentPane.add(lblNewLabel_7);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(221, 240, 146, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(221, 285, 146, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(221, 66, 146, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("ID");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(23, 69, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_gestion_usuarios Vgu = new Ventana_gestion_usuarios();
				Vgu.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(221, 426, 128, 31);
		contentPane.add(btnNewButton_1);
	}

	protected int IntegerparseInt(String text) {
		// TODO Auto-generated method stub
		return 0;
	}

}
