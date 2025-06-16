/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adaptadores;

import DTOs.CuentaMoralDTO;
import Dominio.CuentaMoral;
import IAdaptadores.IAdaptadorCuentaMoral;
import Persistencia.PersistenciaException;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorCuentaMoral implements IAdaptadorCuentaMoral{

    @Override
    public CuentaMoral convertirADominio(CuentaMoralDTO cuenta) throws PersistenciaException {
        CuentaMoral cuentaDominio = new CuentaMoral();
        cuentaDominio.setNombrebanco(cuenta.getNombrebanco());
        cuentaDominio.setSaldoPresupuesto(cuenta.getSaldoPresupuesto());
        cuentaDominio.setNumeroCuenta(cuenta.getNumeroCuenta());
        return cuentaDominio;
    }

    @Override
    public CuentaMoralDTO convertirADTO(CuentaMoral cuenta) throws PersistenciaException {
        CuentaMoralDTO cuentaDTO = new CuentaMoralDTO();
        cuentaDTO.setNombrebanco(cuenta.getNombrebanco());
        cuentaDTO.setSaldoPresupuesto(cuenta.getSaldoPresupuesto());
        cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
        return cuentaDTO;
    }
    
    
}
