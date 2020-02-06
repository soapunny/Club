package architecture.layer.storage.blueprint;

public interface DataDistributor {
    //
    BoardData getBoardData();
    BoardPostingData getBoardPostingData();
    ClubData getClubData();
    StudentData getStudentData();
    IdData getIdData();
}
