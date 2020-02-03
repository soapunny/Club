package architecture.dto;

public class ClubDTO {
    //
    private String id;//key : clubId
    private String name;
    private String intro;
    private String foundationDate;

    public ClubDTO(){
        //
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getFoundationDate() {
        return foundationDate;
    }
    public void setFoundationDate(String foundationDate) {
        this.foundationDate = foundationDate;
    }
}
