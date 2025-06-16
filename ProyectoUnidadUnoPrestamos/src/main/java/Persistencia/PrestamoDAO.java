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

    /**
     * Registra un nuevo prestamo en la base de datos
     *
     * @param p Objeto prestamo con los datos del prestamo
     * @return True si el prestamo se registro correctamente, false en caso
     * contrario
     */
    public int registrarPrestamo(PrestamoDTO p) {
        String sql = "{CALL registrar_prestamo(?, ?, ?, ?, ?, ?, ?)}";
        return 0;
        /**
         * Obtiene todos los prestamos del sistema
         *
         * @return Lista de prestamos
         */

    }

    public List<PrestamoDTO> obtenerTodosPrestamos() {
        List<PrestamoDTO> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";

        return prestamos;
    }
}
