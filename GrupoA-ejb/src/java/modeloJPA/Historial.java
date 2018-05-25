package modeloJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Historial implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    private Seccion seccion;
    @ManyToOne
    private Usuario fechatransicion;
    
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date n){
        this.fecha = n;
    }
    
    public Seccion getSeccion(){
        return seccion;
    }
    public void setSeccion(Seccion n){
        this.seccion = n;
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
        
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoScouts.FechaEntrada[ id=" + getId() + " ]";
    }

    /**
     * @return the fechatransicion
     */
    public Usuario getFechatransicion() {
        return fechatransicion;
    }

    /**
     * @param fechatransicion the fechatransicion to set
     */
    public void setFechatransicion(Usuario fechatransicion) {
        this.fechatransicion = fechatransicion;
    }
    
}
