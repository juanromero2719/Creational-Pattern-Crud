/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import Fabrica.FabricaConexion;
import Interfaz.IGestorDatos;
import Modelo.Estudiante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wrydmoon
 */
public class EstudianteDAO implements IGestorDatos<Estudiante>{
    
    private Connection conexion;

    public EstudianteDAO() throws SQLException, IOException {
        this.conexion = FabricaConexion.getInstancia().crearConexion();
    }

    @Override
    public void agregar(Estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (id, nombre, apellido, codigo, promedio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estudiante.getId());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getApellido());
            stmt.setString(4, estudiante.getCodigo());
            stmt.setDouble(5, estudiante.getPromedio());
            stmt.executeUpdate();
            System.out.println("----------");
            System.out.println("conexion:" + conexion);
            System.out.println("----------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante consultar(int id) {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";
        Estudiante estudiante = null;
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                estudiante = new Estudiante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("codigo"),
                        rs.getDouble("promedio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }


    @Override
    public List<Estudiante> listar() {
        String sql = "SELECT * FROM estudiantes";
        List<Estudiante> estudiantes = new ArrayList<>();
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Estudiante estudiante = new Estudiante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("codigo"),
                        rs.getDouble("promedio")
                );
                estudiantes.add(estudiante);
                
            }
            
            System.out.println("----------");
            System.out.println("conexion:" + conexion);
            System.out.println("----------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    @Override
    public void editar(Estudiante estudiante) {
        String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, codigo = ?, promedio = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getCodigo());
            stmt.setDouble(4, estudiante.getPromedio());
            stmt.setInt(5, estudiante.getId());
            stmt.executeUpdate();
            System.out.println("----------");
            System.out.println("conexion:" + conexion);
            System.out.println("----------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM estudiantes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    
}
