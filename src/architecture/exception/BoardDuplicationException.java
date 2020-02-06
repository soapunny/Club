package architecture.exception;

public class BoardDuplicationException extends RuntimeException{
    //
    private static final long serialVersionUID = 8010548105012274048L;

    public BoardDuplicationException(String message){
        //
        super(message);
    }
}
