package Formula;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Principal frame = new Ventana_Principal();
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
	public Ventana_Principal() {
		setTitle("Formulario de Dawn Company");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 40, 1053, 663);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zona de Trabajo");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(417, 29, 202, 59);
		contentPane.add(lblNewLabel);
		
		JButton UsuariosX = new JButton("Usuarios");
		UsuariosX.setForeground(Color.BLUE);
		UsuariosX.setBackground(Color.GREEN);
		UsuariosX.setFont(new Font("Arial", Font.BOLD, 22));
		UsuariosX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_gestion_usuarios Vgu = new Ventana_gestion_usuarios();
				Vgu.setVisible(true);
				
			}
		});
		UsuariosX.setBounds(148, 541, 215, 46);
		contentPane.add(UsuariosX);
		
		JButton ProductosX = new JButton("Productos");
		ProductosX.setForeground(Color.BLUE);
		ProductosX.setFont(new Font("Arial", Font.BOLD, 22));
		ProductosX.setBackground(Color.CYAN);
		ProductosX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_gestion_productos Vgp = new Ventana_gestion_productos();
				Vgp.setVisible(true);
				
			}
		});
		ProductosX.setBounds(684, 540, 202, 48);
		contentPane.add(ProductosX);
		
		JButton CerrarX = new JButton("Cerrar sesion");
		CerrarX.setFont(new Font("Arial", Font.BOLD, 22));
		CerrarX.setForeground(Color.BLACK);
		CerrarX.setBackground(Color.ORANGE);
		CerrarX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Ventana_Login Vl = new Ventana_Login();
				Vl.setVisible(true);
				
			}
		});
		CerrarX.setBounds(835, 11, 192, 59);
		contentPane.add(CerrarX);
		
		JLabel lblNewLabel_1 = new JLabel("Dawn Company");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setBounds(10, 3, 230, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Project2\\src\\Lib\\change-user-male.png"));
		lblNewLabel_2.setBounds(44, 126, 395, 348);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\Project2\\src\\Lib\\Producto1.jpg"));
		lblNewLabel_3.setBounds(575, 118, 395, 384);
		contentPane.add(lblNewLabel_3);
	}
}
