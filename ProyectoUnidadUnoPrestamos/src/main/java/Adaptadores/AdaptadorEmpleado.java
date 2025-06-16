/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adaptadores;

import DTOs.EliminarEmpleadoDTO;
import DTOs.EmpleadoJefeDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import IAdaptadores.IAdaptadorDepartamento;
import IAdaptadores.IAdaptadorEmpleado;
import Persistencia.PersistenciaException;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorEmpleado implements IAdaptadorEmpleado{

    private IAdaptadorEmpleado AdapterEmpleado;
    private IAdaptadorDepartamento AdapterDepartamento;


    @Override
    public Empleado convertirADominioRegistrar(RegistrarEmpleadoDTO empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         Empleado empleadoDominio = new Empleado();
         empleadoDominio.setNombre(empleado.getId()); 
         empleadoDominio.setApellidoPaterno(empleado.getNombre()); 
         empleadoDominio.setApellidoMaterno(empleado.getApellidoPaterno()); 
         empleadoDominio.setPassword(empleado.getApellidoMaterno()); 
         empleadoDominio.setDepartamento(AdapterDepartamento.convertirADominio(empleado.getDepartamento()));
         
         return empleadoDominio;
    }

    @Override
    public Empleado converirADominioEliminar(EliminarEmpleadoDTO empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         Empleado empleadoDominio = new Empleado();
         empleadoDominio.setNombre(empleado.getId()); 
         empleadoDominio.setApellidoPaterno(empleado.getNombre()); 
         empleadoDominio.setApellidoMaterno(empleado.getApellidoPaterno()); 
         empleadoDominio.setPassword(empleado.getApellidoMaterno()); 
         empleadoDominio.setDepartamento(AdapterDepartamento.convertirADominio(empleado.getDepartamento()));
         
         return empleadoDominio;
        }
    

   

    @Override
    public RegistrarEmpleadoDTO convertirADTORegistrar(Empleado empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         RegistrarEmpleadoDTO empleadoDTO = new RegistrarEmpleadoDTO();
         empleado.setId(empleado.getId());
         empleadoDTO.setNombre(empleado.getNombre()); 
         empleadoDTO.setApellidoPaterno(empleado.getApellidoPaterno()); 
         empleadoDTO.setApellidoMaterno(empleado.getApellidoMaterno()); 
         empleadoDTO.setPassword(empleado.getApellidoMaterno()); // una DTO no debe tener la contraseña
         empleadoDTO.setDepartamento(AdapterDepartamento.convertirADTO(empleado.getDepartamento()));
         
         return empleadoDTO;
        }
    

    @Override
    public EliminarEmpleadoDTO converirADTOEliminar(Empleado empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         EliminarEmpleadoDTO empleadoDTO = new EliminarEmpleadoDTO();
         empleadoDTO.setId(empleado.getId());
         empleadoDTO.setNombre(empleado.getNombre()); 
         empleadoDTO.setApellidoPaterno(empleado.getApellidoPaterno()); 
         empleadoDTO.setApellidoMaterno(empleado.getApellidoMaterno()); 
         empleadoDTO.setPassword(empleado.getApellidoMaterno()); // una DTO no debe tener la contraseña
         empleadoDTO.setDepartamento(AdapterDepartamento.convertirADTO(empleado.getDepartamento()));
         
         return empleadoDTO;
        }
    
    @Override
    public EmpleadoJefeDTO convertirADTOJefe(Empleado jefe) throws PersistenciaException {
       if(jefe == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         EmpleadoJefeDTO JefeDTO = new EmpleadoJefeDTO();
         JefeDTO.setId(jefe.getId());
         JefeDTO.setNombre(jefe.getNombre()); 
         JefeDTO.setApelldoPaterno(jefe.getApellidoPaterno()); 
         JefeDTO.setapelldoMaterno(jefe.getApellidoMaterno()); 
         //JefeDTO.setPassword(jefe.getApellidoMaterno()); // una DTO no debe tener la contraseña
         JefeDTO.setDepartamento(AdapterDepartamento.convertirADTO(jefe.getDepartamento()));
         
         return JefeDTO;
        }

    @Override
    public Empleado convertADominioJefe(EmpleadoJefeDTO jefe) throws PersistenciaException {
        if(jefe == null){
            throw new PersistenciaException("Error al convertir: el parametro es igual a null");
        }
         Empleado JefeDTO = new Empleado();
         JefeDTO.setId(jefe.getId());
         JefeDTO.setNombre(jefe.getNombre()); 
         JefeDTO.setApellidoPaterno(jefe.getApelldoPaterno()); 
         JefeDTO.setApellidoMaterno(jefe.getapelldoMaterno()); 
         //JefeDTO.setPassword(jefe.getApellidoMaterno()); // una DTO no debe tener la contraseña
         JefeDTO.setDepartamento(AdapterDepartamento.convertirADominio(jefe.getDepartamento()));
         
         return JefeDTO;
        }

 
}

