package ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class testConexion {
public static void main(String[] args) {
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	try {
		cn = conexion.conectarBD(); 
		stm = cn.createStatement();
		rs = stm.executeQuery("SELECT * FROM LIBRO");
		
		while(rs.next()) {
			int idLibro = rs.getInt(1);
			String nLibro = rs.getString(2);
			String desLibro = rs.getString(3);
			System.out.println(idLibro + "-" + nLibro + "-" + desLibro);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stm != null) {
				stm.close();
			}
			if(cn!=null) {
				cn.close();
			}
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
}
}
