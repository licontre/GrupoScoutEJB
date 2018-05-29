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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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

            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
            Date fe = sm.parse(anio+"-"+mes+"-"+dia);
            int edad = this.edad(dia+"/"+mes+"/"+anio);

            usuario.setFechanacimiento(fe);
            if(sexo.equals("femenino")){
                this.usuario.setGenero(Sexo.MUJER);
            }else{
                this.usuario.setGenero(Sexo.HOMBRE);
            }

            if(edad < 7){
                this.usuario.setCargo(Cargo.CASTORES);
            }else if(edad < 10){
                this.usuario.setCargo(Cargo.MANADA);
            }else if(edad < 13){
                this.usuario.setCargo(Cargo.SCOUTER);
            }else if(edad < 16){
                this.usuario.setCargo(Cargo.UNIDAD);
            }else if(edad < 19){
                this.usuario.setCargo(Cargo.CLAN);
            }else{
                this.usuario.setCargo(Cargo.SCOUTER);
            }
            
            negocio.registrarUsuario(this.usuario);
            
        } catch (RegistroException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return "login.xhtml";
    }
    
    
    

    
    private int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
   
    Date fechaActual = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String hoy = formato.format(fechaActual);
    String[] dat1 = fecha_nac.split("/");
    String[] dat2 = hoy.split("/");
    int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
    if (mes < 0) {
      anos = anos - 1;
    } else if (mes == 0) {
      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
      if (dia > 0) {
        anos = anos - 1;
      }
    }
    return anos;
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
