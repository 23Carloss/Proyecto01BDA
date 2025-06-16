/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Departamento{ 
    private String nombre;
    private String saldoPresupuesto;
    private List<CuentaMoral> listaMoral  ;

    public Departamento() {
    }

    public Departamento(String nombre, String saldoPresupuesto, List<CuentaMoral> listaMoral) {
        this.nombre = nombre;
        this.saldoPresupuesto = saldoPresupuesto;
        this.listaMoral = listaMoral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSaldoPresupuesto() {
        return saldoPresupuesto;
    }

    public void setSaldoPresupuesto(String saldoPresupuesto) {
        this.saldoPresupuesto = saldoPresupuesto;
    }

    public List<CuentaMoral> getlistaMoral() {
        return listaMoral;
    }

    public void setlistaMoral(List<CuentaMoral> listaEstado) {
        this.listaMoral = listaEstado;
    }

   
    
    
}
