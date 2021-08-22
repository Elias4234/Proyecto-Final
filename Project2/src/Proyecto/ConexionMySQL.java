package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionMySQL {

	public Connection conexion = null;
	public Statement sentencia;
	public ResultSet resultado;
	
	public Connection ConectarBasedeDatos() {
		try {
			final String Controlador = "com.mysql.jdbc.Driver";
			Class.forName(Controlador);
			final String url_bd = "jdbc:mysql://localhost:3306/basedatos_tarea4";
			conexion = DriverManager.getConnection(url_bd, "root", "123456");
			sentencia = conexion.createStatement();
			if (conexion != null) {
			JOptionPane.showMessageDialog(null, "La conexion ha sido exitosa", "EXITO", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (ClassNotFoundException | SQLException exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return conexion;
	}

	public Connection DesconectarBasedeDatos() {
		try {
			if (conexion != null) {
				if (sentencia != null) {
					sentencia.close();
				}
				conexion.close();
				JOptionPane.showMessageDialog(null, "La desconexion ha sido exitosa", "EXITO", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException exs) {
			JOptionPane.showMessageDialog(null, exs.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return conexion;
	}

	public Connection getConnection() {
		return conexion;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

