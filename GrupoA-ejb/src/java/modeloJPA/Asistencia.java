package modeloJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Asistencia implements Serializable {

    /**
     * @return the confirmacion
     */
    public Opcion getConfirmacion() {
        return confirmacion;
    }

    /**
     * @param confirmacion the confirmacion to set
     */
    public void setConfirmacion(Opcion confirmacion) {
        this.confirmacion = confirmacion;
    }

    public enum Opcion { SI, NO }
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String observacion;
    @Enumerated(EnumType.STRING)
    private Opcion confirmacion;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Evento asistencia;
        
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario n){
        this.usuario = n;
    }    
    
    public String getObservacion (){
        return observacion;
    }
    public void setObservacion (String n){
        this.observacion = n;
    }
   
    public Date getFecha (){
        return fecha;
    }
    public void setFecha (Date n){
        this.fecha = n;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Evento getAsistencia() {
        return asistencia;
    }
    public void setAsistencia(Evento asistencia) {
        this.asistencia = asistencia;
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
       
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoScouts.Asistencia[ id=" + getId() + " ]";
    }

}
