package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String controlador = "com.mysql.cj.jdbc.Driver"; 
	private static final String url = "jdbc:mysql://localhost:3306/books"; 
	private static final String usuario = "root"; 
	private static final String password = "Beyblade_1990"; 
	
	static {
		try {
			Class.forName(controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public Connection conectarBD() {
		Connection conexion = null;
		try {
			
			conexion = DriverManager.getConnection(url,usuario, password);
			System.out.println("Conexion creada correctamente");
			
		} catch (SQLException e) {
			
		System.out.println("Error en la conexion");
		e.printStackTrace();
		
		}
		
		return conexion;
	}


}
