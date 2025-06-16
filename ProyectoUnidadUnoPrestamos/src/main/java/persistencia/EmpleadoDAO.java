/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import DTOs.EmpleadoDTO;

/**
 *
 * @author jalt2
 */
public class EmpleadoDAO implements IEmpleadoDAO{
    private IConexionBD conexion;

    public EmpleadoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }
    
    //Aqui los metodos de esta DAO

    @Override
    public EmpleadoDTO consultarPorId(String id) {
        //implementacion
        String consulta = """
                          colsultar por id y contraaeña
                          despues comparar la contrseña de la base de datos
                          con la del parametro
                          """;
        
        return new EmpleadoDTO("a","","","123","Jefe");
    }

}
