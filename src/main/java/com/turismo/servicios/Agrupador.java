package com.turismo.servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.turismo.model.TurismoRegistro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase para agrupar registros por comunidad de destino.
 * @author RodrigoIbañez
 */
public class Agrupador {

    /**
     * Agrupa los registros por comunidad de destino y escribe el resultado en un archivo JSON.
     *
     * @param registros     Lista de registros a agrupar.
     * @param nombreArchivo Ruta del archivo JSON de salida.
     */
    public void agruparPorComunidadDestino(List<TurismoRegistro> registros, String nombreArchivo) {
        // Crear un mapa para agrupar por comunidad de destino
        Map<String, List<TurismoRegistro>> agrupados = new HashMap<>();

        for (TurismoRegistro registro : registros) {
            String comunidadDestino = registro.getDestino().getComunidad();
            // Manejar valores nulos o vacíos
            if (comunidadDestino == null || comunidadDestino.isEmpty()) {
                comunidadDestino = "Sin comunidad"; // Etiqueta para valores nulos
            }
            // Agregar el registro a la lista correspondiente en el mapa
            agrupados.computeIfAbsent(comunidadDestino, k -> new ArrayList<>()).add(registro);
        }

        // Escribir el mapa agrupado en un archivo JSON
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(agrupados, writer);
            System.out.println("Archivo JSON agrupado generado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON agrupado: " + e.getMessage());
        }
    }
}
