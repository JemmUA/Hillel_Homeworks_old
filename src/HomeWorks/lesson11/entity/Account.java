package HomeWorks.lesson11.entity;

import HomeWorks.lesson11.util.Optimizer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Account {
    public boolean registration (FileWorkshop fileWorkshop, Optimizer optimizer, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("Task #2. Registration.");
        System.out.println("----------------------");
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration started - ".concat(TimeWorkshop.getCurrentDateTime()).concat("\n"), ' ', ' ', false, false);
        boolean registrationPassed = false;

        //Detect existing user // Turned off for further test authorization anyway
//        Path pathToFile = Paths.get(userFilePath + userFileName);
//        if (Files.exists(pathToFile)) {
//            String[] arrFromFile =  fileWorkshop.readFile(userFilePath, userFileName).split(",");
//            try {
//                if (arrFromFile[0].strip() != null && arrFromFile[1].strip() != null) {
//                    System.out.println("User already exists");
//                    registrationPassed = true;  // or just 'return true';
//                    return registrationPassed;
//                } else {
//                System.out.println("User does not exist");
//                }
//            }
//            catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("User does not exists");
//            }
//        }

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
            optimizer.writeAndLog(login.concat(",").concat(password), userFilePath, userFileName, false, fileWorkshop, TimeWorkshop.getCurrentDateTime(), logFilePath, logFileName, null, ' ', ' ', false, false);
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration successfully completed - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            registrationPassed = true;
        } else {
            System.out.println("Passwords don't match.\nRegistration FAILED." );
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration FAILED - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
        }
        return registrationPassed;
    }
    public boolean activation (FileWorkshop fileWorkshop, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("Task #3. Authorisation.");
        System.out.println("----------------------");
        boolean authorizationPassed = false;
        ScanWorkshop scan = new ScanWorkshop();
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization started - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);

        String[] arrFromFile =  fileWorkshop.readFile(userFilePath, userFileName).split(",");

        for (int i = 1; i < 10; i++){ // tries limited by conditions below
            System.out.println("Enter login:");
            String login = scan.readConsole();
            System.out.println("Enter password:");
            String password = scan.readConsole();
            //            System.out.println("try " + i);
            if (login.equals(arrFromFile[0].strip()) && password.equals(arrFromFile[1].strip()) ){
                fileWorkshop.writeLogRemark(logFilePath, logFileName, String.format("User: %s. Authorisation successfully completed - %s", login, TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                System.out.println("Authorization SUCCESSFUL.");
                System.out.println(String.format("%s, welcome!", login));
                authorizationPassed = true;
                break;
            } else if (i < 3) {
                System.out.println("WRONG login or password.");
                System.out.println("Please, try again.");
            }  else if (i >= 3) {
                System.out.println("WRONG login or password.");
                System.out.println("Authorization FAILED. Please, try later.");
                fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization FAILED - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                break;
            }
        }
        return authorizationPassed;
    }
}
