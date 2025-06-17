/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adaptadores;

import DTOs.CuentaFisicaDTO;
import Dominio.CuentaFisica;
import IAdaptadores.IAdaptadorCuentaFisica;
import Persistencia.PersistenciaException;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorCuentaFisica implements IAdaptadorCuentaFisica{

    @Override
    public CuentaFisica convertirADominio(CuentaFisicaDTO cuenta) throws PersistenciaException {
        CuentaFisica cuentaDominio = new CuentaFisica();
        cuentaDominio.setNombreBanco(cuenta.getNombreBanco());
        cuentaDominio.setSaldoPresupuesto(cuenta.getSaldoPresupueto());
        cuentaDominio.setClabe(cuenta.getClabe());
        return cuentaDominio;
    }

    @Override
    public CuentaFisicaDTO convertirADTO(CuentaFisica cuenta) throws PersistenciaException {
        CuentaFisicaDTO cuentaDTO = new CuentaFisicaDTO();
        cuentaDTO.setNombreBanco(cuenta.getNombreBanco());
        cuentaDTO.setSaldoPresupueto(cuenta.getSaldoPresupuesto());
        cuentaDTO.setClabe(cuenta.getClabe());
        return cuentaDTO;
    }
    
}
