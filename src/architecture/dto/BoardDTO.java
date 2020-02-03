package architecture.dto;

public class BoardDTO {
    //
    private String id; //key : boardId(clubId)
    private String adminEmail;
    private String name;
    private String foundationDay;

    public BoardDTO(){
        //

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
