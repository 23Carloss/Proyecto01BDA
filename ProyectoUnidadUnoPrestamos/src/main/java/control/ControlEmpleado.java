/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.NegocioException;
import DTOs.EmpleadoDTO;
import facade.EmpleadoFacade;
import presentacion.AdministrarEmpleados;
import presentacion.AdministrarPrestamos;
import presentacion.AdministrarSubordinados;
import presentacion.Login;
import presentacion.MenuJefe;

/**
 *
 * @author jalt2
 */
public class ControlEmpleado {
    private MenuJefe frmMenuJefe;
    private AdministrarSubordinados frmSubordinados;
    private AdministrarEmpleados frmEmpleados;
    private AdministrarPrestamos frmPrestamos;

    public ControlEmpleado() {
    }
    
    
    
    public boolean iniciarSesion(String id, String password) throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        EmpleadoDTO empleadoActual = facade.consultarPorId(id);
        
        if (empleadoActual.getPassword().equals(password) && empleadoActual.getTipo().equals("Jefe")) {
            this.iniciarMenuJefe();
            return true;
        }
        return false;
        
    }
    
    public void iniciarMenuJefe(){
        this.frmMenuJefe = new MenuJefe(this);
        this.frmMenuJefe.setVisible(true);
        this.frmMenuJefe.setLocationRelativeTo(null);
    }
    
    public void iniciarFrmSubordinados(){
        this.frmSubordinados = new AdministrarSubordinados(this);
        this.frmSubordinados.setVisible(true);
        this.frmSubordinados.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();
        
    }
    
    public void iniciarFrmEmpleados(){
        this.frmEmpleados = new AdministrarEmpleados(this);
        this.frmEmpleados.setVisible(true);
        this.frmEmpleados.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();

    }
    
    public void iniciarFrmPrestamos(){
        this.frmPrestamos = new AdministrarPrestamos(this);
        this.frmPrestamos.setVisible(true);
        this.frmPrestamos.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();

    }
}
