package HomeWorks.lesson11.entity;

import HomeWorks.lesson11.util.Optimizer;

public class AccountWorkshop {
    public boolean registration (User user, FileWorkshop fileWorkshop, Optimizer optimizer, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("REGISTRATION");
        System.out.println("----------------------");
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration started - ".concat(TimeWorkshop.getCurrentDateTime()).concat("\n"), ' ', ' ', false, false);
        boolean registrationPassed = false;

        ScanWorkshop scan = new ScanWorkshop();

        System.out.println("Please, enter new login:");
        String login = scan.readConsole();
        if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return false; // exit
        System.out.println("New login accepted: " + login);
        System.out.println("Please, enter new password:");
        String password = scan.readConsole();
        if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return false; // exit
        System.out.println("Please, repeat new password: " + "*".repeat(password.length()));
        String passwordMatching = scan.readConsole();
        if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return false; // exit
        if (password.equals(passwordMatching)) {
            user.setLogin(login);
            user.setPassword(password);
            System.out.println("New password accepted: " + password);
            System.out.println("Registration SUCCESSFUL" );
            optimizer.writeAndLog(login.concat(",").concat(password), userFilePath, login + ".txt", false, fileWorkshop, TimeWorkshop.getCurrentDateTime(), logFilePath, logFileName, null, ' ', ' ', false, false);
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration successfully completed - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            registrationPassed = true;
            user.setStatus("authorize");
        } else {
            System.out.println("Passwords don't match each other.\nRegistration FAILED." );
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration FAILED - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            user.setStatus("register");
        }
        return registrationPassed;
    }
    public boolean authorization (User user, FileWorkshop fileWorkshop, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("AUTHORISATION");
        System.out.println("----------------------");
        boolean authorizationPassed = false;
        ScanWorkshop scan = new ScanWorkshop();
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization started - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);

        System.out.println("Enter login:");
        String login = scan.readConsole();
        if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return false; // exit
        userFileName = login + ".txt";

        if (!fileWorkshop.checkUserExisting(userFilePath, userFileName)){
            System.out.println("User does not exists. Please register!");
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "User does not exists - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);

            user.setStatus("register"); // if user file does not exist - do registration
            return authorizationPassed;
        }
        for (int i = 1; i < 10; i++){ // tries limited by conditions below
            System.out.println("Enter password:");
            String password = scan.readConsole();
            if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return false; // exit
            String[] arrFromFile =  fileWorkshop.readFile(userFilePath, userFileName).split(",");
            //            System.out.println("try " + i);
            if (login.equals(arrFromFile[0].strip()) && password.equals(arrFromFile[1].strip()) ){
                fileWorkshop.writeLogRemark(logFilePath, logFileName, String.format("User: %s. Authorisation successfully completed - %s", login, TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                System.out.println("Authorization SUCCESSFUL");
                System.out.println(String.format("%s, welcome!", login));
                user.setStatus("work"); // to work
                authorizationPassed = true;
                break;
            } else if (i < 3) {
                System.out.println("WRONG password");
                fileWorkshop.writeLogRemark(logFilePath, logFileName, "WRONG password - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                System.out.println("Please, try again.");
            }  else if (i >= 3) {
                System.out.println("WRONG password");
                System.out.println("Authorization FAILED\nPlease, try later.");
                fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization FAILED - Exit ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                user.setStatus("exit"); // to exit
                break;
            }
        }
        return authorizationPassed;
    }
    public boolean checkExit(String input, User user, FileWorkshop fileWorkshop, String logFilePath, String logFileName) {
        if (input.toLowerCase().equals("q".strip())) {
            user.setStatus("exit"); // to exit
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Emergency exit by Q - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            return true;
        }
        return false;
    }

}
