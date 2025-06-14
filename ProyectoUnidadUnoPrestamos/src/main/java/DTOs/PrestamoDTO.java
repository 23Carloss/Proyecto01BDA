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
public class PrestamoDTO {
    private double adeudo;
    private LocalDateTime fecha;

    public PrestamoDTO() {
    }

    public PrestamoDTO(double adeudo) {
        this.adeudo = adeudo;
    }

    public double getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(double adeudo) {
        this.adeudo = adeudo;
    }

    @Override
    public String toString() {
        return "PrestamosDTO{" + "adeudo=" + adeudo + '}';
    }
    
    
}
