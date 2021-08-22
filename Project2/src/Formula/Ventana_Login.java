package Formula;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Proyecto.ConexionMySQL;

public class Ventana_Login extends JFrame {
	ConexionMySQL cc = new ConexionMySQL();
	Connection con = cc.ConectarBasedeDatos();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Login frame = new Ventana_Login();
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
	public Ventana_Login() {
		setTitle("Formulario de Dawn Company");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 296);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(233, 23, 82, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(85, 82, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(85, 123, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		setPasswordField(new JPasswordField());
		getPasswordField().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			}
		});
		getPasswordField().setBounds(196, 121, 142, 20);
		contentPane.add(getPasswordField());
		
		setTextField(new JTextField());
		getTextField().setBounds(196, 80, 142, 20);
		contentPane.add(getTextField());
		getTextField().setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				validarUsuario();
			}
			
            public void validarUsuario() {
            	
            	int Resultado = 0;
				char[] Pass = passwordField.getPassword();
				String Clave = new String(Pass);
				String Usu = textField.getText();
				
				String sql = "SELECT * FROM ventana_registro WHERE 'Nombre de usuario' = '"+ Usu +"' AND 'Contraseña' ='"+ Clave +"' ";
				
				try {
					Statement ps = con.createStatement();
					ResultSet rs = ps.executeQuery(sql);
					
					if((rs.next()) && Usu.equals(Clave)) {
						
						Resultado = Resultado + 1;
						
						if(Resultado == 1) {
							
							dispose();
							JOptionPane.showConfirmDialog(null, "Bienvenido al Sistema", "INGRESASTE",
									JOptionPane.INFORMATION_MESSAGE);
							Ventana_Principal Vp = new Ventana_Principal();
							Vp.setVisible(true);
						
						}else {
							JOptionPane.showConfirmDialog(null, "Usuario o Contraseña son incorrectos", "ERROR",
									JOptionPane.INFORMATION_MESSAGE);
							
							getTextField().setText("");
							getPasswordField().setText("");
							getTextField().requestFocus();
						}
						
					}else {
						JOptionPane.showConfirmDialog(null, "Error de acceso usuario:'" + Usu  + "' no registrado", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
						
						getTextField().setText("");
						getPasswordField().setText("");
						getTextField().requestFocus();
					}
						
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, " Error desconocido ", e.getMessage(), 
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				}
			
		});
				
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(196, 179, 142, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_Registro VR = new Ventana_Registro();
				VR.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(377, 48, 136, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Dawn Company");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 11, 142, 23);
		contentPane.add(lblNewLabel_3);
        }
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
