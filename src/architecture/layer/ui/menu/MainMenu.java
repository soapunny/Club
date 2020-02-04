package architecture.layer.ui.menu;

import architecture.util.Broadcasting;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class MainMenu {
    //
    private Scanner scanner;
    private Broadcasting broadcasting;

    private ClubMenu clubMenu;
    private StudentMenu studentMenu;
    private BoardMenu boardMenu;

    public MainMenu(){
        this.scanner = new Scanner(System.in);
        this.broadcasting = new Broadcasting(SpeakingAt.Left, this);

        this.clubMenu = new ClubMenu(scanner);
        this.studentMenu = new StudentMenu(scanner);
        this.boardMenu = new BoardMenu(scanner);
    }

    public void show(){
        //
        int inputNumber = -1;
        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1:
                    clubMenu.show();
                    break;
                case 2:
                    studentMenu.show();
                    break;
                case 3:
                    boardMenu.show();
                    break;
                case 0:
                    exitProgram();
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
        broadcasting.broadcastln(" Main Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 1.    Club   Menu");
        broadcasting.broadcastln(" 2. Student   Menu");
        broadcasting.broadcastln(" 3.   Board   Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 0. Program exit");
        broadcasting.broadcastln("========================================");
    }

    public int selectMenu(){
        //
        broadcasting.broadcast("Choose one : ");
        int number = scanner.nextInt();

        if(number>=0 && number<=3){
            scanner.nextLine();
            return number;
        }

        return -1;
    }

    public void exitProgram(){
        //
        if(scanner != null)
            scanner.close();
        broadcasting.broadcastln("Good bye!!");
        System.exit(0);
    }
}
