/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import Conexion1.Conexion1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lolit
 */
public class eliminarCliente {
    
     public static void main (String[] args){
     // Crear una instancia de la conexión a la base de datos
     Conexion1 con=new Conexion1();
    Connection cn;
    Statement st;
    ResultSet rs;
    //dato a eliminar 
    

     int id_eliminarCliente=1;
     
        // Consulta SQL para eliminar un cliente de la tabla Cliente
     
     String sql= "DELETE fROM Cliente where id="+id_eliminarCliente;
     
     try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(eliminarCliente.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
         // Establecer conexión con la base de datos
    cn=con.getConection();
    st=cn.createStatement();
     // Ejecutar la consulta de eliminación
    st.executeUpdate(sql);
    
      // Recuperar todos los registros restantes de la tabla Cliente
    rs=st.executeQuery("SELECT * FROM Cliente ");
    rs.next();
    
    // Mostrar los datos de la tabla Cliente en la consola
    do{
    System.out.println(rs.getInt("ID_Cliente")+":"+rs.getString("Nombre")+"-"+rs.getString("Apellido")+rs.getString("Correo_electronico")+rs.getString("Teléfono"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(eliminarCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
    
   
    
