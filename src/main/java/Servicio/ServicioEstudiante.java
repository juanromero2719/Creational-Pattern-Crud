/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Fabrica.FabricaEstudiantes;
import Modelo.Estudiante;
import Repositorio.EstudianteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author wrydmoon
 */
public class ServicioEstudiante {
    
    private final EstudianteDAO estudianteDAO;
    private final FabricaEstudiantes fabricaEstudiante;
    
    
    public ServicioEstudiante() throws SQLException, IOException {
        this.estudianteDAO = new EstudianteDAO();
        this.fabricaEstudiante = new FabricaEstudiantes();
    }
    
    public void agregarEstudiante(int idEstudiante, String nombre, String apellido, String codigo, double promedio){
        Estudiante estudiante = fabricaEstudiante.crearEstudiante(idEstudiante, nombre, apellido, codigo, promedio);
        estudianteDAO.agregar(estudiante);
    }
    
    public Estudiante consultarEstudiante(int idEstudiante){
        return estudianteDAO.consultar(idEstudiante);
    }
    
    public void eliminarEstudiante(int idEstudiante){
        estudianteDAO.eliminar(idEstudiante);
    }
    
    public void editarEstudiante(int idEstudiante, String nombre, String apellido, String codigo, double promedio){
        Estudiante estudiante = fabricaEstudiante.crearEstudiante(idEstudiante, nombre, apellido, codigo, promedio);
        estudianteDAO.editar(estudiante);
    }
    
    public List<Estudiante> listar(){
        List<Estudiante> estudiantes = estudianteDAO.listar();
        for(Estudiante estudiante : estudiantes){
            System.out.println(estudiante.toString()); 
        }
        return estudiantes;
    }
}
