package architecture.layer.ui.menu;

import architecture.layer.ui.console.BoardPostingConsole;
import architecture.layer.ui.console.ClubMemberConsole;
import architecture.util.Broadcasting;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class BoardPostingMenu {
    //
    private Scanner scanner;
    private Broadcasting broadcasting;

    private BoardPostingConsole boardPostingConsole;

    public BoardPostingMenu(Scanner scanner){
        this.scanner = scanner;
        this.broadcasting = new Broadcasting(SpeakingAt.Left, this);

        this.boardPostingConsole = new BoardPostingConsole(scanner);
    }

    public void show(){
        //
        int inputNumber = -1;
        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1: boardPostingConsole.register();
                    break;
                case 2: boardPostingConsole.findById();
                    break;
                case 3: boardPostingConsole.findByEmail();
                    break;
                case 4: boardPostingConsole.modify();
                    break;
                case 5: boardPostingConsole.remove();
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
