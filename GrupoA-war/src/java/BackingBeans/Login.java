package BackingBeans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import negocio.CuentaRepetidaException;
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
    private String anio;
    private String mes;
    private String dia;
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
        this.setUser(info.getUsuario());
        System.out.println(getUser().getEmail());
        System.out.println(getUser().getNombre());
        System.out.println(getUser().getContrasenia());
        return res;
    }
    
    public String modificar() throws CuentaRepetidaException, ParseException{
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        if(anio!="2011"||mes!="01"||dia!="01"){
            Date fe = sm.parse(getAnio()+"-"+getMes()+"-"+getDia());
            user.setFechanacimiento(fe);
        }
        System.out.println("Modificando "+mes);
        return info.modificarDatosUsuario(user);
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

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
}