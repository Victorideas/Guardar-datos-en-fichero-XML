package crearxml;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author instalador
 */
public class Coche implements Serializable {

    String matricula;
    String color;
    String modelo;
    int año;

    public Coche(String matricula, String modelo, String color, int año) {
        this.matricula = matricula;
        this.color = color;
        this.modelo = modelo;
        this.año = año;
        System.out.println("El coche se ha creado");
    }

    public void mostrarCoche() {
        System.out.println("Matricula " + matricula + " Color: " + color + " Modelo: " + modelo);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }
}
