/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.Stateless;
import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modeloJPA.Usuario;

/**
 *
 * @author francis
 */
@Stateless
public class NegocioImpl implements Negocio {

    private static final int TAM_CADENA_VALIDACION = 20;

    //@Resource(name = "mail/agenda")
    private Session session;

    @PersistenceContext(unitName = "GrupoA-ejbPU")
    private EntityManager em;


    @Override
    public void registrarUsuario(Usuario u) {
        Usuario user = em.find(Usuario.class,u.getId());
        if (user != null) {
            // El usuario ya existe
           System.out.println(u.getNombreusuario()+" nombre de usuario no disponible");
        }
        em.persist(u);

        System.out.println("Registrado "+u.getNombreusuario());
    }

    @Override
    public void compruebaLogin(Usuario u){
        Usuario user2 = em.find(Usuario.class, u.getId());
        if (user2 == null) {
           
        }
    if (!user2.getContrasenia().equals(u.getContrasenia())) {
            System.out.println("Contrasena incorrecta");
        }
    }

   

    @Override
    public void validarCuenta(String cuenta, String validacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
