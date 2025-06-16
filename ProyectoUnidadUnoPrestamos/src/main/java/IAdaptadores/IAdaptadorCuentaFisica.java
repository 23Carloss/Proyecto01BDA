/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdaptadores;

import DTOs.CuentaFisicaDTO;
import Dominio.CuentaFisica;
import Persistencia.PersistenciaException;

/**
 *
 * @author HP
 */
public interface IAdaptadorCuentaFisica {
    public CuentaFisica convertirADominio(CuentaFisicaDTO cuenta) throws PersistenciaException;
    public CuentaFisicaDTO convertirADTO(CuentaFisica cuenta) throws PersistenciaException;
}
