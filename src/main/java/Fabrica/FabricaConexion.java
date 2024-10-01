    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabrica;

import Interfaz.IConexion;
import Conexion.MySQLConexion;
import Conexion.PostgreSQLConexion;
import Configuracion.Configuracion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author wrydmoon
 */
public class FabricaConexion {
    
    private static FabricaConexion instancia;
    private IConexion conexion;
    
    private FabricaConexion(){
    
    }
    
    public static FabricaConexion getInstancia(){
        
        if(instancia == null){
            instancia = new FabricaConexion();
        }
        return instancia;
    }
    
    public Connection crearConexion() throws SQLException, IOException {
        
        Configuracion config = new Configuracion("config.properties");
        String tipoBD = config.getPropiedad("db.tipo");
        String url = config.getPropiedad("db.url");
        String usuario = config.getPropiedad("db.usuario");
        String password = config.getPropiedad("db.password");
                   
        switch (tipoBD.toLowerCase()) {
            
            case "mysql":
                System.out.println("Intentando conectar a mysql...");
                conexion = new MySQLConexion(url, usuario, password);
                break;
            case "postgresql":
                System.out.println("Intentando conectar a postgres...");
                conexion = new PostgreSQLConexion(url, usuario, password);
                break;
            default:
                System.out.println("Tipo de base de datos no soportado: " + tipoBD);
        }
        
             
        return conexion.conectar();
    }
}
