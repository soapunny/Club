package architecture.layer.ui.menu;

import architecture.layer.ui.console.StudentConsole;
import architecture.util.Broadcasting;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class StudentMenu {
    //
    private Scanner scanner;
    private Broadcasting broadcasting;

    private StudentConsole studentConsole;

    public StudentMenu(Scanner scanner){
        this.scanner = scanner;
        this.broadcasting = new Broadcasting(SpeakingAt.Left, this);

        this.studentConsole = new StudentConsole(scanner);
    }

    public void show(){
        //
        int inputNumber = -1;
        while(true) {
            displayMenu();
            inputNumber = selectMenu();

            switch (inputNumber){
                case 1: studentConsole.register();
                    break;
                case 2: studentConsole.findById();
                    break;
                case 3: studentConsole.findByName();
                    break;
                case 4: studentConsole.modify();
                    break;
                case 5: studentConsole.remove();
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
        broadcasting.broadcastln(" Student Menu");
        broadcasting.broadcastln("========================================");
        broadcasting.broadcastln(" 1. Register    Student");
        broadcasting.broadcastln(" 2. Find(email) Student");
        broadcasting.broadcastln(" 3. Find(name)  Student");
        broadcasting.broadcastln(" 4. Modify      Student");
        broadcasting.broadcastln(" 5. Remove      Student");
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
