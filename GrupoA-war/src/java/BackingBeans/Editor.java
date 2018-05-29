/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBeans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modeloJPA.Usuario;
import negocio.CuentaRepetidaException;
import negocio.EditarUsuario;

/**
 *
 * @author licontrex
 */
@Named(value = "editor")
@ApplicationScoped
public class Editor implements Serializable {
    @EJB
    private EditarUsuario editor;
    private List<Usuario> usuarios;
    private Usuario user;
    private String dia;
    private String mes;
    private String anio;
    private String cargo;
    
    /**
     *
     * @return
     */
    public List<Usuario> getUsuarios(){
        
        usuarios = editor.getUsuarios();        
        return usuarios;
    }
    public void setUsuarios(List<Usuario> u){
        this.usuarios = u;
    }
    public Usuario getUser(){
        return user;
    }
    public void setUser(Usuario u){
        editor.setUser(u);
        this.user = u;
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
     * @return the anoi
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anoi the anoi to set
     */
    public void setAnio(String anoi) {
        this.anio = anoi;
    }
    public String editado(){
        try {
            this.setUser(user);
            return this.modificar();
        } catch (CuentaRepetidaException | ParseException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public String modificar() throws CuentaRepetidaException, ParseException{
         
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        if((anio!=null&&mes!=null&&dia!=null)&&(anio!="2011"||mes!="01"||dia!="01")){
            Date fe = sm.parse(getAnio()+"-"+getMes()+"-"+getDia());
            user.setFechanacimiento(fe);
        }
        if(cargo!=null){
            switch (cargo) {
                case "SECRETARIA":
                    user.setCargo(Usuario.Cargo.SECRETARIA);
                    break;
                case "MONITOR":
                    user.setCargo(Usuario.Cargo.MONITOR);
                    break;
                case "SCOUTER":
                    user.setCargo(Usuario.Cargo.SCOUTER);
                    break;
                case "CLAN":
                    user.setCargo(Usuario.Cargo.CLAN);
                    break;
                case "UNIDAD":
                    user.setCargo(Usuario.Cargo.UNIDAD);
                    break;
                case "TROPA":
                    user.setCargo(Usuario.Cargo.TROPA);
                    break;
                case "MANADA":
                    user.setCargo(Usuario.Cargo.MANADA);
                    break;
                case "CASTORES":
                    user.setCargo(Usuario.Cargo.CASTORES);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Modificando "+user.getEmail());
        return editor.modificarDatosUsuario(user);
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
