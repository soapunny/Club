package architecture.dto;

import architecture.entity.Club;
import architecture.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClubDTO {
    //
    private String id;// key
    private String name;// alternative key
    private String intro;
    private String foundationDate;

    private List<ClubMemberDTO> clubMemberDTOList;

    private ClubDTO(){
        //
        clubMemberDTOList = new ArrayList<>();
    }

    public ClubDTO(String name, String intro){
        //
        this();
        this.name = name;
        this.intro = intro;
        this.foundationDate = new DateUtil().getCurrentDate();
    }

    public ClubDTO(Club club){
        //
        this();
        this.id = club.getAutoId();
        this.name = club.getName();
        this.intro = club.getIntro();
        this.foundationDate = club.getFoundationDate();

        if(!club.getClubMemberList().isEmpty()) {
            clubMemberDTOList = club.getClubMemberList()
                                    .stream()
                                    .map(clubMember -> new ClubMemberDTO(clubMember))
                                    .collect(Collectors.toList());
        }
    }

    public Club toClub(){
        //
        Club club = new Club(name, intro);
        club.setAutoId(id);
        club.setFoundationDate(foundationDate);
        if(!clubMemberDTOList.isEmpty()){
            for(ClubMemberDTO clubMemberDTO : clubMemberDTOList)
                club.getClubMemberList().add(clubMemberDTO.toClubMember());
        }

        return club;
    }

    @Override
    public String toString(){
        //
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Club Name : "+name)
                     .append(", Intro : "+intro)
                     .append(", Foundation date : "+foundationDate);

        if(!clubMemberDTOList.isEmpty()){
            int cnt = 0;
            for(ClubMemberDTO clubMemberDTO : clubMemberDTOList){
                stringBuilder.append("\n\t["+(++cnt)+"] "+clubMemberDTO);
            }
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
    public List<ClubMemberDTO> getClubMemberDTOList() {
        return clubMemberDTOList;
    }
    public void setClubMemberDTOList(List<ClubMemberDTO> clubMemberDTOList) {
        this.clubMemberDTOList = clubMemberDTOList;
    }
}
