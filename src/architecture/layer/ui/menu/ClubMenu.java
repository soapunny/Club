package architecture.layer.ui.menu;

import architecture.layer.ui.console.ClubConsole;
import architecture.util.Broadcasting;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class ClubMenu {
    //
    private Scanner scanner;
    private Broadcasting broadcasting;

    private ClubConsole clubConsole;
    private ClubMemberMenu clubMemberMenu;

    public ClubMenu(Scanner scanner){
        this.scanner = scanner;
        this.broadcasting = new Broadcasting(SpeakingAt.Left, this);

        this.clubConsole = new ClubConsole(scanner);
        this.clubMemberMenu = new ClubMemberMenu(scanner);
    }

    public void show(){
        //
        int inputNumber = -1;
        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1:
                    clubConsole.register();
                    break;
                case 2:
                    clubConsole.findById();
                    break;
                case 3:
                    clubConsole.findByClubName();
                    break;
                case 4:
                    clubConsole.modify();
                    break;
                case 5:
                    clubConsole.remove();
                    break;
                case 6:
                    clubMemberMenu.show();
                    break;
                case 0:
                    return;
                default:
                    broadcasting.broadcastln("Choose another one");
            }
        }
    }

    public void displayMenu(){
        //
        broadcasting.broadcastln("");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" Club Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 1. Register   Club");
        broadcasting.broadcastln(" 2. Find(ID)   Club");
        broadcasting.broadcastln(" 3. Find(name) Club");
        broadcasting.broadcastln(" 4. Modify     Club");
        broadcasting.broadcastln(" 5. Remove     Club");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 6. To Club Member Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 0. Previous Menu");
        broadcasting.broadcastln("========================================");
    }

    public int selectMenu(){
        //
        int number = scanner.nextInt();

        if(number>=0 && number<=6){
            scanner.nextLine();
            return number;
        }

        return -1;
    }
}
