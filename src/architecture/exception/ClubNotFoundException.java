package architecture.exception;

public class ClubNotFoundException extends RuntimeException{
    //
    private static final long serialVersionUID = -7469952411228318141L;

    public ClubNotFoundException(String message){
        //
        super(message);
    }
}
