package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Formula.Ventana_gestion_productos;

public class SQLProductos extends ConexionMySQL {
	
	public TableModel Mostrar() {
		Ventana_gestion_productos vgp = new Ventana_gestion_productos();
		Connection con = getConnection();
		String sql = "SELECT * FROM ventana_emergente";
		Statement st;
		DefaultTableModel model = new DefaultTableModel();
			
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Marca");
			model.addColumn("Categoria");
			model.addColumn("Precio");
			model.addColumn("Cantidad");
			
			vgp.getTable().setModel(model);
			
			String[] Dato = new String[5];
			
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
					model.addRow(Dato);
					
				}
				}catch (SQLException e1) {
				e1.printStackTrace();
		     }
			return model;	
	}
	
	public void Registrar(Productos prs) {
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sqgl = "INSERT INTO ventana_emergente (idventana_emergente, Nombre, Marca, Categoria, Precio, Cantidad) VALUES(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sqgl);
			ps.setInt(1, prs.getIdventana_registro());
			ps.setString(2, prs.getNombre());
			ps.setString(3, prs.getMarca());
			ps.setString(4, prs.getCategoria());
			ps.setInt(5, prs.getPrecio());
			ps.setInt(6, prs.getCantidad());
			ps.executeUpdate();
			con.close();
			return;
			
		} catch(Exception ef) {
			System.out.println(ef);
			return;
			}
		}
		public void Actualizar(Productos prs2) {
			PreparedStatement ps2 = null;
			Connection con2 = getConnection();
		
		String sqhl = "UPADTE ventana_emergente (idventana_emergente, Nombre, Marca, Categoria, Precio, Cantidad,) SET(?,?,?,?,?,?)";
		try {
			ps2 = con2.prepareStatement(sqhl);
			ps2.setInt(1, prs2.getIdventana_registro());
			ps2.setString(2, prs2.getNombre());
			ps2.setString(3, prs2.getMarca());
			ps2.setString(4, prs2.getCategoria());
			ps2.setInt(5, prs2.getPrecio());
			ps2.setInt(6, prs2.getCantidad());
			ps2.executeUpdate();
			con2.close();
			return;
			
		} catch(Exception ex) {
			System.out.println(ex);
			return;
		  }
		}
		
        public Connection Eliminar(Productos prs3) {
			PreparedStatement ps3 = null;
			Connection con3 = getConnection();
			
		String sql = "DELETE FROM ventana_emergente WHERE Nombre ="+ prs3.getNombre();
		try {
			
		    ps3 = con3.prepareStatement(sql);
			ps3.execute();
			con3.close();
			return con3;
			
		} catch(Exception exc) {
			System.out.println(exc);
			return con3;
		  }
       } 
}
