/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import BOs.NegocioException;
import DTOs.DepartamentoDTO;
import DTOs.EliminarEmpleadoDTO;
import DTOs.RegistrarEmpleadoDTO;
import DTOs.EmpleadoModificarDTO;
import facade.EmpleadoFacade;
import java.util.List;
import presentacion.AdministrarPrestamos;
import presentacion.RegistrarEmpleado;
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
public class ControlEmpleadoJefe {
    private RegistrarEmpleadoDTO empleadoActual;
    private MenuJefe frmMenuJefe;
    private AgregarSubordinado frmAgregarSubordinado;
    private EliminarSubordinado frmEliminarSubordinado;
    private RegistrarEmpleado frmAgregarEmpleado;
    private EliminarEmpleado frmEliminarEmpleado;
    private ModificarEmpleado frmModificarEmpleado;
    private MostrarEmpleados frmMostrarEmpleados;
    private AdministrarPrestamos frmPrestamos;
    private Login frmLogin;
    private EmpleadoFacade facade; 

    public ControlEmpleadoJefe() {
        facade = new EmpleadoFacade();
    }
    
    
    /*Este metodo recibe id y contraseña del login y lo compara con lo que hay en la base de datos*/
    public boolean iniciarSesion(String id, String password) throws NegocioException{
        
        empleadoActual = facade.consultarPorId(id);
        
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
        frmAgregarEmpleado = new RegistrarEmpleado(this);
        frmAgregarEmpleado.setVisible(true);
        frmAgregarEmpleado.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarEliminarEmpleado() throws NegocioException{
        frmEliminarEmpleado = new EliminarEmpleado(this);
        frmEliminarEmpleado.setVisible(true);
        frmEliminarEmpleado.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarModificarEmpleado() throws NegocioException{
        frmModificarEmpleado = new ModificarEmpleado(this);
        frmModificarEmpleado.setVisible(true);
        frmModificarEmpleado.setLocationRelativeTo(null);
        frmMenuJefe.dispose();
    }
    
    public void iniciarfrmMostrarEmpleados() throws NegocioException{
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
    
    public List<RegistrarEmpleadoDTO> empleadosPorJefe() throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        return facade.consultarEmpleadoPorJefe(empleadoActual.getId());
    }
    
    public List<DepartamentoDTO> consultarDepartamentos() throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        return facade.consultarDepartamentos();
    }
    
    public EmpleadoModificarDTO recuperarEmpleadoModificar(EmpleadoModificarDTO empleadoModificar){
        return empleadoModificar;
    }
    
    public RegistrarEmpleadoDTO registrarEmpleado(RegistrarEmpleadoDTO nuevoEmpleado) throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        return facade.registrarEmpleado(nuevoEmpleado);
    }
    
    public int eliminarEmpleado(String id) throws NegocioException{
        EmpleadoFacade facade = new EmpleadoFacade();
        return facade.eliminarEmpleado(id);
    }
}
