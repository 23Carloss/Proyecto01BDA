/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import control.ControlEmpleado;
import presentacion.Login;

/**
 *
 * @author jalt2
 */
public class PrestamosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControlEmpleado control = new ControlEmpleado();
        Login login = new Login(control);
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
