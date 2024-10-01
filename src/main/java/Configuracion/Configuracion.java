/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author wrydmoon
 */
public class Configuracion {
    
    private Properties propiedades;

    public Configuracion(String archivoConfig) throws IOException {
        propiedades = new Properties();
        try (FileInputStream input = new FileInputStream(archivoConfig)) {
            propiedades.load(input);
        }
    }

    public String getPropiedad(String clave) {
        return propiedades.getProperty(clave);
    }
}
