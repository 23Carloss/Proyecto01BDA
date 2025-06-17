/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author !!Jonathan
 */
public class Abono {

    private String idAbono;
    private BigDecimal monto;
    private LocalDateTime fechaHora;
    private String idPrestamo;

    public Abono(String idAbono, BigDecimal monto, LocalDateTime fechaHora, String idPrestamo) {
        this.idAbono = idAbono;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.idPrestamo = idPrestamo;
    }

    public String getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(String idAbono) {
        this.idAbono = idAbono;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public String toString() {
        return "Abono{" + "idAbono=" + idAbono + ", monto=" + monto + ", fechaHora=" + fechaHora + ", idPrestamo=" + idPrestamo + '}';
    }

}
