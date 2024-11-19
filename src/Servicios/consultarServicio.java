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
public class consultarServicio {

    public static void main (String[] args){
     // Crear una instancia de la conexión a la base de datos
     Conexion1 con=new Conexion1();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    try{
          // Registrar el driver JDBC
     Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(consultarServicio.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
        // Establecer conexión con la base de datos
    cn=con.getConection();
    st=cn.createStatement();
    
    // Ejecutar la consulta para obtener todos los registros de la tabla Empleado
      rs=st.executeQuery("SELECT * FROM Servicios ");
    rs.next();

     // Mostrar los datos de la tabla Servicios en la consola
        do{
    System.out.println(rs.getInt("ID_Servicio")+":"+rs.getString("ID_Cliente")+"-"+rs.getString("Fecha")+"-"+rs.getString("Hora")+"-"+rs.getString("Precio"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(consultarServicio.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }   
}
    