package com.turismo.app;

import com.turismo.model.TurismoRegistro;
import com.turismo.servicios.Agrupador;
import com.turismo.utils.LectorCSV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Rutas de archivos
        String rutaCSV = "src/main/resources/TurismoComunidades.csv";
        String rutaJSONAgrupado = "src/main/resources/Comunidades_agrupadas.json";

        // Crear instancias de utilidades y servicios
        LectorCSV lector = new LectorCSV();
        Agrupador agrupador = new Agrupador();

        // Leer registros desde el archivo CSV
        List<TurismoRegistro> registros = lector.leeCSV(rutaCSV);

        // Agrupar por comunidad de destino y escribir en JSON
        agrupador.agruparPorComunidadDestino(registros, rutaJSONAgrupado);
    }
}
