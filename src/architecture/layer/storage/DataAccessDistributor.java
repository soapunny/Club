package architecture.layer.storage;

import architecture.layer.storage.blueprint.*;

public class DataAccessDistributor implements DataDistributor {
    //
    private static DataDistributor instance;
    private IdData idData;
    private BoardData boardData;
    private BoardPostingData boardPostingData;
    private ClubData clubData;
    private StudentData studentData;

    private DataAccessDistributor(){
        //
        idData = new IdDataAccess();
        boardData = new BoardDataAccess();
        boardPostingData = new BoardPostingDataAccess();
        clubData = new ClubDataAccess();
        studentData = new StudentDataAccess();
    }

    public static DataDistributor getInstance(){
        //
        synchronized (DataAccessDistributor.class){
            if(instance == null)
                instance = new DataAccessDistributor();
        }
        return instance;
    }

    @Override
    public BoardData getBoardData() {
        return boardData;
    }
    @Override
    public BoardPostingData getBoardPostingData() {
        return boardPostingData;
    }
    @Override
    public ClubData getClubData() {
        return clubData;
    }
    @Override
    public StudentData getStudentData() {
        return studentData;
    }
    @Override
    public IdData getIdData() {
        return idData;
    }
}
