/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import DTOs.CuentaMoralDTO;
import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.CuentaFisica;
import Dominio.CuentaMoral;
import Dominio.Departamento;
import Dominio.Empleado;
import IAdaptadores.IAdaptadorCuentaMoral;
import IAdaptadores.IAdaptadorDepartamento;
import IAdaptadores.IAdaptadorEmpleado;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private IAdaptadorDepartamento AdaptadorDepartamento;
    private IAdaptadorCuentaMoral AdaptadorCuentaMoral;

    public EmpleadoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
//    Aqui los metodos de esta DAO

    @Override
    public Empleado consultarPorId(String id) throws PersistenciaException {
            try{
                
                CuentaMoral cuentaMoral = new CuentaMoral();
                Empleado EmpleadoEncontrado = new Empleado();
                Connection conexion = this.conexion.crearConexion();
                
                String comando = """
                                 select Empleado, nombre, ApellidoPaterno, ApellidoMaterno
                                 from Empleado 
                                 where idEmpleado = ?;
                                 """;

                PreparedStatement preparedStatement = conexion.prepareStatement(comando);
                preparedStatement.setString(0 , id);
                ResultSet resultSet = preparedStatement.executeQuery();
                
               Departamento departamento1 = consultarDepartamentoEmpleado(resultSet.getNString("idDepartamento"));
               
                while(resultSet.next()){ 
                    EmpleadoEncontrado.setId(resultSet.getNString("idEmpleado"));
                    EmpleadoEncontrado.setNombre(resultSet.getNString("nombre"));
                    EmpleadoEncontrado.setApellidoPaterno(resultSet.getNString("apellidoPaternoo"));
                    EmpleadoEncontrado.setApellidoMaterno(resultSet.getNString("apellidoMaterno"));
                    EmpleadoEncontrado.setEstaActivo(resultSet.getBoolean("estaActivo"));
                    EmpleadoEncontrado.setTipo(resultSet.getNString("tipo"));
                    
                    //Listas de las cuentas morales de los Departamento y los Depas
                    departamento1.setlistaMoral(consultarCuentasPorDepartamento(resultSet.getNString("idDepartamento")));
                    EmpleadoEncontrado.setDepartamento(departamento1);
                    

                }
                

                if(EmpleadoEncontrado == null){
                    throw new PersistenciaException("Error al busar empleado con id:  " + id);
                }
                resultSet.close();
                preparedStatement.close();
                conexion.close();
                return EmpleadoEncontrado;
            }catch(SQLException ex){
                throw new PersistenciaException("Error al buscar el empleado:  " + ex.getMessage());
                }
            }
    
    /*Buscar los empleados de los que esta acargo un jefe*/
    @Override
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*Insert*/
    @Override
    public Empleado registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) throws PersistenciaException{
        try {
            
            Empleado empleadoNuevo = new Empleado();
            Connection conexion = this.conexion.crearConexion();
            String comando = """
                            Insert into Empleado(nombre, apellidoPaterno,apellidoPaterno, tipo, usuario, contrasenia)
                            values(?,?,?)
                         """;
            PreparedStatement preparedStatement = conexion.prepareStatement(comando);
            preparedStatement.setString(0, nuevoEmpleado.getNombre());
            preparedStatement.setString(1, nuevoEmpleado.getApellidoPaterno());
            preparedStatement.setString(2, nuevoEmpleado.getApellidoMaterno());  
            int filasAfectadas = preparedStatement.executeUpdate();
            //creamos Empleado
            empleadoNuevo.setNombre(nuevoEmpleado.getNombre());
                empleadoNuevo.setApellidoPaterno(nuevoEmpleado.getNombre());
                empleadoNuevo.setApellidoMaterno(nuevoEmpleado.getNombre());             
                empleadoNuevo.setDepartamento(AdaptadorDepartamento.convertirADominio(nuevoEmpleado.getDepartamento()));
                empleadoNuevo.setTipo(nuevoEmpleado.getTipo());
                empleadoNuevo.setUsuario(nuevoEmpleado.getUsuario());
                empleadoNuevo.setPassword(nuevoEmpleado.getPassword());
            if(filasAfectadas == 0){
                throw new PersistenciaException("Error al insertar el empleado: ");
            }
           
            preparedStatement.close();
            conexion.close();
            return empleadoNuevo;
             }catch (SQLException ex) {
                throw new PersistenciaException("Error al insertar el empleado: "+  ex.getMessage());
            }
        }
        
        
    
    
    /*Consulta de todos los departamentos*/
    @Override
    public List<DepartamentoDTO> consultarDepartamentos() throws PersistenciaException {
        
        try {
            List<DepartamentoDTO> listaResultados =  new ArrayList<>();
            List<CuentaMoralDTO> listaMoral =  new ArrayList<>();
            DepartamentoDTO depa = new DepartamentoDTO();
            Connection conexion = this.conexion.crearConexion();
            String comando = """
                         select nombre as NombreDepartamento, saldoPresupuesto as Presupuesto, clabeMoral as NumCuenta
                         from Departamentos;
                         """;
            PreparedStatement preparedStatement = conexion.prepareStatement(comando);
            ResultSet resultSet = preparedStatement.executeQuery();
            for (CuentaMoral cuenta : consultarCuentasPorDepartamento(resultSet.getNString("clabeMoral"))) {
                    listaMoral.add(AdaptadorCuentaMoral.convertirADTO(cuenta));
            }
            while(resultSet.next()){
                depa.setListaCuentas(listaMoral);
                depa.setNombre(resultSet.getNString("nombre"));
                depa.setSaldoPresupuesto(resultSet.getNString("SaldoPresupuesto"));
                listaResultados.add(depa);
            }
            return listaResultados;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Delete a un empleado*/
    @Override
    public int eliminarEmpleado(String id) throws PersistenciaException {
        try {
            Connection conexion = this.conexion.crearConexion();
            String comando = """
                                     delete from Empleados
                                     where idEmpleado = ?;
                                     """;
            PreparedStatement preparedStatement = conexion.prepareStatement(comando);
            preparedStatement.setString(0, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            if(filasAfectadas == 0){
                throw new PersistenciaException("Error al insertar el empleado: ");
            }
           
            preparedStatement.close();
            conexion.close();
            return filasAfectadas;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al insertar el empleado: " + ex.getMessage());
        }
    }
    

     private List<CuentaMoral> consultarCuentasPorDepartamento(String clabeMoral) throws PersistenciaException{
        try {
            Connection conexion = this.conexion.crearConexion();
            List<CuentaMoral> resultados  = new ArrayList<>();
            CuentaMoral cuentaMoral = new CuentaMoral();
            String consultaCuentaMoral =  """
                                           select SaldoPresupuestal as SaldoCuenta, nombrebanco as Banco
                                           from CuentaMoral
                                           where clabeMoral = ?;
                                           """;
            
            PreparedStatement cuentaMoral1 = conexion.prepareStatement(consultaCuentaMoral);
            cuentaMoral1.setString(0, clabeMoral);
            ResultSet InfoCuenta = cuentaMoral1.executeQuery();
            
            while(InfoCuenta.next()){
                cuentaMoral.setNombrebanco(InfoCuenta.getNString("NombreBanco"));
                cuentaMoral.setNumeroCuenta(InfoCuenta.getNString("clabeMoral"));
                cuentaMoral.setSaldoPresupuesto(InfoCuenta.getNString("cuentaMoral"));
                resultados.add(cuentaMoral);
            }
            return resultados;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar cuentas: "+ ex.getMessage());
        }     
    }
     private List<CuentaFisica> consultarCuentasFisicasPorEmpleado(String clabeFisica) throws PersistenciaException{
        try {
            Connection conexion = this.conexion.crearConexion();
            List<CuentaFisica> resultados  = new ArrayList<>();
            CuentaFisica cuentaFisica = new CuentaFisica();
            String consultaCuentaMoral =  """
                                           select SaldoPresupuestal as SaldoCuenta, nombrebanco as Banco
                                           from ClabeFisica
                                           where clabeFisica = ?;
                                           """;
            
            PreparedStatement cuentaMoral1 = conexion.prepareStatement(consultaCuentaMoral);
            cuentaMoral1.setString(0, clabeFisica);
            ResultSet InfoCuenta = cuentaMoral1.executeQuery();
            
            while(InfoCuenta.next()){
                cuentaFisica.setClabe(InfoCuenta.getNString("clabeFisica"));
                cuentaFisica.setEstatus(InfoCuenta.getNString("estatus"));
                cuentaFisica.setNombreBanco(InfoCuenta.getNString("nombreBanco"));
                resultados.add(cuentaFisica);
            }
            return resultados;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar cuentas: "+ ex.getMessage());
        }     
    }
     
    
    private Departamento consultarDepartamentoEmpleado(String idDepartamento) throws PersistenciaException{
        try {
            Connection conexion = this.conexion.crearConexion();
            Departamento depa = new Departamento();
            String consultaDepartamento =  """
                                               select nombre, clabeMoral
                                               from Departamento
                                               where idDepartamento = ?;
                                               """;
            PreparedStatement departamento = conexion.prepareStatement(consultaDepartamento);
            departamento.setString(0, idDepartamento);
            ResultSet InfoDepartamento = departamento.executeQuery();
            while(InfoDepartamento.next()){
                depa.setNombre(InfoDepartamento.getNString("Nombre"));
                depa.setlistaMoral(consultarCuentasPorDepartamento(InfoDepartamento.getNString("idDepartamento")));
                depa.setSaldoPresupuesto(InfoDepartamento.getNString("cuentaMoral"));
            }
            return depa;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar Departamento: "+ ex.getMessage());
        }      
    }

}