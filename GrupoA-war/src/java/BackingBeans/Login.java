package BackingBeans;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import negocio.Negocio;

/**
 *
 * @author PC
 */
@Named(value = "login")
@SessionScoped
public class Login implements Controlador, Serializable {
    
    @Inject
    private Negocio negocio;
    
    private String usuario;
    private String password;
    private List<Usuario> usuarios;
    
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
        this.usuario = null;
        this.password = null;
        this.ctrl = null;
    }
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String autenticar() {
               
        Iterator<Usuario> it = getUsuarios().iterator();
        Usuario aux =null;
        boolean find = false;
        String cad=null;
        if(usuario==null){
            return "login.xhtml";
        }
        do{
            aux = it.next();
            if(aux.getNombreusuario().equals(getUsuario()))
                find = true;            
        }while(it.hasNext() && !find);
        FacesContext ctx = FacesContext.getCurrentInstance();
        System.out.println("------------------------------------------------");
        System.out.println("usuario: "+aux.getNombreusuario());
        System.out.println("pass: "+aux.getPassword());
        System.out.println("------------------------------------------------");
        if(!find)
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", "El usuario no existe"));
        else if(!aux.getPassword().equals(password))
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña es incorrecta","La contraseña es incorrecta"));
        
        else{
            
            getCtrl().setUsuario(aux);
            cad=getCtrl().home();
        }
        
        return cad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.autenticar();
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