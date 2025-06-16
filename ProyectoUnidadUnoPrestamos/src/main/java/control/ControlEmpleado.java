/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.NegocioException;
import DTOs.EmpleadoDTO;
import facade.EmpleadoFacade;
import presentacion.Login;
import presentacion.MenuJefe;

/**
 *
 * @author jalt2
 */
public class ControlEmpleado {
    private MenuJefe frmMenuJefe;
    private Login frmLogin;

    public ControlEmpleado() {
    }
    
    
    
    public boolean iniciarSesion(String id, String password) throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        EmpleadoDTO empleadoActual = facade.consultarPorId(id);
        
        if (empleadoActual.getPassword().equals(password) && empleadoActual.getTipo().equals("Jefe")) {
            this.frmMenuJefe = new MenuJefe();
            this.frmMenuJefe.setVisible(true);
            this.frmMenuJefe.setLocationRelativeTo(null);
            
            return true;
        }
        return false;
        
    }
}
