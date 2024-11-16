package com.turismo.app;

import com.turismo.model.TurismoRegistro;
import com.turismo.utils.LectorCSV;
import com.turismo.utils.EscribirJSON;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ruta del archivo CSV y nombre del archivo JSON de salida
        String rutaCSV = "src/main/resources/TurismoComunidades.csv";
        String rutaJSON = "src/main/resources/TurismoComunidades.json";

        // Crear instancias de utilidades
        LectorCSV lector = new LectorCSV();
        EscribirJSON escritor = new EscribirJSON();

        // Leer registros desde el archivo CSV
        List<TurismoRegistro> registros = lector.leeCSV(rutaCSV);

        // Escribir registros en un archivo JSON
        escritor.escribeJSON(registros, rutaJSON);
    }
}
