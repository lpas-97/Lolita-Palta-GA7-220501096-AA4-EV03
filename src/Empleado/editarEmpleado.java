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

public class editarEmpleado {
    
     public static void main (String[] args){
     // Crear una instancia de la conexión a la base de datos
     Conexion1 con=new Conexion1();
    Connection cn;
    Statement st;
    ResultSet rs;
    
     // ID del empleado a editar y los nuevos datos
    int id_editar=1;
    String new_ID_Cliente = "123";
    String new_Nombre = "Pal";
    String new_Apellido = "Agr";
    String new_Correo_electronico= "mai";
    String new_Teléfono = "123";
      // Consulta SQL para actualizar los datos de un empleado
    String sql = "UPDATE Empleado set ID_Cliente='"+new_ID_Cliente+"',Nombre='"+new_Nombre+"',Apellido='"+new_Apellido+"',Correo_electronico='"+new_Correo_electronico+"',',Teléfono='"+new_Teléfono+"''where id="+id_editar;
    try{
          // Registrar el driver JDBC
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editarEmpleado.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
        // Establecer conexión con la base de datos
    cn=con.getConection();
    st=cn.createStatement();
        // Ejecutar la consulta de actualización
    st.executeUpdate(sql);
    
      // Recuperar todos los registros actualizados de la tabla empleado
    rs=st.executeQuery("SELECT * FROM Cliente");
    rs.next();
    
    // Mostrar los datos de la tabla Cliente en la consola
    do{
    System.out.println(rs.getInt("ID_Cliente")+":"+rs.getString("Nombre")+"-"+rs.getString("Apellido")+"-"+rs.getString("Correo_electronico")+"-"+rs.getString("Teléfono"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}

    

