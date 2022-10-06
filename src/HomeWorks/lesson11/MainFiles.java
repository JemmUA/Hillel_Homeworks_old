package HomeWorks.lesson11;

import HomeWorks.lesson11.entity.Account;
import HomeWorks.lesson11.entity.FileWorkshop;
import HomeWorks.lesson11.entity.TimeWorkshop;
import HomeWorks.lesson11.util.Optimizer;

public class MainFiles {
    public static String fileLastOperation;
    public static void main(String[] args) {
        String hwTitle =
                "HOMEWORK 09 for lesson11\n" +
                "Introduction to I\\O. Work with files. The NIO package.\n" +
                "======================================================";
        System.out.println(hwTitle);

        final String quatrain = "Еней був парубок моторний\n" +
                "І хлопець хоть куди козак,\n" +
                "Удавсь на всеє зле проворний,\n" +
                "Завзятійший од всіх бурлак.\n";

        String currentDateTime = new TimeWorkshop().getCurrentDateTime();

        FileWorkshop fileWorkshop = new FileWorkshop();
        Optimizer optimizer = new Optimizer();

        String myFilePath = "src/resources/poetry/";
        String myFileName = "quatrain.txt";

        String userFilePath = "src/resources/users/";
        String userFileName = "user.txt";

        String logFilePath = "src/resources/logs/";
        String logFileName = "log.txt";

        //check and create folders
        fileWorkshop.checkCreatePath(logFilePath+logFileName);
        fileWorkshop.checkCreatePath(myFilePath+myFileName);
        fileWorkshop.checkCreatePath(userFilePath+userFileName);

        //Open log session
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Start HOMEWORK #09 - ".concat(currentDateTime)  , '=', '=', true, false);

        // 1.
        System.out.println("Task #1. Quatrain.");
        System.out.println("----------------------");
        System.out.println("Wright file, write log");
        optimizer.writeAndLog(quatrain, myFilePath, myFileName, false, fileWorkshop, currentDateTime, logFilePath, logFileName, null, ' ', ' ', false, false);
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
        boolean registred = false;
        boolean authorized = false;

        registred = new Account().registration(fileWorkshop, optimizer, userFilePath, userFileName, logFilePath, logFileName);

        //3.
        if (registred) {
            authorized = new Account().activation(fileWorkshop, userFilePath, userFileName, logFilePath, logFileName);
        }


       if (authorized) {
           System.out.println("=================");
           System.out.println("Access is ALLOWED");
           System.out.println("=================");
       } else {
           System.out.println("================");
           System.out.println("Access is DENIED");
           System.out.println("================");
       }

        fileWorkshop.writeLogRemark(logFilePath, logFileName, "End HOMEWORK #09 - ".concat(currentDateTime)  , '=', '=', true, false);

    }
}



