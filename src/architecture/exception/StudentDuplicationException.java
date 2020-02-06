package architecture.exception;

public class StudentDuplicationException extends RuntimeException{
    //
    private static final long serialVersionUID = 8637986126978815677L;

    public StudentDuplicationException(String message){
        //
        super(message);
    }
}
