package com.turismo.servicios;

import com.turismo.model.TurismoRegistro; /** Trae el contenido de la clase principal*/

import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de servicios para manejar operaciones relacionadas con TurismoRegistro.
 *
 * @author RodrigoIbañez
 */
public class Turismo {

    /**
     * Filtra los registros por un período específico.
     *
     * @param registros Lista de registros a filtrar.
     * @param periodo   Período en formato yyyyMM (ejemplo: 2023M08).
     * @return Lista de registros que coinciden con el período.
     */
    public List<TurismoRegistro> filtrarPorPeriodo(List<TurismoRegistro> registros, String periodo) {
        return registros.stream()
                .filter(registro -> registro.getPeriodo().getPeriodo().equals(periodo))
                .collect(Collectors.toList());
    }
}
