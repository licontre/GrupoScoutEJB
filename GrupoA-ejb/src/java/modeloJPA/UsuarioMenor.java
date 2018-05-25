package modeloJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
public class UsuarioMenor extends Usuario{

    
    private String nombre1;
    private String apellido1; 
    private String nombre2;
    private String apellido2;
    private String dni1;
    private String dni2;    
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public UsuarioMenor() {
    }

    //Añadido no se porque pero es para quitar un error que da
    public UsuarioMenor(String nombreusuario, String contrasenia, Cargo cargo,String nombre, String ap) {
        super(nombreusuario, contrasenia, cargo,nombre,ap);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDni1(){
        return dni1;
    }
    public void setDni1(String n){
        this.dni1 = n;
    }
    
    public String getDni2(){
        return dni2;
    }
    public void setDni2(String n){
        this.dni2 = n;
    }
    
    public String getNombre1(){
        return nombre1;
    }
    public void setNombre1(String  n){
        this.nombre1 = n;
    }
    
    public String getNombre2(){
        return nombre2;
    }
    public void setNombre2(String  n){
        this.nombre2 = n;
    }
    
    public String getApellido1(){
        return apellido1;
    }
    public void setApellido1(String  n){
        this.apellido1 = n;
    }
    
    public String getApellido2(){
        return apellido2;
    }
    public void setApellido2(String  n){
        this.apellido2 = n;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof UsuarioMenor)) {
            return false;
        }
        UsuarioMenor other = (UsuarioMenor) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega21.Usuario[ id=" + getId() + " ]";
    }
        
}
