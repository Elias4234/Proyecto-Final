package Formula;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Proyecto.ConexionMySQL;
import Proyecto.SQLUsuarios;

public class Ventana_gestion_usuarios extends JFrame {
	ConexionMySQL cc = new ConexionMySQL();
	Connection con = cc.ConectarBasedeDatos();
	SQLUsuarios SU = new SQLUsuarios();
	public void limpiarTabla() {
		DefaultTableModel model = new DefaultTableModel();
		for(int i = 0; i <= table.getRowCount(); i++ ) {
			model.removeRow(i);
			i = i - 1;
		}
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_gestion_usuarios frame = new Ventana_gestion_usuarios();
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
	public Ventana_gestion_usuarios() {
		setTitle("Formulario de Dawn Company");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 397);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes Registrados");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(235, 36, 191, 24);
		contentPane.add(lblNewLabel);
		
		setTable(table = new JTable());
		getTable().setBounds(27, 268, 627, -193);
		contentPane.add(getTable());
		SU.Mostrar();
		
		JButton Nuevo = new JButton("Nuevo");
		Nuevo.setBackground(Color.GREEN);
		Nuevo.setFont(new Font("Arial", Font.BOLD, 16));
		Nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana_Regist VR1 = new Ventana_Regist();
				VR1.setVisible(true);
				SU.Mostrar();
			}
		});
		Nuevo.setBounds(37, 296, 130, 42);
		contentPane.add(Nuevo);
		
		JButton Actualizar = new JButton("Actualizar");
		Actualizar.setBackground(Color.YELLOW);
		Actualizar.setFont(new Font("Arial", Font.BOLD, 16));
		Actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana_Actualizacion frame = new Ventana_Actualizacion();
				frame.setVisible(true);
				limpiarTabla();
				SU.Mostrar();
			}
		});
		Actualizar.setBounds(194, 296, 130, 42);
		contentPane.add(Actualizar);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.setBackground(Color.YELLOW);
		Eliminar.setFont(new Font("Arial", Font.BOLD, 16));
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana_Eliminacion frame = new Ventana_Eliminacion();
				frame.setVisible(true);
				limpiarTabla();
				SU.Mostrar();
			}
		});
		Eliminar.setBounds(350, 296, 130, 42);
		contentPane.add(Eliminar);
		
		JButton Cerrar_sesion = new JButton("Atras");
		Cerrar_sesion.setBackground(Color.WHITE);
		Cerrar_sesion.setFont(new Font("Arial", Font.BOLD, 16));
		Cerrar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_Principal VP = new Ventana_Principal();
				VP.setVisible(true);
				
			}
		});
		Cerrar_sesion.setBounds(506, 296, 133, 42);
		contentPane.add(Cerrar_sesion);
		
		lblNewLabel_6 = new JLabel("Dawn Company");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(10, 11, 147, 24);
		contentPane.add(lblNewLabel_6);
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
}
