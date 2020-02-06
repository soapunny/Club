package architecture.exception;

public class RegisterFailureException extends RuntimeException {
    //
    private static final long serialVersionUID = -7282121971354681927L;

    public RegisterFailureException(String message){
        //
        super(message);
    }
}
