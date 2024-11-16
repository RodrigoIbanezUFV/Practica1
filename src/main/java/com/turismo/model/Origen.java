package com.turismo.model;

public class Origen {
    private String comunidad;
    private String provincia;

    public Origen(String comunidad, String provincia) {
        this.comunidad = comunidad;
        this.provincia = provincia;
    }

    // Getters y setters
    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Origen{" +
                "comunidad='" + comunidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
