package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Usuario;

public class GestorBD {
	// Registro del driver apropiado para la BD a utilizar
	static {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("No puedo cargar el driver JDBC de la BD");
		}
	}
	
	public Usuario getUsuario(String id){
		Usuario usu = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/franc/Desktop/BaseDeDatosReproductor.accdb");
			String sql = "SELECT U.* FROM Usuarios U WHERE idUsuario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				usu = new Usuario(id, 
						res.getString(2),
						res.getString(3), 
						res.getString(4),
						res.getString(5),
						res.getString(6));
			}
			res.close();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
		return usu;
	}
	
	public boolean existeUsuario(String id, String contrasena){
		Usuario usu = new Usuario();
		usu = getUsuario(id);
		if(usu.getContraseña().equals(contrasena)){
			return true;
		}
		return false;
	}
	
	
	public void aniadirUsuario(Usuario arg0){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/franc/Desktop/BaseDeDatosReproductor.accdb");
			String sql = "INSERT INTO Usuarios VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			if(getUsuario(arg0.getNombreUsuario()) == null){
				pstm.setString(1, arg0.getNombreUsuario());
				pstm.setString(2, arg0.getContraseña());
				pstm.setString(3, arg0.getNombre());
				pstm.setString(4, arg0.getApellidos());
				pstm.setString(5, arg0.getEmail());
				pstm.setString(6, arg0.isConectado());
				pstm.executeUpdate();
				pstm.close();	
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		}
	}
	//SELECT F.*, P.* FROM Finca F INNER JOIN Propietario P ON F.propietario = P.id_propietario WHERE F.id_finca ='" + id + "'"
	
	public static void main(String []args){
		GestorBD gb = new GestorBD();
//		GestorBD gb2 = new GestorBD();
//		System.out.println(gb.getUsuario("2").toString());
//		Usuario usu1 = new Usuario("francosk8er71", "12345", "Franco", "Tiravantti", "francosk8er71@gmail.com", "si");
//		Usuario usu2 = new Usuario("usuario2", "12345", "Usu1", "Apellido1", "usu1@gmail.com", "si");
//		Usuario usu3 = new Usuario("usuario3", "12345", "Usu2", "Apellido2", "usu2@gmail.com", "si");
//		gb2.aniadirUsuario(usu1);
		
		if(gb.existeUsuario("francosk8er71", "12345")){
			System.out.println("siiiiiiiiiiiiiiiii");
		}
		
		
		//gb.aniadirUsuario(usu2);
		//gb.aniadirUsuario(usu3);
//		System.out.println(gb.getUsuario("francosk8er71").toString());
//		System.out.println(gb.getUsuario("1").toString());
//		System.out.println(gb.getUsuario("2").toString());
//		System.out.println(gb.getUsuario("2").toString());
//		System.out.println(gb.getUsuario("gafag").toString());
	}

}
