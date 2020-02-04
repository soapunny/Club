package architecture.dto;

import architecture.entity.ClubMember;
import architecture.util.DateUtil;

public class ClubMemberDTO {
    //key가 존재하지 않음
    private String clubName;
    private String email;
    private String name;
    private String joinDate;

    private ClubMemberDTO(){
        //
        joinDate = new DateUtil().getCurrentDate();
    }

    public ClubMemberDTO(String clubName, String memberEmail, String memberName){
        //
        this();
        this.clubName = clubName;
        this.email = memberEmail;
        this.name = memberName;
    }

    public ClubMemberDTO(ClubMember clubMember){
        //
        this.clubName = clubMember.getClubName();
        this.email = clubMember.getEmail();
        this.name = clubMember.getName();
        this.joinDate = clubMember.getJoinDate();
    }

    public ClubMember toClubMember() {
        //
        ClubMember clubMember = new ClubMember(clubName, email, name);
        clubMember.setJoinDate(joinDate);

        return clubMember;
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
