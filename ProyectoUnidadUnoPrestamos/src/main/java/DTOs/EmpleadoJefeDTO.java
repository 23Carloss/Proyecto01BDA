/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class EmpleadoJefeDTO {
    private String id;
    private String nombre;
    private String apelldoPaterno;
    private String apelldoMaterno;
    private DepartamentoDTO departamento;
   

    public EmpleadoJefeDTO() {
    }

    public EmpleadoJefeDTO(String id, String nombre, String apelldoPatero,String apelldoMatero, DepartamentoDTO departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apelldoPaterno = apelldoPatero;
        this.apelldoMaterno = apelldoMatero;
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelldoPaterno() {
        return apelldoPaterno;
    }

    public void setApelldoPaterno(String apelldoPaterno) {
        this.apelldoPaterno = apelldoPaterno;
    }

    public String getapelldoMaterno() {
        return apelldoMaterno;
    }

    public void setapelldoMaterno(String apelldoMatero) {
        this.apelldoMaterno = apelldoMatero;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "JefeEmpleadoDTO{" + "id=" + id + ", nombre=" + nombre + ", apelldoPatero=" + apelldoPaterno + ", apelldoMatero=" + apelldoMaterno + ", departamento=" + departamento + '}';
    }
    
    
}
