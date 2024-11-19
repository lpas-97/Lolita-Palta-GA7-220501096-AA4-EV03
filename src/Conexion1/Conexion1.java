/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author lolit
 *
 */

public class Conexion1 {

    // Atributo que almacenará la conexión con la base de datos.

   private Connection con;

     public Conexion1 () {

        try {
             // Registrar el driver JDBC para MySQL.
            Class.forName("com.mysql.jdbc.Driver");
            
              // Establecer conexión con la base de datos, proporcionando la URL, usuario y contraseña.
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelscloud", "root", "8897");
        }catch (ClassNotFoundException | SQLException e) {
             // Manejo de errores en caso de que no se pueda conectar con la base de datos.
            System.out.println("No Conectado");
        }
    }
     //Método que devuelve la conexión activa con la base de datos.
    public Connection getConection(){
    return con;
    }
    

}   
