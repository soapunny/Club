package architecture.layer.ui.console;

import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class ClubConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    //TODO
    //private ClubBusiness clubBusiness;

    public ClubConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);


    }

    public void register(){
        //
    }

    public void findByClubName(){
        //
    }

    public void modify(){
        //
    }

    public void remove(){
        //
    }
}
