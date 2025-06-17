/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaFisica {
    private String Clabe;
    private String NombreBanco;
    private String estatus;
    private double SaldoPresupuesto;

    public CuentaFisica() {
    }

    public CuentaFisica(String Clabe, String NombreBanco, String estatus) {
        this.Clabe = Clabe;
        this.NombreBanco = NombreBanco;
        this.estatus = estatus;
    }

    public String getClabe() {
        return Clabe;
    }

    public void setClabe(String Clabe) {
        this.Clabe = Clabe;
    }

    public String getNombreBanco() {
        return NombreBanco;
    }

    public void setNombreBanco(String NombreBanco) {
        this.NombreBanco = NombreBanco;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public double getSaldoPresupuesto() {
        return SaldoPresupuesto;
    }

    public void setSaldoPresupuesto(double SaldoPresupueto) {
        this.SaldoPresupuesto = SaldoPresupueto;
    }

    @Override
    public String toString() {
        return "CuentaFisica{" + "Clabe=" + Clabe + ", NombreBanco=" + NombreBanco + ", estatus=" + estatus + ", SaldoPresupueto=" + SaldoPresupuesto + '}';
    }
  
}
