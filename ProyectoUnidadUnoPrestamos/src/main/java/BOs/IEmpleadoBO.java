/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BOs;

import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import java.util.List;

/**
 *
 * @author jalt2
 */
public interface IEmpleadoBO {
    public RegistrarEmpleadoDTO consultarPorId(String id)throws NegocioException;
    
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe);
    
    public RegistrarEmpleadoDTO registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) throws NegocioException;
    public List<DepartamentoDTO> consultarDepartamentos()throws NegocioException;
    public int eliminarEmpleado(String id)throws NegocioException;
}
