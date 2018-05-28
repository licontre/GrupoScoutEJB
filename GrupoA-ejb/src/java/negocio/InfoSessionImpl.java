/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modeloJPA.Usuario;

/**
 *
 * @author licontrex
 */
@Stateless
public class InfoSessionImpl implements InfoSession{
    //@Resource(name = "mail/agenda")
    private Session session;

    @PersistenceContext(unitName = "GrupoA-ejbPU")
    private EntityManager em;
    private Usuario user;

    @Override
    public String validarUsuario(String correo, String passwd) throws ContrasenaIncorrectaException, CuentaInexistenteException {
        
        Query consulta = em.createNamedQuery("VerCorreo",Usuario.class);
        consulta.setParameter("email", correo);
        List <Usuario> usu = consulta.getResultList();
        if(usu == null){
            throw new CuentaInexistenteException();
        }
        int i =  0;
        for(Usuario us : usu){
            if(us.getContrasenia().equals(passwd)){
                user = us;
                if(us.getCargo()==Usuario.Cargo.MONITOR){
                    return "inicioM.xhtml";
                }else if(us.getCargo()==Usuario.Cargo.SECRETARIA){
                    return "secretaria.xhtml";
                }else{
                    return "inicio.xhtml";
                }
            }else{
                throw new ContrasenaIncorrectaException("La contraseña no es correcta.");
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario getUsuario(){
        return user;
    }
    private String getHome(){
        if(user.getCargo()==Usuario.Cargo.MONITOR){
            return "inicioM.xhtml";
        }else if(user.getCargo()==Usuario.Cargo.SECRETARIA){
            return "secretaria.xhtml";
        }else{
            return "inicio.xhtml";
        }
    }
    
    @Override
    public String modificarDatosUsuario(Usuario usu) throws CuentaRepetidaException{
        
        Query consulta = em.createNamedQuery("VerCorreo",Usuario.class);
        consulta.setParameter("email", usu.getEmail());
        List <Usuario> usuarios = consulta.getResultList();
        if(usu.getEmail()!=user.getEmail()&&usuarios != null){//Correo en uso
            return null;
            //throw new CuentaRepetidaException("Correo electronico en uso");
        }
        usu.setId(user.getId());
        user = usu;
        em.merge(usu);
        return getHome();
    }
    

}
