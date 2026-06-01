/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    public void crearArchivo(String nombre)throws IOException {

        File archivo = new File(nombre);

        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }

    public boolean existeArchivo(String nombre) {

        File archivo = new File(nombre);

        return archivo.exists();
    }

    public void borrarArchivo(String nombre) {

        File archivo = new File(nombre);

        if (archivo.exists()) {
            archivo.delete();
        }
    }

    public void agregarLinea(String nombre, String linea) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombre, true))) {
        writer.write(linea);
        writer.newLine();
    }
}
    
  
    public ArrayList<String> obtenerLineas(String nombre) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        File f = new File(nombre);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
}

    
}