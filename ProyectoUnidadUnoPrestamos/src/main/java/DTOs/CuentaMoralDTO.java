/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class CuentaMoralDTO {
    private String NumeroCuenta;
    private String Nombrebanco;
    private String saldoPresupuesto;

    public CuentaMoralDTO() {
    }

    public CuentaMoralDTO(String NumeroCuenta, String Nombrebanco, String saldoPresupuesto) {
        this.NumeroCuenta = NumeroCuenta;
        this.Nombrebanco = Nombrebanco;
        this.saldoPresupuesto = saldoPresupuesto;
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
        return "CuentaMoralDTO{" + "NumeroCuenta=" + NumeroCuenta + ", Nombrebanco=" + Nombrebanco + ", saldoPresupuesto=" + saldoPresupuesto + '}';
    }
    
    
    
}
