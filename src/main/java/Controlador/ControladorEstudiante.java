/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Servicio.ServicioEstudiante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author wrydmoon
 */
public class ControladorEstudiante {
    
    private final ServicioEstudiante servicioEstudiante;
    
    public ControladorEstudiante() throws SQLException, IOException{
        this.servicioEstudiante = new ServicioEstudiante();
    }
    
    public void agregarEstudiante(int id, String nombre, String apellido, String codigo, double promedio){
        servicioEstudiante.agregarEstudiante(id, nombre, apellido, codigo, promedio);
    }
    
    public void editarEstudiante(int id, String nombre, String apellido, String codigo, double promedio){
        servicioEstudiante.editarEstudiante(id, nombre, apellido, codigo, promedio);
    }
    
    public void eliminarEstudiante(int id){
        servicioEstudiante.eliminarEstudiante(id);
    }
    
    public Estudiante consultarEstudiante(int id){
        return servicioEstudiante.consultarEstudiante(id);
    }
    
    public List<Estudiante> listar(){
        return servicioEstudiante.listar();
    }
}
