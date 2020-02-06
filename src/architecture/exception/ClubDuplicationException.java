package architecture.exception;

public class ClubDuplicationException extends RuntimeException{
    //
    private static final long serialVersionUID = 8138042335690166691L;

    public ClubDuplicationException(String message){
        //
        super(message);
    }
}
