package architecture.exception;

public class ClubMemberNotFoundException extends RuntimeException{
    //
    private static final long serialVersionUID = 853884285421555823L;

    public ClubMemberNotFoundException(String message){
        //
        super(message);
    }
}
