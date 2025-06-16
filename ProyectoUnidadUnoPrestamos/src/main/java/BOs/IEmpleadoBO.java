/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTOs.EmpleadoDTO;

/**
 *
 * @author jalt2
 */
public interface IEmpleadoBO {
    public EmpleadoDTO consultarPorId(String id)throws NegocioException;
}
