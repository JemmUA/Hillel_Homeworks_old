package HomeWorks.lesson11;

import HomeWorks.lesson11.entity.FileWorkshop;
import HomeWorks.lesson11.entity.ScanWorkshop;
import HomeWorks.lesson11.entity.TimeWorkshop;
import HomeWorks.lesson11.util.Optimizer;

import java.util.Scanner;

public class MainFiles {
    public static String fileLastOperation;
    public static void main(String[] args) {
        String hwTitle =
                "HOMEWORK 09 for lesson11\n" +
                "Introduction to I\\O. Work with files. The NIO package.\n" +
                "======================================================";
        System.out.println(hwTitle);

        String dataToWrite;
        final String quatrain = "Еней був парубок моторний\n" +
                "І хлопець хоть куди козак,\n" +
                "Удавсь на всеє зле проворний,\n" +
                "Завзятійший од всіх бурлак.\n";
        dataToWrite = quatrain;
        String verifyQuatrain;
        String currentDateTime = new TimeWorkshop().getCurrentDateTime();

        FileWorkshop fileWorkshop = new FileWorkshop();
        Optimizer optimizer = new Optimizer();

        String myFilePath = "src/resources/poetry/";
        String myFileName = "quatrain.txt";

        String userFilePath = "src/resources/users/";
        String userFileName = "user.txt";

        String logFilePath = "src/resources/logs/";
        String logFileName = "log.txt";


        // 1.
        System.out.println("Task #1. Quatrain.");
        System.out.println("----------------------");

        //check and create folders
        fileWorkshop.checkCreatePath(logFilePath+logFileName);
        fileWorkshop.checkCreatePath(myFilePath+myFileName);
        fileWorkshop.checkCreatePath(userFilePath+userFileName);

        //Open log session
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Start HOMEWORK #09 - ".concat(currentDateTime)  , '=', '=', true, false);

        System.out.println("Wright file, write log");
        optimizer.writeAndLog(dataToWrite, myFilePath, myFileName, false, fileWorkshop, currentDateTime, logFilePath, logFileName, null, ' ', ' ', false, false);
        System.out.println("Verification file...");
        System.out.println();
        String stringFromFile = fileWorkshop.readFile(myFilePath, myFileName);
        if (stringFromFile.equals(quatrain)) {
            System.out.println(stringFromFile);
            System.out.println(String.format("Writing to the file: \'%s%s\' successfully performed and verified!", myFilePath, myFileName));
        } else {
            System.out.println(String.format("Writing to the file: \n\'%s%s\' \nFailed!", myFilePath, myFileName));
        }

        //2.
        System.out.println();
        System.out.println("Task #2. Registration.");
        System.out.println("----------------------");
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration started - ".concat(currentDateTime), ' ', ' ', false, false);
        boolean regPassed = false;
        ScanWorkshop scan = new ScanWorkshop();

        System.out.println("Please, enter new login:");
        String login = scan.readConsole();
        System.out.println("New login accepted: " + login);
        System.out.println("Please, enter new password:");
        String password = scan.readConsole();
        System.out.println("Please, repeat new password: " + "*".repeat(password.length()));
        String passwordMatching = scan.readConsole();
        if (password.equals(passwordMatching)) {
            System.out.println("New password accepted: " + password);
            System.out.println("Registration SUCCESSFUL." );
            optimizer.writeAndLog(login.concat(",").concat(password), userFilePath, userFileName, false, fileWorkshop, currentDateTime, logFilePath, logFileName, null, ' ', ' ', false, false);
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration successfully completed - ".concat(currentDateTime), ' ', ' ', false, false);
            regPassed = true;
        } else {
            System.out.println("Passwords don't match.\nRegistration FAILED." );
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration FAILED - ".concat(currentDateTime), ' ', ' ', false, false);
        }

        //3.
        if (regPassed) {
            System.out.println();
            System.out.println("Task #3. Authorisation.");
            System.out.println("----------------------");
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization started - ".concat(currentDateTime), ' ', ' ', false, false);

            String[] arrFromFile =  fileWorkshop.readFile(userFilePath,userFileName).split(",");

            for (int i = 1; i < 10; i++){
                System.out.println("Enter login:");
                login = scan.readConsole();
                System.out.println("Enter password:");
                password = scan.readConsole();
    //            System.out.println("try " + i);
                if (login.equals(arrFromFile[0].strip()) && password.equals(arrFromFile[1].strip()) ){
                    fileWorkshop.writeLogRemark(logFilePath, logFileName, String.format("%s - User: %s. Authorisation successfully completed.", currentDateTime, login), ' ', ' ', false, false);
                    System.out.println("Authorization SUCCESSFUL.");
                    System.out.println(String.format("Welcome %s!", login));
                    break;
                } else if (i < 3) {
                    System.out.println("WRONG login or password.");
                    System.out.println("Please, try again.");
                }  else if (i >= 3) {
                    System.out.println("WRONG login or password.");
                    System.out.println("Authorization FAILED. Please, try later.");
                    fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization FAILED - ".concat(currentDateTime), ' ', ' ', false, false);
                    break;
                }
            }
        } else {
            System.out.println("\nPlease, register before authorization.");
        }
        System.out.println("======================================");
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "End HOMEWORK #09 - ".concat(currentDateTime)  , '=', '=', true, false);

    }
}



