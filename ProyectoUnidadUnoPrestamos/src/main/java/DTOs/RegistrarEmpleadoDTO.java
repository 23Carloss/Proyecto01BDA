/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class RegistrarEmpleadoDTO {
    private String id;
    private String Nombre, ApellidoPaterno,ApellidoMaterno;
    private String password;
    private String tipo;
    private String usuario;
    private DepartamentoDTO departamento;
    private EmpleadoJefeDTO Jefe;
    private List<CuentaFisicaDTO> listaCuentas;

    public RegistrarEmpleadoDTO() {
    }

    public RegistrarEmpleadoDTO(String Nombre, String ApellidoPaterno, String ApellidoMaterno,String password,String tipo, String usuario, DepartamentoDTO departamento, EmpleadoJefeDTO jefe) {
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.password = password;
        this.tipo = tipo;
        this.usuario =  usuario;
        this.departamento = departamento;
        this.Jefe = jefe;
    }

    public RegistrarEmpleadoDTO(String id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String password, String tipo, DepartamentoDTO departamento,String usuario) {
        this.id = id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.password = password;
        this.usuario = usuario;
        this.tipo = tipo;
        this.departamento = departamento;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public EmpleadoJefeDTO getJefe() {
        return Jefe;
    }

    public void setJefe(EmpleadoJefeDTO Jefe) {
        this.Jefe = Jefe;
    }

    public List<CuentaFisicaDTO> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<CuentaFisicaDTO> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    @Override
    public String toString() {
        return "RegistrarEmpleadoDTO{" + "id=" + id + ", Nombre=" + Nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", password=" + password + ", tipo=" + tipo + ", usuario=" + usuario + ", departamento=" + departamento + ", Jefe=" + Jefe + ", listaCuentas=" + listaCuentas + '}';
    }

   
    
    
    
  
    

}
