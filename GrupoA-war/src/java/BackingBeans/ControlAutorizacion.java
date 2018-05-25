/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import modeloJPA.*;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author francis
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //falta terminarlo de implementar
    public String home() {
        String cad=null;
         if(usuario.getCargo()==Usuario.Cargo.CASTORES){
            cad="inicio.xhtml";
        }else if(usuario.getCargo()==Usuario.Cargo.MONITOR){
            cad="inicioM.xhtml";
        }else if(usuario.getCargo()==Usuario.Cargo.SECRETARIA){
            cad="secretaria.xhtml";
        }else{
            cad="login.xhtml";
        }
        return cad;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        //ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "index.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
