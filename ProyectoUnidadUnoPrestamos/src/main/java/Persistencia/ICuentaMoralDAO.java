/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Dominio.CuentaMoral;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sandra
 */
public interface ICuentaMoralDAO {
    CuentaMoral consultarPorClabe(String clabe) throws PersistenciaException;
    boolean actualizarSaldo(String clabe, BigDecimal nuevoSaldo) throws PersistenciaException;
    
    
}
