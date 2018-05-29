/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;
import modeloJPA.Usuario;

/**
 *
 * @author licontrex
 */
@Local
public interface EditarUsuario {
    
    public List<Usuario>getUsuarios();
    public String modificarDatosUsuario(Usuario usu) throws CuentaRepetidaException;
    public Usuario getUser();
    public void setUser(Usuario us);
    
}
