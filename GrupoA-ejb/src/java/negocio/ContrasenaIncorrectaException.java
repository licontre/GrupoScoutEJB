
package negocio;

/**
 *
 * @author francis
 */
public class ContrasenaIncorrectaException extends InfoSessionException {
    
    public ContrasenaIncorrectaException(){
        super();
    }
    public ContrasenaIncorrectaException(String m){
        super(m);
    }
}
