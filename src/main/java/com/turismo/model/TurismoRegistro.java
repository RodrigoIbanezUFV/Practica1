package com.turismo.model;

import java.util.UUID;

public class TurismoRegistro {
    private String id; // Identificador único
    private Origen origen;
    private Destino destino;
    private Periodo periodo;
    private int total; // Número total de turistas

    public TurismoRegistro(Origen origen, Destino destino, Periodo periodo, int total) {
        this.id = UUID.randomUUID().toString(); // Genera un ID único
        this.origen = origen;
        this.destino = destino;
        this.periodo = periodo;
        this.total = total;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TurismoRegistro{" +
                "id='" + id + '\'' +
                ", origen=" + origen +
                ", destino=" + destino +
                ", periodo=" + periodo +
                ", total=" + total +
                '}';
    }
}