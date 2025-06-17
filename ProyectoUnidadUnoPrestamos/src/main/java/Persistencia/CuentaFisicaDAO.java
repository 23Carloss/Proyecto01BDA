/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.CuentaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sandra
 */
public class CuentaFisicaDAO implements ICuentaFisicaDAO{
    private final IConexionBD conexionBD;
    
    public CuentaFisicaDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    public CuentaFisica consultarPorClabe(String clabe) throws PersistenciaException {
        String query = """
            SELECT clabeFisica, nombreBanco, estatus
            FROM CuentaFisica
            WHERE clabeFisica = ?;
        """;

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, clabe);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                CuentaFisica cuenta = new CuentaFisica();
                cuenta.setClabe(rs.getString("clabeFisica"));
                cuenta.setNombreBanco(rs.getString("nombreBanco"));
                cuenta.setEstatus(rs.getString("estatus"));
                return cuenta;
            } else {
                throw new PersistenciaException("No se encontró la cuenta física con clabe: " + clabe);
            }

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar cuenta física: " + ex.getMessage(), ex);
        }
    }    
}
