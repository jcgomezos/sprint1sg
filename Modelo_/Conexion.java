
package Modelo_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion extends Exception{
    
    private final String base = "charliefruver";
    private final String user = "postgres"; //"root"
    private final String password = "Juanito7575";//"Juanito7575"
    private final String url = "jdbc:postgresql://localhost:5432/" + base; //"jdbc:mysql://localhost:3306/"
    private Connection con = null;
    
    public Connection getConexion(){
        
        
        try{
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
        }catch(SQLException e){
        System.err.println(e);
        }
        return con;
        }   
    
}
