/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author manana
 */
public class Medicos {
    
    private int idMedicos;
    private String nombre;
    private int sala;
    private int tarifa;
    private String especialidad;

    public Medicos() {
    }

    public Medicos(String nombre, int sala, int tarifa, String especialidad) {
        this.nombre = nombre;
        this.sala = sala;
        this.tarifa = tarifa;
        this.especialidad = especialidad;
    }

    public Medicos(int idMedicos, String nombre, int sala, int tarifa, String especialidad) {
        this.idMedicos = idMedicos;
        this.nombre = nombre;
        this.sala = sala;
        this.tarifa = tarifa;
        this.especialidad = especialidad;
    }

    
    
    public int getIdMedicos() {
        return idMedicos;
    }

    public void setIdMedicos(int idMedicos) {
        this.idMedicos = idMedicos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
