package architecture.layer.ui.console;

import architecture.util.Broadcasting;
import architecture.util.InputUtil;
import architecture.util.SpeakingAt;

import java.util.Scanner;

public class StudentConsole {
    //
    private Broadcasting broadcasting;
    private InputUtil inputUtil;

    //TODO
    //private StudentBusiness studentBusiness;

    public StudentConsole(Scanner scanner) {
        //
        broadcasting = new Broadcasting(SpeakingAt.Left, this);
        inputUtil = new InputUtil(broadcasting, scanner);
    }

    public void register(){
        //
    }

    public void findById() {
        //
    }

    public void findByName() {
        //
    }

    public void modify(){
        //
    }

    public void remove(){
        //
    }
}
