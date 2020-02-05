package architecture.layer.logic.blueprint;

import architecture.dto.ClubDTO;
import architecture.dto.ClubMemberDTO;

import java.util.List;

public interface ClubBusiness {
    //Club
    ClubDTO register(ClubDTO clubDTO);
    ClubDTO findByClubName(String clubName);
    void modify(ClubDTO clubDTO);
    String remove(String clubName);

    //ClubMember
    ClubMemberDTO registerMember(ClubMemberDTO clubMemberDTO);
    List<ClubMemberDTO> findAllMembers(String name);
    void modifyMember(ClubMemberDTO clubMemberDTO);
    String removeMember(String name, String email);
}
