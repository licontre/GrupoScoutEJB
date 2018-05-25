package modeloJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Documento implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String estado;
    private String copiadocumento;
    private String tipo;
    @ManyToOne
    private Evento eventos;
    @ManyToMany(mappedBy="documentos")
    private List<Usuario> usuarios;

    public Documento() {
    }
    
    public Documento(Long id, String nombre, String estado,String copia, String tipo){
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.copiadocumento = copia;
        this.tipo = tipo;
    }
    
    public void setEventos(Evento e){
        this.eventos = e;
    }
    public Evento getEventos(){
        return eventos;
    }
        
    public String getNombre (){
        return nombre;
    }
    public void setNombre (String n){
        this.nombre = n;
    }
    
    public String getEstado (){
        return estado;
    }
    public void setEstado (String n){
        this.estado = n;
    }
    
    public String getCopiadocumento (){
        return copiadocumento;
    }
    public void setCopiadocumento (String n){
        this.copiadocumento = n;
    }
    
    public String getTipo (){
        return tipo;
    }
    public void setTipo (String n){
        this.tipo = n;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
   
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoScouts.Documento[ id=" + getId() + " ]";
    }

}
