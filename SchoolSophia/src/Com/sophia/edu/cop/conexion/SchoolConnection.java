package Com.sophia.edu.cop.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Silfredo
 */
public class SchoolConnection {

    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/colegio";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    
    public Connection getConnection(){
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            return connection;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SchoolConnection sc = new SchoolConnection();
        if(sc.getConnection() == null){
            System.out.println("Error al conectarse a la base de datos");
        }else
            System.out.println("Conexion exitosa.");
    }

}
