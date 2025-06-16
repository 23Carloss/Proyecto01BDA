/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Adaptadores;

import DTOs.CuentaMoralDTO;
import DTOs.DepartamentoDTO;
import Dominio.CuentaMoral;
import Dominio.Departamento;
import IAdaptadores.IAdaptadorCuentaMoral;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorDepartamento {
    private IAdaptadorCuentaMoral AdaptadorCuenta;

    private List<CuentaMoralDTO> convertirListaADTO(List<CuentaMoral> listaDominio) throws PersistenciaException{
        List<CuentaMoralDTO> listaDTO = new ArrayList();
        for (CuentaMoral object : listaDominio) {
            listaDTO.add(AdaptadorCuenta.convertirADTO(object));
        }   
        return listaDTO;
       
    }
    private List<CuentaMoral> convertirListaADominio(List<CuentaMoralDTO> listaDTO) throws PersistenciaException{
        List<CuentaMoral> listaDominio = new ArrayList();
        for (CuentaMoralDTO object : listaDTO) {
            listaDominio.add(AdaptadorCuenta.convertirADominio(object));
        }   
        return listaDominio;
    }
}
