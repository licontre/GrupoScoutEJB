
package negocio;

/**
 *
 * @author francis
 */
public class CuentaInexistenteException extends RegistroException {
    public CuentaInexistenteException(){
        super();
    }
    public CuentaInexistenteException(String s){
        super(s);
    }
}
