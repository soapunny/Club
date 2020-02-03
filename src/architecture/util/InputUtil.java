package architecture.util;

import java.util.Scanner;

public class InputUtil {
    //
    private Broadcasting broadcasting;
    private Scanner scanner;

    public InputUtil(Broadcasting broadcasting, Scanner scanner){
        this.broadcasting = broadcasting;
        this.scanner = scanner;
    }

    public InputUtil(SpeakingAt speakingAt, Object object, Scanner scanner){
        //
        broadcasting = new Broadcasting(speakingAt, object);
        this.scanner = scanner;
    }

    public String getValueOf(String label){
        broadcasting.broadcast(label+" : ");
        String value = scanner.next();

        return value;
    }
}
