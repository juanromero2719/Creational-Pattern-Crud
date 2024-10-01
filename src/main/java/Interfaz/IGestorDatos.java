/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import java.util.List;

/**
 *
 * @author wrydmoon
 */
public interface IGestorDatos<T>{
    
    void agregar(T t);
    T consultar(int id);
    List<T> listar();
    void editar(T t);
    void eliminar(int id);
}
