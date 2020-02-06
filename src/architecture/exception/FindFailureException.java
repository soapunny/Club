package architecture.exception;

public class FindFailureException extends RuntimeException {
    //
    private static final long serialVersionUID = 3859286036675144167L;

    public FindFailureException(String message){
        //
        super(message);
    }
}
