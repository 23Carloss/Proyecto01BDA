/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import BOs.NegocioException;
import DTOs.DepartamentoDTO;
import DTOs.EmpleadoJefeDTO;
import DTOs.RegistrarEmpleadoDTO;
import control.ControlEmpleadoJefe;
import facade.EmpleadoFacade;
import facade.IEmpleadoFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.Login;

/**
 *
 * @author jalt2
 */
public class PrestamosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
        ControlEmpleadoJefe control = new ControlEmpleadoJefe();
        IEmpleadoFacade controlEmpleado = new EmpleadoFacade();
       
        Login login = new Login(control);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        //            List<RegistrarEmpleadoDTO> lista  =  new ArrayList();
        DepartamentoDTO depa1 = new DepartamentoDTO("PrograIV", "233.43");
        EmpleadoJefeDTO jefe1 = new EmpleadoJefeDTO("abc01", "CARLOSS", "CTMJDBC", "", depa1);
        RegistrarEmpleadoDTO carlosss =  new RegistrarEmpleadoDTO("SONLAS2:30", "CTMJDBC$$$", "", "552834", "Empleado", "252724", depa1, jefe1);
        System.out.println("Prueba de q pasa cuando truena con un id qno esta");
        controlEmpleado.consultarPorId("213432");
            controlEmpleado.registrarEmpleado(carlosss);
        } catch (NegocioException ex) {
            System.out.println("Error en el sistema: "+ ex.getLocalizedMessage());
        }
        
//            System.out.println(empleado.toString());
   
       
    }
    
}
