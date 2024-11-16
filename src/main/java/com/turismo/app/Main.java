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

        // Solicitar al usuario el período a filtrar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el período a buscar (formato yyyyMM): ");
        String periodo = scanner.nextLine();

        // Filtrar registros por período
        List<TurismoRegistro> filtrados = servicio.filtrarPorPeriodo(registros, periodo);

        // Mostrar resultados
        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron registros para el período: " + periodo);
        } else {
            System.out.println("Registros encontrados para el período " + periodo + ":");
            filtrados.forEach(System.out::println);
            System.out.println("Total de registros encontrados: " + filtrados.size());
        }
    }
}