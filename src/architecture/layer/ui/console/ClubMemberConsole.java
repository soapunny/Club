package architecture.layer.ui.console;

import architecture.dto.ClubDTO;
import architecture.dto.ClubMemberDTO;
import architecture.entity.Position;
import architecture.layer.logic.BusinessLogicDistributor;
import architecture.layer.logic.blueprint.ClubBusiness;
import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.List;
import java.util.Scanner;

public class ClubMemberConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    private ClubDTO currentClub;
    private ClubBusiness clubBusiness;

    public ClubMemberConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);

        clubBusiness = BusinessLogicDistributor.getInstance().getClubBusiness();
    }

    public boolean hasCurrentClub(){
        //
        if(currentClub == null){
            return false;
        }
        return true;
    }

    public void findClub(){
        //
        String clubName = inputUtil.getValueOf("Club name to find(0. Club Member menu)").trim();
        if(clubName.isEmpty() || clubName.equals("0"))
            return;

        try{
            currentClub = clubBusiness.findByClubName(clubName);
            broadcasting.broadcastln("Found club -> "+currentClub);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void register() {
        //
        if(!hasCurrentClub()){
            broadcasting.broadcastln("Find a club first!!");
            return;
        }

        String email = inputUtil.getValueOf("Member email to register(0. Club Member menu)").trim();
        if(email.isEmpty() || email.equals("0"))
            return;

        try {
            ClubMemberDTO clubMemberDTO = new ClubMemberDTO(currentClub.getName(), email);
            ClubMemberDTO registeredClubMember = clubBusiness.registerMember(clubMemberDTO);
            broadcasting.broadcastln("Register Success -> "+registeredClubMember);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findAll() {
        //
        if(!hasCurrentClub()){
            broadcasting.broadcastln("Find a club first!!");
            return;
        }

        try {
            List<ClubMemberDTO> foundMemberList = clubBusiness.findAllMembers(currentClub.getName());
            if(foundMemberList.isEmpty()) {
                broadcasting.broadcastln("No Member is found!!");
                return;
            }
            broadcasting.broadcastln(foundMemberList.size()+" Rows are found");
            int cnt = 0;
            for(ClubMemberDTO foundMember : foundMemberList)
                broadcasting.broadcastln("["+ (++cnt) +"]"+foundMember.toString());
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void modify() {
        //
        if(!hasCurrentClub()){
            broadcasting.broadcastln("Find a club first!!");
            return;
        }

        String email = inputUtil.getValueOf("Select Member email to modify a Member(0. Club Member menu)").trim();
        if(email.isEmpty() || email.equals("0"))
            return;
        String newPosition = inputUtil.getValueOf("Member position to modify(0. Club Member menu)").trim();
        if(newPosition.isEmpty() || newPosition.equals("0"))
            return;

        try {
            ClubMemberDTO clubMemberDTO = new ClubMemberDTO(currentClub.getName(), email);
            clubMemberDTO.setPosition(Position.valueOf(newPosition));
            clubBusiness.modifyMember(clubMemberDTO);
            broadcasting.broadcastln("Modify Success!!");
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void remove() {
        //
        if(!hasCurrentClub()){
            broadcasting.broadcastln("Find a club first!!");
            return;
        }

        String email = inputUtil.getValueOf("Select Member email to remove a Member(0. Club Member menu)").trim();
        if(email.isEmpty() || email.equals("0"))
            return;

        String confirmStr = inputUtil.getValueOf("Do you really want to remove this club member?(Y:yes, N:no)").trim().toLowerCase();
        if(!confirmStr.equals("y") && !confirmStr.equals("yes")){
            broadcasting.broadcastln("Remove is cancelled!!");
            return;
        }
        try{
            String memberName = clubBusiness.removeMember(currentClub.getName(), email);
            broadcasting.broadcastln(memberName+" is removed!!");
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public ClubDTO getCurrentClub() { return currentClub; }
    public void setCurrentClub(ClubDTO currentClub) {
        this.currentClub = currentClub;
    }

}
