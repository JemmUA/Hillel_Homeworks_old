package HomeWorks.lesson11.util;

import HomeWorks.lesson11.entity.User;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AccountWorkshop {
    public void registration (User user, FileWorkshop fileWorkshop, MatchWorkshop matchString, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("REGISTRATION");
        System.out.println("----------------------");
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration started - ".concat(TimeWorkshop.getCurrentDateTime()).concat("\n"), ' ', ' ', false, false);

        ScanWorkshop scan = new ScanWorkshop();
        String login = null;
        String password = null;
        String passwordMatching = null;
        do {
            System.out.println(String.format("Please, enter new login (%s):", matchString.getLoginRegexDescription()));
            login = scan.readConsole().strip();
            if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return; // exit
            userFileName = login + ".txt";
        } while (!matchString.checkRegex(login, matchString.getLoginRegex()));

        if (checkUserExisting(fileWorkshop, userFilePath, userFileName)){
            System.out.println("User already exists. Please authorise!");
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "User already exists - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            user.setStatusAuthorize(); // if user file does not exist - do authorization
            return;
        }

        System.out.println("New login accepted: " + login);
        do {
            System.out.println(String.format("Please, enter new password (%s):", matchString.getPasswordRegexDescription()));
            password = scan.readConsole().strip();
            if (checkExit(password, user, fileWorkshop, logFilePath, logFileName)) return; // exit
        } while (!matchString.checkRegex(password, matchString.getPasswordRegex()));
        do {
            System.out.println("Please, repeat new password: " + "*".repeat(password.length()));
            passwordMatching = scan.readConsole().strip();
            if (checkExit(passwordMatching, user, fileWorkshop, logFilePath, logFileName)) return; // exit
        } while (!matchString.checkRegex(passwordMatching, matchString.getPasswordRegex()));
        if (password.equals(passwordMatching)) {
            user.setLogin(login);
            user.setPassword(password);
            System.out.println("New password accepted: " + password);
            System.out.println("Registration SUCCESSFUL" );
            fileWorkshop.writeAndLog(login.concat(",").concat(password), userFilePath, login + ".txt", false, fileWorkshop, TimeWorkshop.getCurrentDateTime(), logFilePath, logFileName, null, ' ', ' ', false, false);
            fileWorkshop.writeLogRemark(logFilePath, logFileName, String.format("User: %s. Registration successfully completed - %s", login, TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            user.setStatusAuthorize();
        } else {
            System.out.println("Passwords don't match each other.\nRegistration FAILED." );
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Registration FAILED - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            user.setStatusRegister();
        }
    }
    public void authorization (User user, FileWorkshop fileWorkshop, String userFilePath, String userFileName, String logFilePath, String logFileName) {
        System.out.println();
        System.out.println("AUTHORIZATION");
        System.out.println("----------------------");
        ScanWorkshop scan = new ScanWorkshop();
        fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization started - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);

        System.out.println("Enter login or press 'Enter' for registration :");
        String login = scan.readConsole().strip();
        if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return; // exit
        userFileName = login + ".txt";

        if (!checkUserExisting(fileWorkshop, userFilePath, userFileName) || login.isEmpty()){
            System.out.println("User does not exist. Please register!");
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "User does not exist - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            user.setStatusRegister(); // if user file does not exist - do registration
            return;
        }
        for (int i = 1; i < 10; i++){ // tries limited by conditions below
            System.out.println("Enter password:");
            String password = scan.readConsole().strip();
            if (checkExit(login, user, fileWorkshop, logFilePath, logFileName)) return; // exit
            String[] arrFromFile =  fileWorkshop.readFile(userFilePath, userFileName).split(",");
            if (login.equals(arrFromFile[0].strip()) && password.equals(arrFromFile[1].strip()) ){
                fileWorkshop.writeLogRemark(logFilePath, logFileName, String.format("User: %s. Authorization successfully completed - %s", login, TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                System.out.println("Authorization SUCCESSFUL");
                System.out.println(String.format("%s, welcome!", login));
                user.setStatusWork(); // to work
                break;
            } else if (i < 3) {
                System.out.println("WRONG password");
                fileWorkshop.writeLogRemark(logFilePath, logFileName, "WRONG password - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                System.out.println("Please, try again.");
            }  else if (i >= 3) {
                System.out.println("WRONG password");
                System.out.println("Authorization FAILED\nPlease, try later.");
                fileWorkshop.writeLogRemark(logFilePath, logFileName, "Authorization FAILED - Exit ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
                user.setStatusExit(); // to exit
                break;
            }
        }
    }
    public boolean checkUserExisting(FileWorkshop fileWorkshop, String filePath, String fileName){
        Path pathToFile = Paths.get(filePath + fileName);
        if (Files.exists(pathToFile)){
            String[] arrFromFile = fileWorkshop.readFile(filePath, fileName).split(",");
            try {
                if (arrFromFile[0].strip().equals(fileName)) {
//                    System.out.println("User exists");
                    return true;
                } else {
//                    System.out.println("User does not exist");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("User does not exist");
            }
            return true;
        }
        return false;
    }
    public boolean checkExit(String input, User user, FileWorkshop fileWorkshop, String logFilePath, String logFileName) {
        if (input.toLowerCase().equals("q".strip())) {
            user.setStatusExit(); // to exit
            fileWorkshop.writeLogRemark(logFilePath, logFileName, "Emergency exit by Q - ".concat(TimeWorkshop.getCurrentDateTime()), ' ', ' ', false, false);
            return true;
        }
        return false;
    }

}
