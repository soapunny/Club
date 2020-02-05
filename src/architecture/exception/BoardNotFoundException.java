package architecture.exception;

public class BoardNotFoundException extends RuntimeException{
    //
    private static final long serialVersionUID = 8852245811936145408L;

    public BoardNotFoundException(String message){
        //
        super(message);
    }
}
