package modeloJPA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Usuario implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;   
    public enum Sexo { HOMBRE , MUJER };
    private String nombreusuario;
    private String contrasenia;
    private String nombre;
    private String apellidos;
    private String dni;
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Enumerated(EnumType.STRING)
    private Sexo genero;
    private String calle;
    private String codigopostal;
    private String localidad;
    private String provincia;
    public enum Cargo {CASTORES,MANADA,TROPA,UNIDAD,CLAN,SCOUTER,MONITOR,SECRETARIA};
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @Column(unique = true)
    private String email;
    private String password;
    private String fotoperfil;
    @Temporal(TemporalType.DATE)
    private Date fechaentrada;
    @Temporal(TemporalType.DATE)
    private Date fechabaja;
    @OneToMany( mappedBy ="fechatransicion")
    private List<Historial> fechatransicion;
    @OneToMany( mappedBy ="usuario")
    private List<PagoCuota> pagoscuota;
    @OneToMany(mappedBy="usuario")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy="usuario")
    private List<Asistencia> asistencias;
    @ManyToOne
    private Seccion lista;   
    @ManyToMany
    private List<Documento> documentos;

   
    //Este metodo es especifico para la tarea 2
    public Usuario(String nombreusuario, String password, Cargo cargo,String nombre,String ap ){
        setNombreusuario(nombreusuario);
        setPassword(password);
        setCargo(cargo);
        setApellidos(ap);
        setNombre(nombre);
        setProvincia("Malaga");
        this.documentos= new ArrayList<>();
        this.asistencias= new ArrayList<>();
        this.comentarios= new ArrayList<>();
        this.fechatransicion= new ArrayList<>();
        this.pagoscuota=new ArrayList<>();
        
    }
    public Usuario(){
        this.apellidos="";
        this.nombre="";
        this.nombreusuario="";
        this.calle="";
        this.dni="";
        this.documentos= new ArrayList<>();
        this.asistencias= new ArrayList<>();
        this.comentarios= new ArrayList<>();
        this.fechatransicion= new ArrayList<>();
        this.pagoscuota=new ArrayList<>();
        
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   
    public String getNombreusuario() {
        return nombreusuario;
    }
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Sexo getGenero() {
        return genero;
    }
    public void setGenero(Sexo genero) {
        this.genero = genero;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    
    public Cargo getCargo(){
        return cargo;
    }
    
    public void setCargo(Cargo cargo){
        this.cargo=cargo;
    }
    public String getCodigopostal() {
        return codigopostal;
    }
    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoperfil() {
        return fotoperfil;
    }
    public void setFotoperfil(String fotoperfil) {
        this.fotoperfil = fotoperfil;
    }

    public List<Historial> getFechatransicion() {
        return fechatransicion;
    }
    public void setFechatransicion(List<Historial> fechatransicion) {
        this.fechatransicion = fechatransicion;
    }

    public List<PagoCuota> getPagoscuota() {
        return pagoscuota;
    }
    public void setPagoscuota(List<PagoCuota> pagoscuota) {
        this.pagoscuota = pagoscuota;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }
    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechabaja() {
        return fechabaja;
    }
    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }
    
    public Seccion getLista() {
        return lista;
    }
    public void setLista(Seccion lista) {
        this.lista = lista;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }
    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
     
    public List<Comentario> getComentarios() {
        return comentarios;
    }
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
       
    public List<Asistencia> getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
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
        
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entrega21.Usuario[ id=" + getId() + " ]";
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
 
}
