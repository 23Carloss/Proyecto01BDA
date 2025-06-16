/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTOs;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
class TipoPrestamoDTO {
    private String Tipo;
    private int MaxParcialidades;

    public TipoPrestamoDTO() {
    }

    public TipoPrestamoDTO(String Tipo, int MaxParcialidades) {
        this.Tipo = Tipo;
        this.MaxParcialidades = MaxParcialidades;
    }

    public int getMaxParcialidades() {
        return MaxParcialidades;
    }

    public void setMaxParcialidades(int MaxParcialidades) {
        this.MaxParcialidades = MaxParcialidades;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
}
