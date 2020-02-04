package architecture.dto;

import architecture.entity.Board;
import architecture.util.DateUtil;

public class BoardDTO{
    //
    private String id; //key : boardId(clubId)
    private String name; //alternative key
    private String adminEmail;
    private String foundationDay;

    private BoardDTO(){
        //
        foundationDay = new DateUtil().getCurrentDate();
    }

    public BoardDTO(String name, String adminEmail){
        //
        this();
        this.name = name;
        this.adminEmail = adminEmail;
    }

    public BoardDTO(Board board){
        //
        this.id = board.getId();
        this.adminEmail = board.getAdminEmail();
        this.name = board.getName();
        this.foundationDay = board.getFoundationDay();
    }

    public Board toBoard(){
        //
        Board board = new Board(name, adminEmail);
        board.setId(id);
        board.setFoundationDay(foundationDay);
        return board;
    }

    @Override
    public String toString(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Board name : "+name).append(", Admin email : "+adminEmail).append(", Foundation day : "+foundationDay);

        return stringBuilder.toString();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFoundationDay() {
        return foundationDay;
    }
    public void setFoundationDay(String foundationDay) {
        this.foundationDay = foundationDay;
    }
}
