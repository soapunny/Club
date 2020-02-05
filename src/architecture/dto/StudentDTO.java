package architecture.dto;

import architecture.entity.Address;
import architecture.entity.ClubMember;
import architecture.entity.Student;
import architecture.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDTO {
    //
    private String id; //key : email
    private String name;
    private String nickname;
    private String birthday;
    private String phoneNumber;
    private List<AddressDTO> addresses;
    private List<ClubMemberDTO> clubMembers;

    private StudentDTO(){
        //
        addresses = new ArrayList<>();
        clubMembers = new ArrayList<>();
    }

    public StudentDTO(String id, String name, String birthday, String phoneNumber){
        //
        this();
        this.id = id;
        this.name = name;
        this.birthday = new DateUtil().getDateOf(birthday);
        this.phoneNumber = phoneNumber;
    }

    public StudentDTO(Student student){
        //
        this();
        this.id = student.getId();
        this.name = student.getName();
        this.nickname = student.getNickname();
        this.birthday = student.getBirthday();
        this.phoneNumber = student.getPhoneNumber();
        if(student.getAddresses().size()>0){
            this.addresses = student.getAddresses()
                                    .stream()
                                    .map(address -> new AddressDTO(address))
                                    .collect(Collectors.toList());
        }
        if(student.getClubMembers().size()>0){
            this.clubMembers = student.getClubMembers()
                                      .stream()
                                      .map(clubMember -> new ClubMemberDTO(clubMember))
                                      .collect(Collectors.toList());
        }
    }

    public Student toStudent(){
        //
        Student student = new Student(id, name, birthday, phoneNumber);
        student.setNickname(nickname);
        if(addresses.size()>0){
            List<Address> addressList = addresses.stream()
                                                 .map(addressDTO -> addressDTO.toAddress())
                                                 .collect(Collectors.toList());
            student.setAddresses(addressList);
        }
        if(clubMembers.size()>0){
            List<ClubMember> clubMemberList = clubMembers.stream()
                                                         .map(clubMemberDTO -> clubMemberDTO.toClubMember())
                                                         .collect(Collectors.toList());
            student.setClubMembers(clubMemberList);
        }

        return student;
    }

    @Override
    public String toString(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID : "+id)
                     .append(", Name : "+name)
                     .append(", Nickname : "+nickname)
                     .append(", Birthday : "+birthday)
                     .append(", Phone number : "+phoneNumber);
        int cnt = 0;
        if(addresses.size()>0){
            for(AddressDTO addressDTO : addresses)
                stringBuilder.append("\n\t["+ ++cnt + "] "+addressDTO);
        }
        cnt = 0;
        if(clubMembers.size()>0){
            for(ClubMemberDTO clubMemberDTO : clubMembers)
                stringBuilder.append("\n\t["+ ++cnt + "] "+clubMemberDTO);
        }
        return stringBuilder.toString();
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
    public List<AddressDTO> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
    public List<ClubMemberDTO> getClubMembers() {
        return clubMembers;
    }
    public void setClubMembers(List<ClubMemberDTO> clubMembers) {
        this.clubMembers = clubMembers;
    }
}
