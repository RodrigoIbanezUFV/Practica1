package com.turismo.app;

import com.turismo.model.TurismoRegistro;
import com.turismo.services.AgrupadorService;
import com.turismo.services.TurismoService;
import com.turismo.utils.JsonWriter;
import com.turismo.utils.LectorCSV;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Rutas de archivos
        String rutaCSV = "src/main/resources/TurismoComunidades.csv";
        String rutaJSON = "src/main/resources/TurismoComunidades.json";
        String rutaJSONAgrupado = "src/main/resources/Comunidades_agrupadas.json";

        // Crear instancias de utilidades y servicios
        LectorCSV lector = new LectorCSV();
        JsonWriter escritor = new JsonWriter();
        AgrupadorService agrupador = new AgrupadorService();
        TurismoService servicio = new TurismoService();

        // Leer registros desde el archivo CSV
        List<TurismoRegistro> registros = lector.leeCSV(rutaCSV);

        // Menú interactivo
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- Menú Interactivo ---");
            System.out.println("1. Convertir CSV a JSON");
            System.out.println("2. Agrupar por comunidad de destino");
            System.out.println("3. Filtrar por período");
            System.out.println("4. Filtrar por provincia de origen");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    // Convertir CSV a JSON
                    escritor.escribeJSON(registros, rutaJSON);
                    break;

                case 2:
                    // Agrupar por comunidad de destino
                    agrupador.agruparPorComunidadDestino(registros, rutaJSONAgrupado);
                    break;

                case 3:
                    // Filtrar por período
                    System.out.print("Introduce el período a buscar (formato yyyyMM): ");
                    String periodo = scanner.nextLine();
                    List<TurismoRegistro> filtradosPorPeriodo = servicio.filtrarPorPeriodo(registros, periodo);

                    if (filtradosPorPeriodo.isEmpty()) {
                        System.out.println("No se encontraron registros para el período: " + periodo);
                    } else {
                        System.out.println("Registros encontrados para el período " + periodo + ":");
                        filtradosPorPeriodo.forEach(System.out::println);
                        System.out.println("Total de registros encontrados: " + filtradosPorPeriodo.size());
                    }
                    break;

                case 4:
                    // Filtrar por provincia de origen
                    System.out.print("Introduce la provincia de origen: ");
                    String provincia = scanner.nextLine();
                    List<TurismoRegistro> filtradosPorProvincia = servicio.filtrarPorProvinciaOrigen(registros, provincia, 100000);

                    if (filtradosPorProvincia.isEmpty()) {
                        System.out.println("No se encontraron registros para la provincia de origen: " + provincia);
                    } else {
                        System.out.println("Registros encontrados para la provincia de origen " + provincia + ":");
                        filtradosPorProvincia.forEach(System.out::println);
                        System.out.println("Total de registros encontrados: " + filtradosPorProvincia.size());
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("¡Gracias por usar la aplicación! Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
