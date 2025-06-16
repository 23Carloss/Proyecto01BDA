/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdaptadores;

import DTOs.CuentaMoralDTO;
import Dominio.CuentaMoral;
import Persistencia.PersistenciaException;

/**
 *
 * @author HP
 */
public interface IAdaptadorCuentaMoral {
    public CuentaMoral convertirADominio(CuentaMoralDTO cuenta) throws PersistenciaException;
    public CuentaMoralDTO convertirADTO(CuentaMoral cuenta) throws PersistenciaException;
}
