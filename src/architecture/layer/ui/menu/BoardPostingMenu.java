package architecture.layer.ui.menu;

import architecture.layer.ui.console.BoardPostingConsole;
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
                case 2: boardPostingConsole.findByEmail();
                    break;
                case 3: boardPostingConsole.findByTitle();
                    break;
                case 4: boardPostingConsole.modify();
                    break;
                case 5: boardPostingConsole.remove();
                    break;
                case 0: boardPostingConsole.setCurrentBoard(null);
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
        if(boardPostingConsole.hasCurrentBoard()){
            broadcasting.broadcastln(boardPostingConsole.getCurrentBoard()+" Board Posting Menu");
        }else {
            broadcasting.broadcastln(" Board Posting Menu");
        }
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 1. Register    Board Posting");
        broadcasting.broadcastln(" 2. Find(email) Board Posting");
        broadcasting.broadcastln(" 3. Find(title) Board Posting");
        broadcasting.broadcastln(" 4. Modify      Board Posting");
        broadcasting.broadcastln(" 5. Remove      Board Posting");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 0. Previous Menu");
        broadcasting.broadcastln("========================================");
    }

    public int selectMenu(){
        //
        broadcasting.broadcast("Choose one : ");
        int number = scanner.nextInt();

        if(number>=0 && number<=5){
            scanner.nextLine();
            return number;
        }

        return -1;
    }
}
