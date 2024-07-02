package pe.edu.cibertec.DSWII_T3_AbelPerez.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
