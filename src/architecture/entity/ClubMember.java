package architecture.entity;

import architecture.util.DateUtil;

public class ClubMember {
    //key가 존재하지 않음
    private String clubName;
    private String email;
    private String name;
    private String joinDate;

    private ClubMember(){
        //
        joinDate = new DateUtil().getCurrentDate();
    }

    public ClubMember(String clubName, String memberEmail, String memberName){
        //
        this();
        this.clubName = clubName;
        this.email = memberEmail;
        this.name = memberName;
    }

    public String getClubName() {
        return clubName;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
