/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Dominio.CuentaFisica;
import java.util.List;

/**
 *
 * @author Sandra
 */
public interface ICuentaFisicaDAO {
    
    CuentaFisica consultarPorClabe(String clabe) throws PersistenciaException;
    
}
