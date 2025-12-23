public class NombreNegatifException extends Exception {
    
    public NombreNegatifException(String msg){
        super(msg);
    }

    public NombreNegatifException(String msg, Throwable cause){
        super(msg, cause);
    }
}
