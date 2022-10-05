package HomeWorks.lesson11.entity;

import java.io.IOException;
import java.util.Scanner;

public class ScanWorkshop {
    public String readConsole () {
        String consoleInput = "";
////      Scanner's stream drops after closing. Auto closing fails.
//        try (Scanner scanner = new Scanner(System.in)) {
//            consoleInput = scanner.nextLine().strip();
//        }
        Scanner scanner = new Scanner(System.in);
        consoleInput = scanner.nextLine().strip();
        return consoleInput;
    }
}
