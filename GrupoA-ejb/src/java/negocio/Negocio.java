/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.Local;
import modeloJPA.Usuario;

@Local
public interface Negocio {
    public void registrarUsuario(Usuario u)throws RegistroException;
    public void validarCuenta(String cuenta, String validacion)throws RegistroException;
    public void compruebaLogin(Usuario u) throws RegistroException;
}
