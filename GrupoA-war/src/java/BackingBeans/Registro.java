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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.management.Query;
import modeloJPA.Usuario;
import modeloJPA.Usuario.Cargo;
import modeloJPA.Usuario.Sexo;
import negocio.*;

/**
 *
 * @author francis
 */
@Named(value = "registro")
@RequestScoped
public class Registro implements Serializable{

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

    //@Inject
    @EJB
    private Negocio negocio;
    private Usuario usuario;
    private String repass;
    private String dia;
    private String mes;
    private String anio;
    private String cuenta;
    private String sexo;
    private String codigoValidacion;
    private String mensajeValidacion;
    private boolean validacionOK;

    private boolean registroOK;

    public boolean isRegistroOK() {
        return registroOK;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public Registro() {
        usuario = new Usuario();
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String registrando() throws ParseException{
        try {
                      
            
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-mm-dd");
            usuario.setId(new Long(145632));
            Date fe = sm.parse(anio+"-"+mes+"-"+dia);
            usuario.setFechanacimiento(fe);
            if(sexo.equals("femenino")){
                this.usuario.setGenero(Sexo.MUJER);
            }else{
                this.usuario.setGenero(Sexo.HOMBRE);
            }
            this.usuario.setCargo(Cargo.CLAN);
            negocio.registrarUsuario(this.usuario);
        } catch (RegistroException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "login.xhtml";
        
    }
    public String registrarUsuario()throws RegistroException {
        try {
            if (!usuario.getContrasenia().equals(repass)) {
                FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
                FacesContext.getCurrentInstance().addMessage("registro:pass2", fm);
                return null;
            }
            negocio.registrarUsuario(usuario);
            registroOK = true;
            return "login.xhtml";
            
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:alias", fm);
            
        }
        return null;
    }

    public String validarCuenta() throws RegistroException{
        try {
            if (cuenta != null && codigoValidacion != null) {
                negocio.validarCuenta(cuenta, codigoValidacion);
            }
            mensajeValidacion = "La validación ha sido correcta, ahora puede acceder con este usuario.";
            validacionOK = true;
        } catch (ValidacionIncorrectaException e) {
            mensajeValidacion = "Ha habido un error con la validación, compruebe que la URL es correcta.";
            validacionOK = false;
        }
        return null;
    }

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public boolean isValidacionOK() {
        return validacionOK;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
