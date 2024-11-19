/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empleado;
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
public class eliminarEmpleado{
    
     public static void main (String[] args){
    // Crear una instancia de la conexión a la base de datos
    Conexion1 con=new Conexion1();
    Connection cn;
    Statement st;
    ResultSet rs;
    //dato a eliminar 
     int id_eliminarEmpleado=1;
     
        // Consulta SQL para eliminar un cliente de la tabla Empleado
     String sql= "DELETE fROM Empleado where id="+id_eliminarEmpleado;
     
     try{
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(eliminarEmpleado.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
         // Establecer conexión con la base de datos
    cn=con.getConection();
    st=cn.createStatement();
     // Ejecutar la consulta de eliminación
    st.executeUpdate(sql);
    
      // Recuperar todos los registros restantes de la tabla Empleado
    rs=st.executeQuery("SELECT * FROM Empleado ");
    rs.next();
// Mostrar los datos de la tabla Cliente en la consola
    do{
    System.out.println(rs.getInt("ID_Empleado")+":"+rs.getString("Nombre")+"-"+rs.getString("Apellido")+rs.getString("Correo_electronico")+rs.getString("Teléfono"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(eliminarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
    
   
    
