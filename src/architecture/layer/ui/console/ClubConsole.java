package architecture.layer.ui.console;

import architecture.dto.ClubDTO;
import architecture.layer.logic.BusinessLogicDistributor;
import architecture.layer.logic.blueprint.ClubBusiness;
import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class ClubConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    private ClubBusiness clubBusiness;

    public ClubConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);

        clubBusiness = BusinessLogicDistributor.getInstance().getClubBusiness();
    }

    public void register(){
        //
        String name = inputUtil.getValueOf("Club name to register(0. Club menu)").trim();
        if(name.isEmpty() || name.equals("0"))
            return;
        String intro = inputUtil.getValueOf("Club intro to register(0. Club menu)").trim();
        if(intro.isEmpty() || intro.equals("0"))
            return;

        try {
            ClubDTO clubDTO = new ClubDTO(name, intro);
            ClubDTO registeredClub = clubBusiness.register(clubDTO);
            broadcasting.broadcastln("Register Success -> "+registeredClub);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void findByClubName(){
        //
        String clubName = inputUtil.getValueOf("Club name to register(0. Club menu)").trim();
        if(clubName.isEmpty() || clubName.equals("0"))
            return;

        try{
            ClubDTO foundClub = clubBusiness.findByClubName(clubName);
            broadcasting.broadcastln("Found club -> "+foundClub);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void modify(){
        //
        String clubName = inputUtil.getValueOf("Select club name to modify(0. Club menu)").trim();
        if(clubName.isEmpty() || clubName.equals("0"))
            return;

        String newIntro = inputUtil.getValueOf("Club intro to modify(0. Club intro, Enter. No change").trim();
        if(newIntro.equals("0"))
            return;

        try {
            ClubDTO clubDTO = new ClubDTO(clubName, newIntro);
            clubBusiness.modify(clubDTO);
            broadcasting.broadcastln("Modify Success!!");
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }

    public void remove(){
        //
        String clubName = inputUtil.getValueOf("Select club name to remove(0. Club menu)").trim();
        if(clubName.isEmpty() || clubName.equals("0"))
            return;

        String confirmStr = inputUtil.getValueOf("Do you really want to remove this data?(Y:yes, N:no)").trim().toLowerCase();
        if(!confirmStr.equals("y") && !confirmStr.equals("yes"))
            return;

        try{
            String removeClubName = clubBusiness.remove(clubName);
            broadcasting.broadcastln("Remove Success -> "+removeClubName);
        }catch (Exception e){
            broadcasting.broadcastln(e.getMessage());
        }
    }
}
