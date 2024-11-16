package com.turismo.app;

import com.turismo.model.TurismoRegistro;
import com.turismo.servicios.Turismo;
import com.turismo.utils.LectorCSV;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Rutas de archivos
        String rutaCSV = "src/main/resources/TurismoComunidades.csv";

        // Crear instancias de utilidades y servicios
        LectorCSV lector = new LectorCSV();
        Turismo servicio = new Turismo();

        // Leer registros desde el archivo CSV
        List<TurismoRegistro> registros = lector.leeCSV(rutaCSV);

        // Solicitar al usuario la provincia de origen
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la provincia de origen: ");
        String provincia = scanner.nextLine();

        // Filtrar registros por provincia de origen
        List<TurismoRegistro> filtrados = servicio.filtrarPorProvinciaOrigen(registros, provincia, 100000);

        // Mostrar resultados
        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron registros para la provincia de origen: " + provincia);
        } else {
            System.out.println("Registros encontrados para la provincia de origen " + provincia + ":");
            filtrados.forEach(System.out::println);
            System.out.println("Total de registros encontrados: " + filtrados.size());
        }
    }
}
