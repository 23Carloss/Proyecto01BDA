/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import DTOs.EmpleadoDTO;

/**
 *
 * @author jalt2
 */
public interface IEmpleadoDAO {
    public EmpleadoDTO consultarPorId(String id);
}
