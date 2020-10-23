package com.gavilan.tiendafrutas.clases;

import java.io.Serializable;

public class Fruta implements Serializable {
    private int id;
    private String nombre;
    private double valorKilo;
    // 10 kg
    private double valorMayor;

    public Fruta() {
    }

    public Fruta(int id, String nombre, double valorKilo, double valorMayor) {
        this.id = id;
        this.nombre = nombre;
        this.valorKilo = valorKilo;
        this.valorMayor = valorMayor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorKilo() {
        return valorKilo;
    }

    public void setValorKilo(double valorKilo) {
        this.valorKilo = valorKilo;
    }

    public double getValorMayor() {
        return valorMayor;
    }

    public void setValorMayor(double valorMayor) {
        this.valorMayor = valorMayor;
    }
}
