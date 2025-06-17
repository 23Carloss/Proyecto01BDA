/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import BOs.EmpleadoBO;
import BOs.IEmpleadoBO;
import BOs.NegocioException;
import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import java.util.List;
import Persistencia.ConexionBD;
import persistencia.EmpleadoDAO;
import Persistencia.IConexionBD;
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
    public RegistrarEmpleadoDTO consultarPorId(String id) throws NegocioException{
        System.out.println("desde facade: " + empleadoNegocio.consultarPorId(id).toString());
        return this.empleadoNegocio.consultarPorId(id);
    }



    @Override
    public List<RegistrarEmpleadoDTO> consultarEmpleadoPorJefe(String idJefe) throws NegocioException {
        return this.empleadoNegocio.consultarEmpleadosPorJefe(idJefe);
    
    }

    @Override
    public RegistrarEmpleadoDTO registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) throws NegocioException {
        return this.empleadoNegocio.registrarEmpleado(nuevoEmpleado);
    }

    @Override
    public List<DepartamentoDTO> consultarDepartamentos() throws NegocioException {
        return this.empleadoNegocio.consultarDepartamentos();
    }

    @Override
    public int eliminarEmpleado(String id) throws NegocioException {
        return empleadoNegocio.eliminarEmpleado(id);
    }
    
    
    
    
}
