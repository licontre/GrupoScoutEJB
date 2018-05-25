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
import javax.persistence.TemporalType;
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
    public void registrarUsuario(Usuario u) throws RegistroException{
                /*Usuario user = em.find(Usuario.class,u.getId());
        if (user != null) {
            // El usuario ya existe
           System.out.println(u.getNombreusuario()+" nombre de usuario no disponible");
        }
*/
        Query cons = em.createNamedQuery("VerCorreo",Usuario.class);
        cons.setParameter("email",u.getEmail());
        List<Usuario> lis = cons.getResultList();
        if(lis!=null){
        for(Usuario user:lis){
            System.out.println("-------------------->"+user.getNombreusuario());
        }
        }
        em.persist(u);
        System.out.println("Registrado "+u.getNombreusuario());
       
    }

    @Override
    public void compruebaLogin(Usuario u)throws RegistroException{
        Usuario user2 = em.find(Usuario.class, u.getId());
        if (user2 == null) {
           throw new CuentaInexistenteException("Cuenta no existe");
        }
    if (!user2.getContrasenia().equals(u.getContrasenia())) {
            throw new ContraseniaInvalidaException("Contraseña incorrecta");
        }
    }

   

    @Override
    public void validarCuenta(String cuenta, String validacion) throws RegistroException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
