package architecture.layer.logic;

import architecture.dto.ClubDTO;
import architecture.dto.ClubMemberDTO;
import architecture.layer.logic.blueprint.ClubBusiness;

import java.util.List;

public class ClubBusinessLogic implements ClubBusiness {
    //
    ClubBusinessLogic(){
        //

    }

    @Override
    public ClubDTO register(ClubDTO clubDTO) {
        return null;
    }

    @Override
    public ClubDTO findByClubName(String clubName) {
        return null;
    }

    @Override
    public void modify(ClubDTO clubDTO) {

    }

    @Override
    public String remove(String clubName) {
        return null;
    }

//=====================================Member Business==========================================
    @Override
    public ClubMemberDTO registerMember(ClubMemberDTO clubMemberDTO) {
        return null;
    }

    @Override
    public List<ClubMemberDTO> findAllMembers(String name) {
        return null;
    }

    @Override
    public void modifyMember(ClubMemberDTO clubMemberDTO) {

    }

    @Override
    public String removeMember(String name, String email) {
        return null;
    }
}
