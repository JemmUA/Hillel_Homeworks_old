package HomeWorks.lesson11;

import HomeWorks.lesson11.entity.*;
import HomeWorks.lesson11.util.Optimizer;

public class MainAccess {

    public static void main(String[] args) {




        String hwTitle =
                "HOMEWORK 09 for lesson11\n" +
                        "Introduction to I/O. Work with files. The NIO package.\n" +
                        "======================================================";
        System.out.println(hwTitle);

        final String quatrain = "Еней був парубок моторний\n" +
                "І хлопець хоть куди козак,\n" +
                "Удавсь на всеє зле проворний,\n" +
                "Завзятійший од всіх бурлак.\n";

        String currentDateTime = new TimeWorkshop().getCurrentDateTime();

        User user = new User();

        MatchWorkshop matchString = new MatchWorkshop();
//        System.out.println(matchString.checkRegex("lsaasdddd22ssss", "w{4-16}"));
        FileWorkshop fileWorkshop = new FileWorkshop();
        Optimizer optimizer = new Optimizer();

        String quatrainFilePath = "src/resources/poetry/";
        String quatrainFileName = "quatrain.txt";

        String userFilePath = "src/resources/users/";
        String userFileName = "user.txt";

        String logFilePath = "src/resources/logs/";
        String logFileName = "log.txt";

        //check and create folders: log, poetry, users
        fileWorkshop.checkCreatePath(logFilePath + logFileName);
        fileWorkshop.checkCreatePath(quatrainFilePath + quatrainFileName);
        fileWorkshop.checkCreatePath(userFilePath+userFileName);

        //Open homework log session
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Start HOMEWORK #09 - ".concat(currentDateTime)  , '=', '=', true, false);

        // 1.
        quatrain(quatrain, currentDateTime, fileWorkshop, optimizer, quatrainFilePath, quatrainFileName, logFilePath, logFileName);

        //2. and 3. - mixed
        System.out.println("\n------- GETTING ACCESS ------\n! For instant EXIT - type Q !");
        boolean registred = false;
        boolean authorized = false;

        do {
            if (user.getStatus() == "authorize" && !(authorized = new AccountWorkshop().authorization(user, fileWorkshop, userFilePath, userFileName, logFilePath, logFileName)));
            if (user.getStatus() == "register" && (registred = new AccountWorkshop().registration(user, fileWorkshop, matchString, optimizer, userFilePath, userFileName, logFilePath, logFileName)));
        } while ((!user.getStatus().equals("work")) && !(user.getStatus().equals("exit")));


        if (user.getStatus().equals("work")) {
            System.out.println("=================");
            System.out.println("Access is ALLOWED");
            System.out.println("=================");
        }
        if (user.getStatus().equals("exit")) {
            System.out.println("================");
            System.out.println("Access is DENIED");
            System.out.println("================");
        }

        fileWorkshop.writeLogRemark(logFilePath, logFileName, "End HOMEWORK #09 - ".concat(currentDateTime)  , '=', '=', true, false);

    }

    private static void quatrain(String quatrain, String currentDateTime, FileWorkshop fileWorkshop, Optimizer optimizer, String quatrainFilePath, String quatrainFileName, String logFilePath, String logFileName) {
        System.out.println("Task #1. Quatrain.");
        System.out.println("----------------------");
        System.out.println("Wright file, write log");
        optimizer.writeAndLog(quatrain, quatrainFilePath, quatrainFileName, false, fileWorkshop, currentDateTime, logFilePath, logFileName, null, ' ', ' ', false, false);
        System.out.println("Verification file...");
        System.out.println();
        String stringFromFile = fileWorkshop.readFile(quatrainFilePath, quatrainFileName);
        if (stringFromFile.equals(quatrain)) {
            System.out.println(stringFromFile);
            System.out.println(String.format("Writing to the file: \'%s%s\' successfully performed and verified!", quatrainFilePath, quatrainFileName));
        } else {
            System.out.println(String.format("Writing to the file: \n\'%s%s\' \nFailed!", quatrainFilePath, quatrainFileName));
        }
    }
}



