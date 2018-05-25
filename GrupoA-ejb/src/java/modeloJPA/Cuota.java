package modeloJPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cuota implements Serializable {


    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float importe;
    private String nombre;
    private String descripcion;
    @OneToMany( mappedBy ="pagoscuota")
    private List<PagoCuota> cuotas;

    public Cuota() {
    }
    
    public Cuota(Long id,float impr,String name,String dsc,List<PagoCuota>cuot){
        this.id=id;
        this.importe = impr;
        this.nombre = name;
        this.descripcion = dsc;
        this.cuotas = cuot;
    }
    public List<PagoCuota> getCuotas(){
        return cuotas;
    }
    public void setCuotas(List<PagoCuota> n){
        this.cuotas = n;
    }
    
    public float getImporte(){
        return importe;
    }
    public void setImporte(float n){
        this.importe = n;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String n){
        this.descripcion = n;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
        
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoScouts.Cuota[ id=" + getId() + " ]";
    }
    
}
