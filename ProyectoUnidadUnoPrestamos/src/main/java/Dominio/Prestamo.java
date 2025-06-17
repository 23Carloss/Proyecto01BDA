/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.math.BigDecimal;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Prestamo {

    private String idPrestamo;
    private BigDecimal adeudo;
    private String idTipoDePrestamo;

    public Prestamo(String idPrestamo, BigDecimal adeudo, String idTipoDePrestamo) {
        this.idPrestamo = idPrestamo;
        this.adeudo = adeudo;
        this.idTipoDePrestamo = idTipoDePrestamo;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public BigDecimal getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(BigDecimal adeudo) {
        this.adeudo = adeudo;
    }

    public String getIdTipoDePrestamo() {
        return idTipoDePrestamo;
    }

    public void setIdTipoDePrestamo(String idTipoDePrestamo) {
        this.idTipoDePrestamo = idTipoDePrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", adeudo=" + adeudo + ", idTipoDePrestamo=" + idTipoDePrestamo + '}';
    }

}
