/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import IAdaptadores.IAdaptadorEmpleado;
import Persistencia.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalt2
 */
public class EmpleadoDAO implements IEmpleadoDAO{
    private IConexionBD conexion;
    private IAdaptadorEmpleado AdaptadorEmpleado;

    public EmpleadoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
//    Aqui los metodos de esta DAO


    
    public Empleado consultarPorId(int id) throws PersistenciaException {
            try{
            Connection conexion = this.conexion.crearConexion();
            String comando = """
                             select id_Alumno, nombre, ApellidoPaterno, ApellidoMaterno, estaActivo, estaEliminado
                             from Alumnos 
                             where id_Alumno = ?;
                             """;
            PreparedStatement preparedStatement = conexion.prepareStatement(comando);
            preparedStatement.setInt(1, id); // no entiendo que hace esta linea especifiamente
            
            ResultSet resultSet = preparedStatement.executeQuery();
            Empleado EmpleadoEncontrado = null;
            while(resultSet.next()){ // que hace esta linea de codigo? Va consultando los registros de la tabla?
                EmpleadoEncontrado = ConvertirADominio(resultSet);
            }
            
            resultSet.close();
            preparedStatement.close();
            conexion.close();
            
            if(EmpleadoEncontrado == null){
                throw new PersistenciaException("Error al busar alumno con id:  " + id);
            }
            return EmpleadoEncontrado;
        }catch(SQLException ex){
            throw new PersistenciaException("Error al buscar el alumno:  " + ex.getMessage());
        }
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

    @Override
    public Empleado consultarPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
