package BackingBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modeloJPA.Cuota;
import modeloJPA.PagoCuota;
import modeloJPA.Usuario;
import modeloJPA.Usuario.Cargo;

/**
 *
 * @author MARTA
 */
@Named(value = "controlPagos")
@SessionScoped
public class ControlPagos implements Serializable {

    private Usuario usuario;
    private Cuota cuota;
    private List <Cuota> listaCuotas;
    private List<PagoCuota> listaPagosCuota;
    private float importePagoCuota;

    public List<PagoCuota> getListaPagosCuota() {
        return listaPagosCuota;
    }

    public void setListaPagosCuota(List<PagoCuota> listaPagosCuota) {
        this.listaPagosCuota = listaPagosCuota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public List<Cuota> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(List<Cuota> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }
    
    public ControlPagos() {
        
        List<PagoCuota> listac1= new ArrayList<PagoCuota>();
        List<PagoCuota> listac2= new ArrayList<PagoCuota>();
        
        Usuario u1 = new Usuario("castor", "castor", Cargo.CASTORES,"Lola","Martin");
        Usuario u2 = new Usuario ("admin", "admin", Cargo.SECRETARIA,"Roci","Casa");
        
        Cuota c1 = new Cuota (1L, 100, "primera cuota", "inscripcion",listac1);
        
        PagoCuota pago1 = new PagoCuota (11L, new Date(2017, 5 , 28),u1 , c1);
        PagoCuota pago2 = new PagoCuota (12L, new Date(2017, 9 , 28),u1 , c1);
        
        listac1.add(pago1);
        listac1.add(pago2);
        
        
        Cuota c2 = new Cuota (2L, 120, "segunda cuota", "inscripcion",listac2);
        
        PagoCuota pago3 = new PagoCuota (23L, new Date(2017, 5 , 30),u1 , c1);
        PagoCuota pago4 = new PagoCuota (24L, new Date(2017, 9 , 8),u1 , c1);
        
        listac2.add(pago3);
        listac2.add(pago4);
        
        listaCuotas = new ArrayList<Cuota>();
        listaCuotas.add(c1);
        listaCuotas.add(c2);
        listaPagosCuota = new ArrayList<PagoCuota>();
        listaPagosCuota.add(pago1);
        listaPagosCuota.add(pago2);
        listaPagosCuota.add(pago3);
        listaPagosCuota.add(pago4);
        
    }
    
    
    public Float importePago(Cuota cuota){
        float importe = 0;
        int aux = cuota.getCuotas().size();
        
        return cuota.getImporte()/aux;
        
    }
    
}