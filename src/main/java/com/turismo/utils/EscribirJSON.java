package com.turismo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.turismo.model.TurismoRegistro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase para manejar la escritura de datos en formato JSON.
 *
 * @author RodrigoIbañez
 */
public class EscribirJSON {

    /**
     * Escribe una lista de objetos TurismoRegistro en un archivo JSON.
     *
     * @param registros   Lista de objetos TurismoRegistro.
     * @param nombreArchivo Ruta del archivo donde se guardará el JSON.
     */
    public void escribeJSON(List<TurismoRegistro> registros, String nombreArchivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Formato legible

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(registros, writer);
            System.out.println("Archivo JSON generado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }
}
