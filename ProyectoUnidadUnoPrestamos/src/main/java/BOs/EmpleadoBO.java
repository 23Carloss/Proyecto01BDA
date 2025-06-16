/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import java.util.List;
import persistencia.IEmpleadoDAO;

/**
 *
 * @author jalt2 
 */
public class EmpleadoBO implements IEmpleadoBO {
    private IEmpleadoDAO empleadoDAO;

    public EmpleadoBO(IEmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    @Override
    public RegistrarEmpleadoDTO consultarPorId(String id) throws NegocioException{
        if (id == null) {
            throw new NegocioException("El id es null");
        }
        
        return this.empleadoDAO.consultarPorId(id);
    }

    @Override
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe) {
        return this.empleadoDAO.consultarEmpleadosPorJefe(idJefe);
    }

    @Override
    public RegistrarEmpleadoDTO registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) throws NegocioException {
        return empleadoDAO.registrarEmpleado(nuevoEmpleado);
    }

    @Override
    public List<DepartamentoDTO> consultarDepartamentos() throws NegocioException {
        return empleadoDAO.consultarDepartamentos();
    }

    @Override
    public int eliminarEmpleado(String id) throws NegocioException {
        return empleadoDAO.eliminarEmpleado(id);
    }
    
    
}
