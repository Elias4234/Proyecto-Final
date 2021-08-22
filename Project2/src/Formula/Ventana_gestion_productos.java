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
import Proyecto.SQLProductos;

public class Ventana_gestion_productos extends JFrame {
	public void limpiarTabla() {
		DefaultTableModel model = new DefaultTableModel();
		for(int i = 0; i <= table.getRowCount(); i++ ) {
			model.removeRow(i);
			i = i -1;
		}
	}
	ConexionMySQL cc = new ConexionMySQL();
	Connection con = cc.ConectarBasedeDatos();
	static SQLProductos SP = new SQLProductos();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Productos de Almacen");
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_gestion_productos frame = new Ventana_gestion_productos();
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
	public Ventana_gestion_productos() {
		setTitle("Formulario de Dawn Company");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel.setBounds(220, 27, 204, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dawn Company");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 166, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton NuevoZ = new JButton("Nuevo");
		NuevoZ.setBackground(Color.YELLOW);
		NuevoZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_Emergente VE = new Ventana_Emergente();
				VE.setVisible(true);
				SP.Mostrar();
			}
		});
		NuevoZ.setFont(new Font("Arial", Font.BOLD, 18));
		NuevoZ.setBounds(33, 290, 155, 37);
		contentPane.add(NuevoZ);
		
		JButton AtrasZ = new JButton("Atras");
		AtrasZ.setBackground(Color.WHITE);
		AtrasZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_Principal VP = new Ventana_Principal();
				VP.setVisible(true);
		
			}
		});
		AtrasZ.setFont(new Font("Arial", Font.BOLD, 18));
		AtrasZ.setBounds(447, 290, 144, 37);
		contentPane.add(AtrasZ);
		
		setTable(new JTable());
		getTable().setBounds(10, 71, 607, 195);
		contentPane.add(getTable());
		SP.Mostrar();
		
		JButton AEZ = new JButton("Actualizar o Eliminar");
		AEZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_actulizacion_eliminacion frame = new Ventana_actulizacion_eliminacion();
				frame.setVisible(true);
				limpiarTabla();
				SP.Mostrar();
			}
		});
		AEZ.setBackground(Color.CYAN);
		AEZ.setFont(new Font("Arial", Font.BOLD, 16));
		AEZ.setBounds(220, 290, 190, 37);
		contentPane.add(AEZ);
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
}	

