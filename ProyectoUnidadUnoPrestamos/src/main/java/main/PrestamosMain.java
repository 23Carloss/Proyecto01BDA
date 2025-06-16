/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import BOs.NegocioException;
import DTOs.RegistrarEmpleadoDTO;
import Dominio.Empleado;
import control.ControlEmpleadoJefe;
import facade.EmpleadoFacade;
import facade.IEmpleadoFacade;
import java.util.ArrayList;
import java.util.List;
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
        try {
            // TODO code application logic here
            ControlEmpleadoJefe control = new ControlEmpleadoJefe();
            IEmpleadoFacade controlEmpleado = new EmpleadoFacade();
            List<RegistrarEmpleadoDTO> lista  =  new ArrayList();
            RegistrarEmpleadoDTO empleado = 
//            Empleado carlos = new Empleado("23", 
//                "Carlos", 
//                "Manjarrez", 
//                "", 
//                "patitoAzul",
//                "Jefe", 
//                "Sistemas"
//        );
//            controlEmpleado.registrarEmpleado(empleado);
            
            //Login login = new Login(control);
//        login.setVisible(true);
//        login.setLocationRelativeTo(null);
            System.out.println(empleado.toString());
        } catch (NegocioException ex) {
            Logger.getLogger(PrestamosMain.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       
    }
    
}
