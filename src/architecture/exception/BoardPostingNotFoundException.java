package architecture.exception;

public class BoardPostingNotFoundException extends RuntimeException{
    //
    private static final long serialVersionUID = 112989079055962932L;

    public BoardPostingNotFoundException(String message){
        //
        super(message);
    }
}
