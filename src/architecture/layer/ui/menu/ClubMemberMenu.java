package architecture.layer.ui.menu;

import architecture.layer.ui.console.ClubMemberConsole;
import architecture.util.Broadcasting;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class ClubMemberMenu {
    //
    private Scanner scanner;
    private Broadcasting broadcasting;

    private ClubMemberConsole clubMemberConsole;

    public ClubMemberMenu(Scanner scanner){
        this.scanner = scanner;
        this.broadcasting = new Broadcasting(SpeakingAt.Left, this);

        this.clubMemberConsole = new ClubMemberConsole(scanner);
    }

    public void show(){
        //
        int inputNumber = -1;
        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1: clubMemberConsole.register();
                    break;
                case 2: clubMemberConsole.findByClubName();
                    break;
                case 3: clubMemberConsole.findByEmail();
                    break;
                case 4: clubMemberConsole.modify();
                    break;
                case 5: clubMemberConsole.remove();
                    break;
                case 0:
                    return;
                default:
                    broadcasting.broadcastln("Choose another one!!");
            }
        }
    }

    public void displayMenu(){
        //
        broadcasting.broadcastln("");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" Student Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 1. Register        Club Member");
        broadcasting.broadcastln(" 2. Find(club name) Club Member");
        broadcasting.broadcastln(" 3. Find(email)     Club Member");
        broadcasting.broadcastln(" 4. Modify          Club Member");
        broadcasting.broadcastln(" 5. Remove          Club Member");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 0. Previous Menu");
        broadcasting.broadcastln("========================================");
    }

    public int selectMenu(){
        //
        int number = scanner.nextInt();

        if(number>=0 && number<=5){
            scanner.nextLine();
            return number;
        }

        return -1;
    }
}
