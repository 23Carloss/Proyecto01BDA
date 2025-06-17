/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author jalt2
 */
public interface IEmpleadoDAO {
    public Empleado consultarPorId(String id)throws PersistenciaException;
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe)throws PersistenciaException;
    public Empleado registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado)throws PersistenciaException;
    public List<DepartamentoDTO> consultarDepartamentos()throws PersistenciaException;
    public int eliminarEmpleado(String id)throws PersistenciaException;
}
