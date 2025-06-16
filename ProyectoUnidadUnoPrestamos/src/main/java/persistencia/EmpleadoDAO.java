/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import Persistencia.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalt2
 */
public class EmpleadoDAO implements IEmpleadoDAO{
    private IConexionBD conexion;

    public EmpleadoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
//    Aqui los metodos de esta DAO

    @Override
    public Empleado consultarPorId(String id) {
        //implementacion
        String consulta = """
                          colsultar por id y contraaeña
                          despues comparar la contrseña de la base de datos
                          con la del parametro
                          """;
        //mock
        return null;
    }
    
    /*Buscar los empleados de los que esta acargo un jefe*/
    @Override
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*Insert*/
    @Override
    public Empleado registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) {
        if(nuevoEmpleado.getTipo().equals("Jefe")){
           
            String comando = """
                            Insert into Empleado(nombre, apellidoPaterno,apellidoPaterno,)
                            values
                         """;
        }else{
            try {
                throw new PersistenciaException("Error al insertar el empleado.");
            } catch (PersistenciaException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
        
    }
    
    /*Consulta de todos los departamentos*/
    @Override
    public List<DepartamentoDTO> consultarDepartamentos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*Delete a un empleado*/
    @Override
    public int eliminarEmpleado(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
