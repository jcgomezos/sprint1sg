
package Modelo_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Consultascharlie extends Conexion{
    
    public boolean registrar(ProductoC pro){
        
        PreparedStatement ps = null;
        Connection con =  getConexion();
        
        String sql = "INSERT INTO compras (codigo, nombre, precio, cantidad) VALUES(?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
    
    public boolean modificar(ProductoC pro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE compras SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=? ";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(ProductoC pro){
        
        PreparedStatement ps = null;
        Connection con =  getConexion();
        
        String sql = "DELETE FROM compras WHERE id=? ";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
    
    public boolean buscar(ProductoC pro) /*throws IOException*/{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con =  getConexion();
        
        String sql = "SELECT * FROM compras WHERE codigo=? ";
        
        //FileWriter fw = null;
        //PrintWriter pw=null;
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs= ps.executeQuery(); //para que me regrese el resultado usamos ExecuteQuery
            
            //rs.next nos trae los resultados en caso de ser mas de una fila usar un while 
            if(rs.next()){
                //al obtener la fila estos valores los agregamos al modelo
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                
                return true;
  
            }  
            
            
            return false;
            
        }catch(SQLException e){
            //fw = new FileWriter ("C:\\Users\\ADMIN\\Desktop\\excepciones\\manejoexcp.txt", true);
            //pw = new PrintWriter (fw);
            //pw.println("No se puede registrar el producto");
            //e.printStackTrace (pw);
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
            //fw.close();
         
            
        }
        
    }
    //faltan las consultas para la tabla cliente
    
    
    public boolean registrarP(Cliente c) /*throws IOException*/{
        
        PreparedStatement ps = null;
        Connection con =  getConexion();
        
        //FileWriter fw = null;
        //PrintWriter pw=null;
        
        String sql = "INSERT INTO cliente ( nombre, celular, direccion) VALUES(?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCelular());
            ps.setString(3, c.getDireccion());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            //fw = new FileWriter ("C:\\Users\\ADMIN\\Desktop\\excepciones\\manejoexcp.txt", true);
            //pw = new PrintWriter (fw);
            //pw.println("No se puede registrar el producto");
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
    
    public boolean modificarP(Cliente c){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE cliente SET nombre=?, celular=?, direccion=? WHERE id=? ";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCelular());
            ps.setString(3, c.getDireccion());
            ps.setInt(4, c.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarC(Cliente c){
        
        PreparedStatement ps = null;
        Connection con =  getConexion();
        
        String sql = "DELETE FROM cliente WHERE id=? ";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
    
    public boolean buscarC(Cliente c){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con =  getConexion();
        
        String sql = "SELECT * FROM cliente WHERE celular=? "; //"SELECT * FROM cliente WHERE nombre=? "
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, c.getCelular()); //ps.setString(1, c.getNombre());
            rs= ps.executeQuery(); //para que me regrese el resultado usamos ExecuteQuery
            
            //rs.next nos trae los resultados en caso de ser mas de una fila usar un while 
            if(rs.next()){
                //al obtener la fila estos valores los agregamos al modelo
                c.setId(Integer.parseInt(rs.getString("id")));
                c.setNombre(rs.getString("nombre"));
                c.setCelular(Integer.parseInt(rs.getString("celular")));//(rs.getInt("celular"));
                c.setDireccion(rs.getString("direccion"));
                
                
                return true;
  
            }  
            
            
            return false;
            
        }catch(SQLException e){
            
            System.err.println(e);
            return false;
            
        }finally{
            
            try{
                con.close();
            }catch(SQLException e){
                
                System.err.println(e);
            }
        }
    }
    
}
