/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOs.DepartamentoDTO;
import Dominio.CuentaMoral;
import Dominio.Departamento;
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
public class DepartamentoDAO implements IDepartamentoDAO {
    private final IConexionBD conexionBD;
    
    public DepartamentoDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    @Override
    public List<DepartamentoDTO> consultarTodos() throws PersistenciaException {
        String query = """
            SELECT d.nombre AS nombreDepartamento, cm.saldoPresupuestal, 
                   cm.clabeMoral, cm.nombreBanco
            FROM Departamento d
            JOIN CuentaMoral cm ON d.clabeMoral = cm.clabeMoral;
        """;

        List<DepartamentoDTO> lista = new ArrayList<>();

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombreDepartamento");
                String saldoPresupuesto = rs.getString("saldoPresupuestal");

                CuentaMoral cuenta = new CuentaMoral(
                    rs.getString("clabeMoral"),
                    rs.getString("saldoPresupuestal"),
                    rs.getString("nombreBanco")
                );

                List<CuentaMoral> listaMoral = new ArrayList<>();
                listaMoral.add(cuenta);

                DepartamentoDTO dto = new DepartamentoDTO(nombre, saldoPresupuesto, listaMoral);
                lista.add(dto);
            }

            return lista;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar departamentos extendidos: " + ex.getMessage(), ex);
        }
    }
    
}
