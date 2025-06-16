/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdaptadores;

import DTOs.DepartamentoDTO;
import Dominio.Departamento;
import Persistencia.PersistenciaException;

/**
 *
 * @author HP
 */
public interface IAdaptadorDepartamento {
    public Departamento convertirADominio(DepartamentoDTO departamento) throws PersistenciaException;
    public DepartamentoDTO convertirADTO(Departamento departamento) throws PersistenciaException;
}
