package architecture.layer.logic;

import architecture.layer.logic.blueprint.*;

public class BusinessLogicDistributor implements BusinessDistributor {
    //
    private static BusinessDistributor instance;

    private BoardBusiness boardBusiness;
    private BoardPostingBusiness boardPostingBusiness;
    private ClubBusiness clubBusiness;
    private StudentBusiness studentBusiness;

    private BusinessLogicDistributor(){
        //
        boardBusiness = new BoardBusinessLogic();
        boardPostingBusiness = new BoardPostingBusinessLogic();
        clubBusiness = new ClubBusinessLogic();
        studentBusiness = new StudentBusinessLogic();
    }

    public static BusinessDistributor getInstance(){
        //
        synchronized (BusinessLogicDistributor.class){
            if(instance == null){
                instance = new BusinessLogicDistributor();
            }
        }

        return instance;
    }

    @Override
    public BoardBusiness getBoardBusiness() {
        return boardBusiness;
    }

    @Override
    public BoardPostingBusiness getBoardPostingBusiness() {
        return boardPostingBusiness;
    }

    @Override
    public ClubBusiness getClubBusiness() {
        return clubBusiness;
    }

    @Override
    public StudentBusiness getStudentBusiness() {
        return studentBusiness;
    }
}
