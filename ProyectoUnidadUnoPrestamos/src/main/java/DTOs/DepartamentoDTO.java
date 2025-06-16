/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author jalt2
 */
public class DepartamentoDTO {
    private String nombre;
    private String saldoPresupuesto;

    public DepartamentoDTO(String nombre, String saldoPresupuesto) {
        this.nombre = nombre;
        this.saldoPresupuesto = saldoPresupuesto;
    }

    public DepartamentoDTO() {
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
    
    
}
