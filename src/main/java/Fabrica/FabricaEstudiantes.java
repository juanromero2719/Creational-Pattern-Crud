/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabrica;

import Modelo.Estudiante;

/**
 *
 * @author wrydmoon
 */
public class FabricaEstudiantes {
    
    private static FabricaEstudiantes instancia;
    
    private FabricaEstudiantes() {
    }
    
    public static FabricaEstudiantes getInstancia() {
        
        if (instancia == null) {
            instancia = new FabricaEstudiantes();
        }
        return instancia;
    }

    
    public Estudiante crearEstudiante(int idEstudiante, String nombreEstudiante, String apellidoEstudiante, String codigo, double promedio){
        return new Estudiante(idEstudiante, nombreEstudiante, apellidoEstudiante, codigo, promedio);
    }
}
