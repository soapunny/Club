package architecture.entity;

import architecture.entity.blueprint.AutoId;
import architecture.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class Club implements AutoId {
    //
    private String id;// key
    private String name;// alterative key
    private String intro;
    private String foundationDate;

    private List<ClubMember> clubMemberList;

    private Club(){
        //
        clubMemberList = new ArrayList<>();
        foundationDate = new DateUtil().getCurrentDate();
    }

    public Club(String name, String intro){
        //
        this();
        this.name = name;
        this.intro = intro;
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
    public List<ClubMember> getClubMemberList() {
        return clubMemberList;
    }
    public void setClubMemberList(List<ClubMember> clubMemberList) {
        this.clubMemberList = clubMemberList;
    }
    @Override
    public String getAutoId() {
        return id;
    }
    @Override
    public void setAutoId(String id) {
        this.id = id;
    }
}
