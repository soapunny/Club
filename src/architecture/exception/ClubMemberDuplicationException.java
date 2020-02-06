package architecture.exception;

public class ClubMemberDuplicationException extends RuntimeException{
    //
    private static final long serialVersionUID = 8669514943456109025L;

    public ClubMemberDuplicationException(String message){
        //
        super(message);
    }
}
