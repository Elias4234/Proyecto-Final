package Formula;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Proyecto.ConexionMySQL;

public class Ventana_Eliminacion extends JFrame {
	ConexionMySQL cc = new ConexionMySQL();
	Connection con = cc.ConectarBasedeDatos();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Eliminacion frame = new Ventana_Eliminacion();
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
	public Ventana_Eliminacion() {
		setTitle("Formulario de Dawn Company");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 204);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 11, 101, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de usuario");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(25, 69, 134, 14);
		contentPane.add(lblNewLabel_3);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(222, 66, 146, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarEliminacion();
				
			}
			public void validarEliminacion(){
            	int Resul;
            	PreparedStatement ps3 = null;
    			Connection con3 = cc.getConnection();
    			
    		       String sql = "DELETE FROM ventana_emergente WHERE Nombre ="+ txtUsuario.getText();
    		       try {Resul = 1;
    		    	   if(Resul == 1){
    		           ps3 = con3.prepareStatement(sql);
    			       ps3.execute();
    			       
    			       JOptionPane.showMessageDialog(null, "Eliminacion del registro exitosa ", "EXITO",
								JOptionPane.INFORMATION_MESSAGE);
    			       
    			       dispose();
    					Ventana_gestion_usuarios Vgu = new Ventana_gestion_usuarios();
    					Vgu.setVisible(true);
				       
				       
    		    	   }else{
						JOptionPane.showMessageDialog(null, " Error de eliminacion ", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
					} 
    			   
    		       } catch(Exception exc) {
    		    	   JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
    			   }
            }	 
			
		});
		btnNewButton.setBounds(42, 112, 134, 32);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(222, 112, 128, 32);
		contentPane.add(btnNewButton_1);
	}

	protected int IntegerparseInt(String text) {
		// TODO Auto-generated method stub
		return 0;
	}
}
