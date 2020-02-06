package architecture.exception;

public class ModifyFailureException extends RuntimeException {
    //
    private static final long serialVersionUID = -5782102166132738205L;

    public ModifyFailureException(String message){
        //
        super(message);
    }
}
