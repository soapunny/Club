package architecture.exception;

public class BoardPostingDuplicationException extends RuntimeException{
    //
    private static final long serialVersionUID = -6038657093205153751L;

    public BoardPostingDuplicationException(String message){
        //
        super(message);
    }
}
