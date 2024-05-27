package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rikid
 */
public class Conexion {
    
    
    public static Connection conectar() {
        try
        {
            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/macrosleaf", "root", "123456");
          
            return cn;
            
        } catch (SQLException e)
        {
            System.err.println("Error en la conexión local " + e);
        }
        return null;
    }
    
 
    
    
}
