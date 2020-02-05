package architecture.exception;

public class StudentNotFoundException extends RuntimeException{
    //
    private static final long serialVersionUID = -6575470492811600235L;

    public StudentNotFoundException(String message){
        //
        super(message);
    }
}
