/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOs.DepartamentoDTO;
import Dominio.Departamento;
import java.util.List;

/**
 *
 * @author Sandra
 */
public interface IDepartamentoDAO {

    List<DepartamentoDTO> consultarTodos() throws PersistenciaException;
}
