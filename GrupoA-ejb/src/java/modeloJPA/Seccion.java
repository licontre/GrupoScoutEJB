package modeloJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Seccion implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int edadminima;
    private int edadmaxima;
    @OneToMany(mappedBy="lista")
    private List<Usuario> lista;
    @OneToMany(mappedBy="seccion")
    private List<Historial> historial;
    @ManyToMany
    private List<Evento> eventos;    
    
    public List<Evento> getEventos(){
        return eventos;
    }
    public void setEventos(List<Evento> n){
        this.eventos=n;
    }
    
    public List<Usuario> getLista(){
        return lista;
    }
    public void setLista(List<Usuario> n){
        this.lista = n;
    }
    
    public int getEdadminima(){
        return edadminima;
    }
    public void setEdadminima(int n){
        this.edadminima = n;
    }
    
    public int getEdadmaxima(){
        return edadmaxima;
    }
    public void setEdadmaxima(int n){
        this.edadmaxima = n;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre (){
        return nombre;
    }
    public void setNombre (String n){
        this.nombre = n;
    }
 
    public List<Historial> getHistorial() {
        return historial;
    }
    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
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
        
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoScouts.Seccion[ id=" + getId() + " ]";
    }
    
}
