package architecture.dto;

import architecture.entity.ClubMember;
import architecture.entity.Position;
import architecture.util.DateUtil;

public class ClubMemberDTO {
    //key가 존재하지 않음
    private String clubName;
    private String email;
    private String name;
    private Position position;
    private String joinDate;

    private ClubMemberDTO(){
        //
        joinDate = new DateUtil().getCurrentDate();
        position = Position.MEMBER;
    }

    public ClubMemberDTO(String clubName, String memberEmail){
        //
        this();
        this.clubName = clubName;
        this.email = memberEmail;
    }

    public ClubMemberDTO(ClubMember clubMember){
        //
        this.clubName = clubMember.getClubName();
        this.email = clubMember.getEmail();
        this.name = clubMember.getName();
        this.position = clubMember.getPosition();
        this.joinDate = clubMember.getJoinDate();
    }

    public ClubMember toClubMember() {
        //
        ClubMember clubMember = new ClubMember(clubName, email);
        clubMember.setName(name);
        clubMember.setPosition(position);
        clubMember.setJoinDate(joinDate);

        return clubMember;
    }

    @Override
    public String toString(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Club name : "+clubName)
                     .append(", Member email : "+email)
                     .append(", Member name : "+name)
                     .append(", Member position : "+position)
                     .append(", Join date : "+joinDate);
        return stringBuilder.toString();
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
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public String getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
