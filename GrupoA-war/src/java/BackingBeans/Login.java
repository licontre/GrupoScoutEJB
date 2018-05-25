package BackingBeans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.*;
import modeloJPA.Usuario;
import modeloJPA.Usuario.Cargo;
import negocio.ContrasenaIncorrectaException;
import negocio.CuentaInexistenteException;
import negocio.InfoSession;
import negocio.Negocio;

/**
 *
 * @author PC
 */
@Named(value = "login")
@SessionScoped
public class Login implements Controlador, Serializable {
    
    @Inject
    private InfoSession info;
    
    private String correo;
    private String password;
    private List<Usuario> usuarios;
    private Usuario user;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    public Login(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("castor", "castor", Cargo.CASTORES,"Juanito","Dominguez"));
        usuarios.add(new Usuario("monitor", "monitor", Cargo.MONITOR,"Caroline","Ho"));
        usuarios.add(new Usuario("admin", "admin", Cargo.SECRETARIA,"Luis","Castillo"));
        usuarios.add(new Usuario("secretaria", "secretaria", Cargo.SECRETARIA,"Pepe","Wilfred"));
    }
    public void reset(){
        this.correo = null;
        this.password = null;
        this.ctrl = null;
    }
    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setCorreo(String usuario) {
        this.correo = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String autenticar() throws ContrasenaIncorrectaException, CuentaInexistenteException {
        System.out.println("Pasara");
        String res =info.validarUsuario(correo, password);
        this.user = info.getUsuario();
        System.out.println(user.getEmail());
        System.out.println(user.getNombre());
        System.out.println(user.getContrasenia());
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.autenticar();
        } catch (ContrasenaIncorrectaException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CuentaInexistenteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the ctrl
     */
    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    /**
     * @param ctrl the ctrl to set
     */
    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
}