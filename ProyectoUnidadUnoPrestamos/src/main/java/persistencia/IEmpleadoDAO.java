/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import DTOs.DepartamentoDTO;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import java.util.List;

/**
 *
 * @author jalt2
 */
public interface IEmpleadoDAO {

    
public Empleado consultarPorId(String id);
    public List<RegistrarEmpleadoDTO> consultarEmpleadosPorJefe(String idJefe);
    public Empleado registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado);
    public List<DepartamentoDTO> consultarDepartamentos();
    public int eliminarEmpleado(String id);
}
