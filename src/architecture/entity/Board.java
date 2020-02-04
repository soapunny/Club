package architecture.entity;

import architecture.entity.blueprint.Id;
import architecture.util.DateUtil;

public class Board implements Id {
    //
    private String id; //key : boardId(clubId)
    private String name; //alternative key
    private String adminEmail;//administer email
    private String foundationDay;//yyyy-MM-dd

    private Board(){
        //
        foundationDay = new DateUtil().getCurrentDate();
    }

    public Board(String name, String adminEmail){
        //
        this.name = name;
        this.adminEmail = adminEmail;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
    public String getFoundationDay() {
        return foundationDay;
    }
    public void setFoundationDay(String foundationDay) {
        this.foundationDay = foundationDay;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
}
