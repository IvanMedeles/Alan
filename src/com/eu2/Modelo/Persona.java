/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eu2.Modelo;

/**
 *
 * @author Ivan Medeles
 */
public class Persona {
    private int id;
    private String nombre;
    private String contrasenha;
    private String control;
    private String Ciudad;

    public Persona() {
    }

    public Persona(int id, String nombre, String contrasenha, String control, String Ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenha = contrasenha;
        this.control = control;
        this.Ciudad = Ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", contrasenha=" + contrasenha + ", control=" + control + ", Ciudad=" + Ciudad + '}';
    }

    public void imprimir(){
        System.out.println(toString());
    }
}