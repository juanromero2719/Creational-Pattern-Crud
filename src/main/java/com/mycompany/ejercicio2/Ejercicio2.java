/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import Fabrica.FabricaConexion;
import Vista.EstudianteGUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author wrydmoon
 */
public class Ejercicio2 {

    public static void main(String[] args) {
         try {
             
            Connection conexion = FabricaConexion.getInstancia().crearConexion();
            EstudianteGUI estudianteGUI = new EstudianteGUI();
            estudianteGUI.show();
            
            
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    } 
}
