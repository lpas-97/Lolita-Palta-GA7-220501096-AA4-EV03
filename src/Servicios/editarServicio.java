/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

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

public class editarServicio {
    
     public static void main (String[] args){
    // Crear una instancia de la conexión a la base de datos
    Conexion1 con=new Conexion1();
    Connection cn;
    Statement st;
    ResultSet rs;
    
     // ID del empleado a editar y los nuevos datos
    int id_editar=1;
    String new_ID_Servicio = "Tour";
    String new_ID_Cliente = "1096";
    String new_Fecha = "26/02/25";
    String new_Hora= "8am";
    String new_Precio = "100000";
    
       // Consulta SQL para actualizar los datos de un servicio
    String sql = "UPDATE Servicios set ID_Servicio='"+new_ID_Servicio+"',ID_Cliente='"+new_ID_Cliente+"',Fecha='"+new_Fecha+"',Hora='"+new_Hora+"',',Precio='"+new_Precio+"''where id="+id_editar;
    try{
        
          // Registrar el driver JDBC
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editarServicio.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
          // Establecer conexión con la base de datos
    cn=con.getConection();
    st=cn.createStatement();
     // Ejecutar la consulta de actualización
    st.executeUpdate(sql);
    
      // Recuperar todos los registros actualizados de la tabla Servicios
    rs=st.executeQuery("SELECT * FROM Servicios");
    rs.next();
    
    // Mostrar los datos de la tabla servicios en la consola
    do{
    System.out.println(rs.getInt("ID_Servicio")+":"+rs.getString("ID_Cliente")+"-"+rs.getString("Fecha")+"-"+rs.getString("Hora")+"-"+rs.getString("Precio"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editarServicio.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
    

