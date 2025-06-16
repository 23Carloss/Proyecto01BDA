/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adaptadores;

import DTOs.EliminarEmpleadoDTO;
import DTOs.EmpleadoJefeDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import IAdaptadores.IAdaptadorEmpleado;
import Persistencia.PersistenciaException;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorEmpleado implements IAdaptadorEmpleado{

    @Override
    public Empleado convertirADominioRegistrar(RegistrarEmpleadoDTO empleado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado converirADominioEliminar(EliminarEmpleadoDTO empleado) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado convertADominioJefe(EmpleadoJefeDTO jefe) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado convertirADominioRegistrar(RegistrarEmpleadoDTO empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         Empleado empleadoDominio = new Empleado(empleado.getId(), 
                empleado.getNombre(), 
                empleado.getApellidoPaterno(), 
                empleado.getApellidoMaterno(), 
                empleado.getPassword(),
                empleado.getTipo(),
                empleado.getDepartamento());
         return empleadoDominio;
    }

    @Override
    public Empleado converirADominioEliminar(EliminarEmpleadoDTO empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         Empleado empleadoDominio = new Empleado(
                 empleado.getId(), 
                 empleado.getNombre(), 
                 empleado.getApellidoPaterno(), 
                 empleado.getApellidoMaterno(), 
                 empleado.getPassword(),
                 empleado.getTipo());
            empleadoDominio.setNombre(empleado.getId()); 
            empleadoDominio.setApellidoPaterno(empleado.getId()); 
            empleadoDominio.setApellidoMaterno(empleado.getId()); 
            empleadoDominio.setPassword(empleado.getId()); 
            empleadoDominio.setUsuario(empleado.getUsuario());
            empleadoDominio.setDepartamento(empleado.getDepartamento());
            empleadoDominio.setTipo(empleado.get)); 
                
         return empleadoDominio;
    }


    @Override
    public Empleado convertADominioJefe(EmpleadoJefeDTO jefe) throws PersistenciaException{
       if(jefe == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         Empleado empleadoDominio = new Empleado();
            empleadoDominio.setNombre(jefe.getId()); 
            empleadoDominio.setApellidoPaterno(jefe.getId()); 
            empleadoDominio.setApellidoMaterno(jefe.getId()); 
            empleadoDominio.setPassword(jefe.getId()); 
            empleadoDominio.set(jefe.getId()); 
                jefe.getNombre(), 
                jefe.getApelldoPaterno(), 
                jefe.getapelldoMaterno(), 
                jefe.getDepartamento();
         return empleadoDominio;
    
    }
//    
}
