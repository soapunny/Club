package architecture.entity;

import architecture.entity.blueprint.Id;

import java.util.ArrayList;
import java.util.List;

public class Student implements Id {
    //
    private String id; //key : email
    private String name;
    private String nickname;
    private String birthday;
    private String phoneNumber;
    private List<Address> addresses;
    private List<ClubMember> clubMembers;


    private Student(){
        //
        addresses = new ArrayList<>();
        clubMembers = new ArrayList<>();
    }

    public Student(String id, String name, String birthday, String phoneNumber){
        //
        this();
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    public List<ClubMember> getClubMembers() {
        return clubMembers;
    }
    public void setClubMembers(List<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
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
