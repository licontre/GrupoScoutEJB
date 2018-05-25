/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.Local;
import modeloJPA.Usuario;

@Local
public interface InfoSession {
    
    public String validarUsuario(String correo, String passwd)throws ContrasenaIncorrectaException, CuentaInexistenteException;
    public Usuario getUsuario();
}
