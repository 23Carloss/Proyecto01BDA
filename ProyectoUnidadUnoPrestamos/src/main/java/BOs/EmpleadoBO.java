/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Adaptadores.AdaptadorEmpleado;
import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import IAdaptadores.IAdaptadorEmpleado;
import Persistencia.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.IEmpleadoDAO;

/**
 * @author jalt2 
 */
public class EmpleadoBO implements IEmpleadoBO {
    
    private IEmpleadoDAO empleadoDAO;
    private IAdaptadorEmpleado adapter;

    
    public EmpleadoBO(IEmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
        this.adapter = new AdaptadorEmpleado();
    }

    @Override
    public RegistrarEmpleadoDTO consultarPorId(String id) throws NegocioException{
        System.out.println("Entra a la BO??");
        if (id == null) {
            throw new NegocioException("El id es null");
        }
        try {
            System.out.println("Llega aqui al picarle al bton sesion?BOOOOO");
            
            return adapter.convertirADTORegistrar(this.empleadoDAO.consultarPorId(id));
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar Empleado: "+ ex.getMessage());
        }
         
    }

    @Override
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe) {
//        return this.empleadoDAO.consultarEmpleadosPorJefe(idJefe);
        throw new UnsupportedOperationException();
    }

    @Override
    public RegistrarEmpleadoDTO registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) throws NegocioException {
        
        try {
            if (nuevoEmpleado == null) {
                throw new NegocioException("El id es null");
            }
            return adapter.convertirADTORegistrar(this.empleadoDAO.registrarEmpleado(nuevoEmpleado));
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar Empleado: "+ ex.getMessage());
        }
    }

    @Override
    public List<DepartamentoDTO> consultarDepartamentos() throws NegocioException {
        try {
            return empleadoDAO.consultarDepartamentos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar Empleado: "+ ex.getMessage());
        }
    }

    @Override
    public int eliminarEmpleado(String id) throws NegocioException {
        try {
            return empleadoDAO.eliminarEmpleado(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar Empleado: "+ ex.getMessage());
        }
    }
    
    
}
