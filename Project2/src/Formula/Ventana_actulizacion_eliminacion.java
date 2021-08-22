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
import Proyecto.Productos;
import Proyecto.SQLProductos;

public class Ventana_actulizacion_eliminacion extends JFrame {
	ConexionMySQL cc = new ConexionMySQL();
	Connection con = cc.ConectarBasedeDatos();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_actulizacion_eliminacion frame = new Ventana_actulizacion_eliminacion();
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
	public Ventana_actulizacion_eliminacion() {
		setTitle("Formulario de Dawn Company");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de productos");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(70, 11, 227, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*Nombre");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 115, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marca");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(23, 155, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(23, 199, 134, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(192, 112, 134, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(192, 152, 134, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(192, 196, 134, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarActualizacion();
			} 
            public void validarActualizacion(){
				int Resul  = 0;
				
				SQLProductos SQLpro = new SQLProductos();
				Productos pro = new Productos();
				
				if(txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtMarca.getText().isEmpty() || txtCategoria.getText().isEmpty() 
						|| txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty())					
				{ 
					JOptionPane.showMessageDialog(null, "Error falta llenar campos", "ERROR",
						JOptionPane.INFORMATION_MESSAGE);
					
				} else { 
					try{Resul = 1;
					
				   if(Resul == 1){
						 SQLpro.Actualizar(pro); 
						 pro.setidventana_emergente(IntegerParseInt(txtId.getText()));
						 pro.setNombre(txtNombre.getText());
						 pro.setMarca(txtMarca.getText());
						 pro.setCategoria(txtCategoria.getText());
			             pro.setPrecio(IntegerParseInt(txtPrecio.getText()));
			             pro.setCantidad(IntegerParseInt(txtCantidad.getText()));
						
						 dispose();
						 JOptionPane.showMessageDialog(null, "Registro actualizado y guardado", "EXITO",
								JOptionPane.INFORMATION_MESSAGE);
						 Ventana_gestion_productos Vgp = new Ventana_gestion_productos();
						 Vgp.setVisible(true);
					
				    }else {
						JOptionPane.showMessageDialog(null, " Error de validacion ", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
					} 
					
					}catch(Exception ev) {
						JOptionPane.showMessageDialog(null, ev, " Error ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} 
			}
		});
		btnNewButton.setBounds(23, 330, 134, 32);
		contentPane.add(btnNewButton);
				
		JLabel lblNewLabel_6 = new JLabel("Precio");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(23, 239, 92, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cantidad");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_7.setBounds(23, 279, 128, 14);
		contentPane.add(lblNewLabel_7);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(192, 236, 134, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(192, 276, 134, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarEliminacion();
			} 
			public void validarEliminacion(){
            	int Resul;
            	PreparedStatement ps3 = null;
    			Connection con3 = cc.getConnection();
    			
    		       String sql = "DELETE FROM ventana_emergente WHERE Nombre ="+ txtNombre.getText();
    		       try {Resul = 1;
    		    	   if(Resul == 1){
    		           ps3 = con3.prepareStatement(sql);
    			       ps3.execute();
    			       
    			       JOptionPane.showMessageDialog(null, "Eliminacion del registro exitosa ", "EXITO",
								JOptionPane.INFORMATION_MESSAGE);
    			       
    			       dispose();
				       Ventana_gestion_productos Ven = new Ventana_gestion_productos();
				       Ven.setVisible(true);
				       
				       
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
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(192, 330, 128, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel dfd = new JLabel("ID");
		dfd.setFont(new Font("Arial", Font.BOLD, 13));
		dfd.setForeground(Color.WHITE);
		dfd.setBounds(23, 77, 46, 14);
		contentPane.add(dfd);
		
		txtId = new JTextField();
		txtId.setBounds(192, 74, 134, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Cerrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			     Ventana_gestion_productos Vgp = new Ventana_gestion_productos();
			     Vgp.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(107, 381, 123, 34);
		contentPane.add(btnNewButton_2);
	}

	protected int IntegerParseInt(String text) {
		// TODO Auto-generated method stub
		return 0;
	}

}
