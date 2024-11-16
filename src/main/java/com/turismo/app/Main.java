package com.turismo.app;

import com.turismo.model.TurismoRegistro;
import com.turismo.utils.LectorCSV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LectorCSV lector = new LectorCSV();
        String rutaCSV = "src/main/resources/TurismoComunidades.csv";

        // Leer registros desde el archivo CSV
        List<TurismoRegistro> registros = lector.leeCSV(rutaCSV);

        // Imprimir los registros leídos
        for (TurismoRegistro registro : registros) {
            System.out.println(registro);
        }
    }
}
