package architecture.exception;

public class RemoveFailureException extends RuntimeException {
    //
    private static final long serialVersionUID = -5137193455963110930L;

    public RemoveFailureException(String message){
        //
        super(message);
    }
}
