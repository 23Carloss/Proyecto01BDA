/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Empleado {
    private String id;
    private String Nombre, ApellidoPaterno,ApellidoMaterno;
    private String password;
    private String usuario;
    private String tipo;
    private Departamento departamento;
    private Boolean estaActivo; 
    private List<CuentaFisica> listaCuenta ;

    
    public Empleado() {
    }

    
    public Empleado(String id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String password, String tipo, 
                        Departamento departamento, Boolean estaActivo,
                        String usuario) {
        this.id = id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.password = password;
        this.tipo = tipo;
        this.departamento = departamento;
        this.estaActivo =  estaActivo;
        this.usuario =  usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public List<CuentaFisica> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<CuentaFisica> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", Nombre=" + Nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", password=" + password + ", usuario=" + usuario + ", tipo=" + tipo + ", departamento=" + departamento + ", estaActivo=" + estaActivo + ", listaCuenta=" + listaCuenta + '}';
    }

    
}
