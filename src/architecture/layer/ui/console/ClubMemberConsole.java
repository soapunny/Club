package architecture.layer.ui.console;

import architecture.dto.ClubDTO;
import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class ClubMemberConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    private ClubDTO currentClub;

    public ClubMemberConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);
    }

    public boolean hasCurrentClub(){
        //
        if(currentClub == null){
            return false;
        }
        return true;
    }

    public void register() {
        //
    }

    public void findByClubName() {
        //
    }

    public void findByEmail() {
        //
    }

    public void modify() {
        //
    }

    public void remove() {
        //
    }

    public ClubDTO getCurrentClub() {
        return currentClub;
    }
    public void setCurrentClub(ClubDTO currentClub) {
        this.currentClub = currentClub;
    }
}
