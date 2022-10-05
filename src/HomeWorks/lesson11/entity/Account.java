package HomeWorks.lesson11.entity;

import HomeWorks.lesson11.util.Optimizer;

public class Account {
    public boolean registration (FileWorkshop fileWorkshop, Optimizer optimizer, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("Task #2. Registration.");
        System.out.println("----------------------");
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration started - ".concat(TimeWorkshop.getCurrentDateTime()).concat("\n"), ' ', ' ', false, false);
        boolean registrationPassed = false;
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

        for (int i = 1; i < 10; i++){
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
