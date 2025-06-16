/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author jalt2
 */
public class EliminarEmpleadoDTO {
    private String id;
    private String Nombre, ApellidoPaterno,ApellidoMaterno;
    private String password;
    private String usuario;
    private String tipo;
    private DepartamentoDTO departamento;

    public EliminarEmpleadoDTO() {
    }

    public EliminarEmpleadoDTO(String id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, DepartamentoDTO departamento) {
        this.id = id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.departamento = departamento;
    }

    public EliminarEmpleadoDTO(String id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String password, String tipo, DepartamentoDTO departamento) {
        this.id = id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.password = password;
        this.tipo = tipo;
        this.departamento = departamento;
    }
    
     public EliminarEmpleadoDTO(String id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String password, String usuario, String tipo, DepartamentoDTO departamento) {
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

    @Override
    public String toString() {
        return "EliminarEmpleadoDTO{" + "id=" + id + ", Nombre=" + Nombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", password=" + password + ", usuario=" + usuario + ", tipo=" + tipo + ", departamento=" + departamento + '}';
    }

   
    
    
}
