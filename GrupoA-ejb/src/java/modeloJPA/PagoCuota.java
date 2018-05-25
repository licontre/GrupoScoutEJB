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
public class PagoCuota implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Cuota pagoscuota;

    public PagoCuota() {
    }
    
    

    
    
    public PagoCuota (Long id, Date fecha, Usuario u, Cuota cuota){
        
        this.id = id;
        this.fecha = fecha;
        usuario = u;
        pagoscuota = cuota;
    }
    
    
    public Cuota getPagoscuota(){
        return pagoscuota;
    }
    public void setPagoscuota(Cuota n){
        this.pagoscuota = n;
    }    
    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario n){
        this.usuario = n;
    }    
    
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date n){
        this.fecha = n;
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
        
        if (!(object instanceof PagoCuota)) {
            return false;
        }
        PagoCuota other = (PagoCuota) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grupoScouts.PagoCuota[ id=" + getId() + " ]";
    }
    
}