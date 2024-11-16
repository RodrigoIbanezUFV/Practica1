package com.turismo.utils;

import com.opencsv.CSVReader;
import com.turismo.model.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para leer archivos CSV y convertirlos en objetos TurismoRegistro.
 *
 * @author RodrigoIbañez
 */
public class LectorCSV {

    /**
     * Lee un archivo CSV y convierte sus filas en una lista de objetos TurismoRegistro.
     *
     * @param nombreArchivo Ruta al archivo CSV.
     * @return Lista de objetos TurismoRegistro.
     */
    public List<TurismoRegistro> leeCSV(String nombreArchivo) {
        List<TurismoRegistro> registros = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(nombreArchivo))) {
            String[] fila;
            csvReader.readNext(); // Salta la primera fila (asumiendo que son encabezados).

            while ((fila = csvReader.readNext()) != null) {
                // Manejar valores nulos o vacíos
                String origenComunidad = fila[0].isEmpty() ? null : fila[0];
                String origenProvincia = fila[1].isEmpty() ? null : fila[1];
                String destinoComunidad = fila[2].isEmpty() ? null : fila[2];
                String destinoProvincia = fila[3].isEmpty() ? null : fila[3];
                String periodo = fila[4];
                int total = Integer.parseInt(fila[5].replace(",", "").trim());

                // Crear objetos para origen, destino y período
                Origen origen = new Origen(origenComunidad, origenProvincia);
                Destino destino = new Destino(destinoComunidad, destinoProvincia);
                Periodo periodoObj = new Periodo(
                        periodo.substring(0, 4) + "-01-01", // Fecha de inicio (personalizable)
                        periodo.substring(0, 4) + "-12-31", // Fecha de fin (personalizable)
                        periodo
                );

                // Crear el objeto TurismoRegistro y agregarlo a la lista
                TurismoRegistro registro = new TurismoRegistro(origen, destino, periodoObj, total);
                registros.add(registro);
            }

        } catch (Exception ex) {
            System.out.println("Error al leer el archivo CSV: " + ex.getMessage());
        }

        return registros;
    }

}
