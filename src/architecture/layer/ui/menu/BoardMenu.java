package architecture.layer.ui.menu;

import architecture.layer.ui.console.BoardConsole;
import architecture.util.Broadcasting;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class BoardMenu {
    //
    private Scanner scanner;
    private Broadcasting broadcasting;

    private BoardConsole boardConsole;
    private BoardPostingMenu boardPostingMenu;

    public BoardMenu(Scanner scanner){
        this.scanner = scanner;
        this.broadcasting = new Broadcasting(SpeakingAt.Left, this);

        this.boardConsole = new BoardConsole(scanner);
        this.boardPostingMenu = new BoardPostingMenu(scanner);
    }

    public void show(){
        //
        int inputNumber = -1;

        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1:
                    boardConsole.register();
                    break;
                case 2:
                    boardConsole.findById();
                    break;
                case 3:
                    boardConsole.findByName();
                    break;
                case 4:
                    boardConsole.modify();
                    break;
                case 5:
                    boardConsole.remove();
                    break;
                case 6:
                    boardPostingMenu.show();
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
        broadcasting.broadcastln(" Board Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 1. Register    Board");
        broadcasting.broadcastln(" 2. Find(email) Board");
        broadcasting.broadcastln(" 3. Find(name)  Board");
        broadcasting.broadcastln(" 4. Modify      Board");
        broadcasting.broadcastln(" 5. Remove      Board");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 6. To Board Posting Menu");
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
