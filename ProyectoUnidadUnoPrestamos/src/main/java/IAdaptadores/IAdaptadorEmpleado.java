/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdaptadores;

import DTOs.EliminarEmpleadoDTO;
import DTOs.EmpleadoJefeDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import Persistencia.PersistenciaException;

/**
 *
 * @author HP
 */
public interface IAdaptadorEmpleado {
    public Empleado convertirADominioRegistrar(RegistrarEmpleadoDTO empleado) throws PersistenciaException;
    public Empleado converirADominioEliminar(EliminarEmpleadoDTO empleado)throws PersistenciaException;
    public Empleado convertADominioJefe(EmpleadoJefeDTO jefe)throws PersistenciaException;
    
}
