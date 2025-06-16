/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import BOs.EmpleadoBO;
import BOs.IEmpleadoBO;
import BOs.NegocioException;
import DTOs.EmpleadoDTO;
import persistencia.ConexionBD;
import persistencia.EmpleadoDAO;
import persistencia.IConexionBD;
import persistencia.IEmpleadoDAO;

/**
 *
 * @author jalt2
 */
public class EmpleadoFacade implements IEmpleadoFacade{
    private IEmpleadoBO empleadoNegocio;

    public EmpleadoFacade() {
        IConexionBD conexion = new ConexionBD();
        IEmpleadoDAO empleadoDAO = new EmpleadoDAO(conexion);
        this.empleadoNegocio = new EmpleadoBO(empleadoDAO);
        
    }

    @Override
    public EmpleadoDTO consultarPorId(String id) throws NegocioException{
        return this.empleadoNegocio.consultarPorId(id);
    }
    
    
    
    
}
