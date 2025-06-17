package Persistencia;

import DTOs.PrestamoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $$Jonathan
 */
/**
 * Clase DAO para mejorar operaciones relacionadas con prestamos en la base de
 * datos
 */
public class PrestamoDAO {

    private final IConexionBD conexion;

    public PrestamoDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Registra un nuevo prestamo en la base de datos
     *
     * @param p Objeto prestamo con los datos del prestamo
     * @return ID del prestamo registrado
     * @throws PersistenciaException si ocurre un error al registrar
     */
    public int registrarPrestamo(PrestamoDTO p) throws PersistenciaException {
        String sql = "{CALL registrar_prestamo(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection conn = conexion.crearConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setDouble(1, p.getAdeudo());

            stmt.execute();

            try (ResultSet rs = stmt.getResultSet()) {
                if (rs.next()) {
                    return rs.getInt(1); //retorna el id del prestamo
                }
            }

            throw new PersistenciaException("No se pudo registrar el prestamo");

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al registrar prestamo: " + ex.getMessage());
        }
    }

    /**
     * Obtiene todos los prestamos del sistema
     *
     * @return Lista de prestamos
     * @throws PersistenciaException si ocurre un error al consultar
     */
    public List<PrestamoDTO> obtenerTodosPrestamos() throws PersistenciaException {
        List<PrestamoDTO> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";

        try (Connection conn = conexion.crearConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PrestamoDTO prestamo = new PrestamoDTO();
                prestamo.setAdeudo(rs.getDouble("adeudo"));

                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener prestamos: " + ex.getMessage());
        }

        return prestamos;
    }

    /**
     * Obtiene los prestamos de un empleado especifico
     *
     * @param idEmpleado ID del empleado
     * @return Lista de prestamos del empleado
     * @throws PersistenciaException si ocurre un error al consultar
     */
    public List<PrestamoDTO> obtenerPrestamosPorEmpleado(int idEmpleado) throws PersistenciaException {
        List<PrestamoDTO> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos WHERE id_empleado = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmpleado);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PrestamoDTO prestamo = new PrestamoDTO();
                    prestamo.setAdeudo(rs.getDouble("adeudo"));

                    prestamos.add(prestamo);
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener prestamos del empleado: " + ex.getMessage());
        }

        return prestamos;
    }

    /**
     * Actualiza el estado de un prEstamo
     *
     * @param idPrestamo ID del prestamo
     * @param nuevoEstado Nuevo estado del prEstamo
     * @return true si se actualizO correctamente
     * @throws PersistenciaException si ocurre un error
     */
    public boolean actualizarEstadoPrestamo(int idPrestamo, String nuevoEstado) throws PersistenciaException {
        String sql = "UPDATE prestamos SET estado = ? WHERE id_prestamo = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, idPrestamo);

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al actualizar estado del prestamo: " + ex.getMessage());
        }
    }
}
