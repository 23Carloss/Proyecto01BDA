/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaMoral {
    private String NumeroCuenta;
    private String Nombrebanco;
    private String saldoPresupuesto;
    
    

    public CuentaMoral() {
    }

    public CuentaMoral(String NumeroCuenta, String saldoPresupuesto, String Nombrebanco) {
        this.NumeroCuenta = NumeroCuenta;
        this.saldoPresupuesto = saldoPresupuesto;
        this.Nombrebanco = Nombrebanco;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getNombrebanco() {
        return Nombrebanco;
    }

    public void setNombrebanco(String Nombrebanco) {
        this.Nombrebanco = Nombrebanco;
    }

    public String getSaldoPresupuesto() {
        return saldoPresupuesto;
    }

    public void setSaldoPresupuesto(String saldoPresupuesto) {
        this.saldoPresupuesto = saldoPresupuesto;
    }

    @Override
    public String toString() {
        return "CuentaMoral{" + "NumeroCuenta=" + NumeroCuenta + ", Nombrebanco=" + Nombrebanco + ", saldoPresupuesto=" + saldoPresupuesto + '}';
    }

    
    
    
}
