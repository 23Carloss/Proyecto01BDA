/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.NegocioException;
import DTOs.EmpleadoDTO;
import facade.EmpleadoFacade;
import presentacion.MenuJefe;

/**
 *
 * @author jalt2
 */
public class ControlEmpleado {
    private MenuJefe frmMenuJefe;

    public ControlEmpleado() {
    }
    
    
    
    public void iniciarSesion(String id, String password) throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        EmpleadoDTO empleadoActual = facade.consultarPorId(id);
        
        if (empleadoActual.getPassword().equals(password) && empleadoActual.getTipo().equals("Jefe")) {
            this.frmMenuJefe = new MenuJefe();
            this.frmMenuJefe.setVisible(true);
            this.frmMenuJefe.setLocationRelativeTo(null);
        }else{
            throw new NegocioException("Credenciales Incorrectas");
        }
        
    }
}
