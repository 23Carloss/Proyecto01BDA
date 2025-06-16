/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.NegocioException;
import DTOs.EmpleadoDTO;
import facade.EmpleadoFacade;
import presentacion.AdministrarPrestamos;
import presentacion.AgregarEmpleado;
import presentacion.AgregarSubordinado;
import presentacion.EliminarEmpleado;
import presentacion.EliminarSubordinado;
import presentacion.Login;
import presentacion.MenuJefe;
import presentacion.ModificarEmpleado;
import presentacion.MostrarEmpleados;

/**
 *
 * @author jalt2
 */
public class ControlEmpleado {
    private MenuJefe frmMenuJefe;
    private AgregarSubordinado frmAgregarSubordinado;
    private EliminarSubordinado frmEliminarSubordinado;
    private AgregarEmpleado frmAgregarEmpleado;
    private EliminarEmpleado frmEliminarEmpleado;
    private ModificarEmpleado frmModificarEmpleado;
    private MostrarEmpleados frmMostrarEmpleados;
    private AdministrarPrestamos frmPrestamos;
    private Login frmLogin;

    public ControlEmpleado() {
    }
    
    
    /*Este metodo recibe id y contraseña del login y lo compara con lo que hay en la base de datos*/
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
    
    public void iniciarEliminarSubordinado(){
        this.frmEliminarSubordinado = new EliminarSubordinado(this);
        this.frmEliminarSubordinado.setVisible(true);
        this.frmEliminarSubordinado.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();
    }
    
    public void iniciarAgregarSubordinado(){
        this.frmAgregarSubordinado = new AgregarSubordinado(this);
        this.frmAgregarSubordinado.setVisible(true);
        this.frmAgregarSubordinado.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();
    }
    
    
    public void iniciarAgregarEmpleado(){
        frmAgregarEmpleado = new AgregarEmpleado(this);
        frmAgregarEmpleado.setVisible(true);
        frmAgregarEmpleado.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarEliminarEmpleado(){
        frmEliminarEmpleado = new EliminarEmpleado(this);
        frmEliminarEmpleado.setVisible(true);
        frmEliminarEmpleado.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarModificarEmpleado(){
        frmModificarEmpleado = new ModificarEmpleado(this);
        frmModificarEmpleado.setVisible(true);
        frmModificarEmpleado.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarfrmMostrarEmpleados(){
        frmMostrarEmpleados = new MostrarEmpleados(this);
        frmMostrarEmpleados.setVisible(true);
        frmMostrarEmpleados.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarFrmPrestamos(){
        this.frmPrestamos = new AdministrarPrestamos(this);
        this.frmPrestamos.setVisible(true);
        this.frmPrestamos.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();

    }
    
    public void cerrarSesion(){
        this.frmLogin = new Login(this);
        this.frmLogin.setVisible(true);
        this.frmLogin.setLocationRelativeTo(null);
        this.frmMenuJefe.dispose();
    }
}
