/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Dominio.CuentaMoral;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandra
 */
public class CuentaMoralDAO implements ICuentaMoralDAO {

    private final IConexionBD conexionBD;

    public CuentaMoralDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public CuentaMoral consultarPorClabe(String clabe) throws PersistenciaException {
        String cuentaMoral = """
                             SELECT clabeMoral, saldoPresupuestal, nombreBanco
                             FROM CuentaMoral
                             WHERE clabeMoral = ?;
                             """;
        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(cuentaMoral)) {

            stmt.setString(1, clabe);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                CuentaMoral cuenta = new CuentaMoral();
                cuenta.setNumeroCuenta(rs.getString("clabeMoral"));
                cuenta.setSaldoPresupuesto(rs.getBigDecimal("saldoPresupuestal").toPlainString());
                cuenta.setNombrebanco(rs.getString("nombreBanco"));
                return cuenta;
            } else {
                throw new PersistenciaException("No se encontró la cuenta moral con clabe: " + clabe);
            }

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar cuenta moral: " + ex.getMessage(), ex);
        }

    }

    public boolean actualizarSaldo(String clabe, BigDecimal nuevoSaldo) throws PersistenciaException {
        String update = """
                        UPDATE CuentaMoral
                        SET saldoPresupuestal = ?
                        WHERE clabeMoral = ?;
                        """;

        try (Connection conexion = conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(update)) {
            stmt.setBigDecimal(1, nuevoSaldo);
            stmt.setString(2, clabe);

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al actualizar saldo: " + ex.getMessage(), ex);
        }
    }
    
//    public List<CuentaMoral> consultarTodas() throws PersistenciaException {
//        String query = """
//            SELECT clabeMoral, saldoPresupuestal, nombreBanco
//            FROM CuentaMoral;
//        """;
//
//        List<CuentaMoral> lista = new ArrayList<>();
//
//        try (Connection conexion = conexionBD.crearConexion();
//             PreparedStatement stmt = conexion.prepareStatement(query);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                CuentaMoral cuenta = new CuentaMoral();
//                cuenta.setNumeroCuenta(rs.getString("clabeMoral"));
//                cuenta.setSaldoPresupuesto(rs.getBigDecimal("saldoPresupuestal").toPlainString());
//                cuenta.setNombrebanco(rs.getString("nombreBanco"));
//                lista.add(cuenta);
//            }
//
//            return lista;
//
//        } catch (SQLException ex) {
//            throw new PersistenciaException("Error al consultar cuentas morales: " + ex.getMessage(), ex);
//        }
//    }
}
