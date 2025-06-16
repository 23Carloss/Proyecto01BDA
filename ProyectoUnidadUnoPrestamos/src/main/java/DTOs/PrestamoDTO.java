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
    private double MontoInicial;
    private double adeudo;
    private LocalDateTime fecha;
    private TipoPrestamoDTO tipo;
    private String Estatus; // pooer en sql q predeterminado sea creado
    //falta el comprobante

    public PrestamoDTO() {
    }

    public PrestamoDTO(double MontoInicial, double adeudo, LocalDateTime fecha) {
        this.MontoInicial = MontoInicial;
        this.adeudo = adeudo;
        this.fecha = fecha;
    }

    public double getMontoInicial() {
        return MontoInicial;
    }

    public void setMontoInicial(double MontoInicial) {
        this.MontoInicial = MontoInicial;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

    public TipoPrestamoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoPrestamoDTO tipo) {
        this.tipo = tipo;
    }
    

    public PrestamoDTO(double MontoInicial, double adeudo, LocalDateTime fecha, TipoPrestamoDTO tipo) {
        this.MontoInicial = MontoInicial;
        this.adeudo = adeudo;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PrestamoDTO{" + "MontoInicial=" + MontoInicial + ", adeudo=" + adeudo + ", fecha=" + fecha + ", tipo=" + tipo + '}';
    }
   
}
