/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOs.EmpleadoDTO;
import persistencia.IEmpleadoDAO;

/**
 *
 * @author jalt2
 */
public class EmpleadoBO implements IEmpleadoBO{
    private IEmpleadoDAO empleadoDAO;

    public EmpleadoBO(IEmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    @Override
    public EmpleadoDTO consultarPorId(String id) throws NegocioException{
        if (id == null) {
            throw new NegocioException("El id es null");
        }
        
        return this.empleadoDAO.consultarPorId(id);
    }
    
    
}
