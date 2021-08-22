package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Formula.Ventana_gestion_usuarios;

public class SQLUsuarios extends ConexionMySQL {
	String Usu;
	String Clave;
	
	public TableModel Mostrar() {
		Ventana_gestion_usuarios vgp = new Ventana_gestion_usuarios();
		
		Connection con = getConnection();
		String sql = "SELECT * FROM ventana_registro";
		Statement st;
		DefaultTableModel model = new DefaultTableModel();
			
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Apellido");
			model.addColumn("Nombre de usuario");
			model.addColumn("Telefono");
			model.addColumn("Email");
			model.addColumn("Contraseña");
			model.addColumn("Confirmacion");
			
			vgp.getTable().setModel(model);
			
			String[] Dato = new String[7];
			
			try {
				st = con.createStatement();
				ResultSet result = st.executeQuery(sql);
			    
				while (result.next()) {
					
					Dato[0] = result.getString(1);
					Dato[1] = result.getString(2);
					Dato[2] = result.getString(3);
					Dato[3] = result.getString(4);
					Dato[4] = result.getString(5);
					Dato[5] = result.getString(6);
					Dato[6] = result.getString(7);
					Dato[7] = result.getString(8);
					model.addRow(Dato);
					
				}
				}catch (SQLException e1) {
				e1.printStackTrace();
		     }
			return model;	
	}
	
	public void Confirma(Usuarios usr) {
		PreparedStatement ps;
		Connection con = getConnection();
		
		String sql = "SELECT * FROM ventana_registro WHERE 'Nombre de usuario' = '"+ Usu +"' AND 'Contraseña' ='"+ Clave +"' ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usr.getNombre_Usuario());
			ps.setString(2, usr.getContraseña());
			ps.execute();
			ps.close();
			return;
			
		} catch(Exception ef) {
			System.out.println(ef);
			return;
			}
	}

	public void Registrar(Usuarios usr1) {
		PreparedStatement ps1 = null;
		Connection con1 = getConnection();
		
		String sqgl = "INSERT INTO ventana_registro (idventana_registro, Nombre, Apellido, 'Nombre de usuario', Telefono, Correo electronico,  Contraseña, Confirmacion contraseña) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			ps1 = con1.prepareStatement(sqgl);
			ps1.setInt(1, usr1.getIdVentana_Registro());
			ps1.setString(2, usr1.getNombre());
			ps1.setString(3, usr1.getApellido());
			ps1.setString(4, usr1.getNombre_Usuario());
			ps1.setString(5, usr1.getTelefono());
			ps1.setString(6, usr1.getCorreo_electronico());
			ps1.setString(7, usr1.getContraseña());
			ps1.setString(8, usr1.getConfirmacio_contraseña());
			ps1.executeUpdate();
			ps1.close();
			return;
			
		} catch(Exception ef) {
			System.out.println(ef);
			return;
			}
		}
		public boolean Actualizar(Usuarios usr2) {
			PreparedStatement ps2 = null;
			Connection con2 = getConnection();
		
		String sqhl = "UPADTE ventana_registro (Nombre, Apellido, 'Nombre de usuario', Telefono, Correo electronico,  Contraseña, Confirmacion contraseña) "
				+ "SET(?,?,?,?,?,?,?)";
		try {
			ps2 = con2.prepareStatement(sqhl);
			ps2.setString(1, usr2.getNombre());
			ps2.setString(2, usr2.getApellido());
			ps2.setString(3, usr2.getNombre_Usuario());
			ps2.setString(4, usr2.getTelefono());
			ps2.setString(5, usr2.getCorreo_electronico());
			ps2.setString(6, usr2.getContraseña());
			ps2.setString(7, usr2.getConfirmacio_contraseña());
			ps2.executeUpdate();
			return true;
			
		} catch(Exception ex) {
			System.out.println(ex);
			return false;
		  }
		}
		
        public boolean Eliminar(Usuarios usr3) {
			PreparedStatement ps3 = null;
			Connection con3 = getConnection();
			
		String sql = "DELETE FROM ventana_registro WHERE Nombre ="+ usr3.getNombre_Usuario();
		try {
		    ps3 = con3.prepareStatement(sql);
			ps3.setString(1, usr3.getNombre());
			ps3.setString(2, usr3.getApellido());
			ps3.setString(3, usr3.getNombre_Usuario());
			ps3.setString(4, usr3.getTelefono());
			ps3.setString(5, usr3.getCorreo_electronico());
			ps3.setString(6, usr3.getContraseña());
			ps3.setString(7, usr3.getConfirmacio_contraseña());
			ps3.execute();
			return true;
			
		} catch(Exception exc) {
			System.out.println(exc);
			return false;
		  }
       } 
}