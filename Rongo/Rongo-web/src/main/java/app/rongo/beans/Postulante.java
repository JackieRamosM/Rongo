/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.rongo.beans;

/**
 *
 * @author Liliana
 */
public class Postulante {
    
    private String nombre;
    private String carrera;
    private String promediogeneral;
    private String estado;
    private String usuario;
    private String matricula;
    private String ayudantiaaplicada;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPromediogeneral() {
        return promediogeneral;
    }

    public void setPromediogeneral(String promediogeneral) {
        this.promediogeneral = promediogeneral;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAyudantiaaplicada() {
        return ayudantiaaplicada;
    }

    public void setAyudantiaaplicada(String ayudantiaaplicada) {
        this.ayudantiaaplicada = ayudantiaaplicada;
    }       
}
