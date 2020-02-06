package architecture.exception;

public class HasNoRightException extends RuntimeException {
    //
    private static final long serialVersionUID = -7748071108959580839L;

    public HasNoRightException(String message){
        //
        super(message);
    }
}
