/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class Prestamo {

    private int id;
    private Double adeudo;

    public Prestamo(int id, Double adeudo) {
        this.id = id;
        this.adeudo = adeudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(Double adeudo) {
        this.adeudo = adeudo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", adeudo=" + adeudo + '}';
    }

}
