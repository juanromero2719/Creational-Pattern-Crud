/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Interfaz.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wrydmoon
 */
public class MySQLConexion implements IConexion{
    
    private String url;
    private String usuario;
    private String password;
    
    public MySQLConexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, usuario, password);
    }
    
}
