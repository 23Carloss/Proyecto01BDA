/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author Sandra
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Conexion calros SistemaPrestamos 552834

public class ConexionBD implements IConexionBD {
    
    private final String SERVER = "127.0.0.1";
    private final String BASE_DATOS = "SistemaPrestamos";
    private final String CADENA_CONEXION = "jdbc:mysql://" + SERVER + "/" + BASE_DATOS;
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "552834";
    
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
        return conexion;
    }
    
}
