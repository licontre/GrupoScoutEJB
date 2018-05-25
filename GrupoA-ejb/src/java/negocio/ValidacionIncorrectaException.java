
package negocio;

/**
 *
 * @author francis
 */
public class ValidacionIncorrectaException extends RegistroException {
    public ValidacionIncorrectaException(){
        super();
    }
    public ValidacionIncorrectaException(String s){
        super(s);
    }
}
