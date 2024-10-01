/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wrydmoon
 */
public class ConexionBD {
    
    private static ConexionBD instancia;
    private Connection conexion;
    
    private ConexionBD(String url, String usuario, String password){
        
        try {
            this.conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
        }
        
    }

    public static ConexionBD getInstancia(String url, String usuario, String password) throws SQLException {
        
        if (instancia == null) {
            instancia = new ConexionBD(url, usuario, password);
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
    
}
