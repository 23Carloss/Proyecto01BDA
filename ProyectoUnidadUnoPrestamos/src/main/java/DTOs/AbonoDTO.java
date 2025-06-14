/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

import java.time.LocalDateTime;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AbonoDTO {
    private double cantidadAbono;
    private LocalDateTime fecha;
    
    
    public AbonoDTO() {
    }

    public AbonoDTO(double cantidadAbono, LocalDateTime fecha) {
        this.cantidadAbono = cantidadAbono;
        this.fecha = fecha;
    }

    public double getCantidadAbono() {
        return cantidadAbono;
    }

    public void setCantidadAbono(double cantidadAbono) {
        this.cantidadAbono = cantidadAbono;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "AbonoDTO{" + "cantidadAbono=" + cantidadAbono + ", fecha=" + fecha + '}';
    }
    
    

}
