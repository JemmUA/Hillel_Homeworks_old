package HomeWorks.lesson11.entity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileWorkshop {
    static String fileLastOperation;

    public static String getFileLastOperation() {
        return fileLastOperation;
    }

    public static void setFileLastOperation(String fileLastOper) {
        fileLastOperation = fileLastOper;
    }
    public void checkCreatePath (String path) {
        Path pathToFile = Paths.get(path);
        if (!Files.exists(pathToFile.getParent())) {
            try {
                Files.createDirectories(pathToFile.getParent());
            } catch (IOException e) {
                System.err.println("Creating file path failed");
//                throw new RuntimeException(e);
            }
        }
    }

    public String readFile (String filePath, String fileName){
        StringBuilder fileContent = new StringBuilder();
        try (FileReader fileReader = new FileReader(filePath + fileName);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
                fileContent.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
//            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Input/Output error");
//            throw new RuntimeException(e);
        }
//        System.out.println(fileContent);
        return fileContent.toString();
    }
    public void writeFile (String filePath, String fileName, String fileData, boolean append) {
        try (FileWriter fileWriter = new FileWriter(filePath + fileName, append )) {
            fileWriter.write(fileData);
        }
        catch (IOException e) {
            System.err.println("Invalid file path");
            throw new RuntimeException(e);
        }
        fileLastOperation = append ? "append" : "rewrite";
    }
    public void writeLog(String logPath, String logName, String currDateTime, String filePath, String fileName, String fileOperation) {
        String logData = String.format("File %s: %s%s - %s\n", fileOperation, filePath, fileName, currDateTime);
        try (FileWriter fileWriter = new FileWriter(logPath + logName, true )) {
            fileWriter.write(logData);
        }
        catch (IOException e) {
            System.err.println("Invalid log file path");
//            throw new RuntimeException(e);
        }
    }
    public void writeLogRemark(String logPath, String logName, String remark, char overline, char underline, boolean spaceTop, boolean spaceBottom) {
        //compiling full remark
        if (remark.length() == 0 || remark == null) return;
        String fullRemark = "";
        if (spaceTop) fullRemark += "\n";
        if (overline != ' ' || overline != '\t' || overline != '\r' || overline != '\n') fullRemark += String.valueOf(overline).repeat(remark.length()).concat("\n");
        fullRemark += remark.concat("\n");
        if (underline != ' ') fullRemark += String.valueOf(underline).repeat(remark.length()).concat("\n");
        if (spaceBottom) fullRemark += "\n";

        try (FileWriter fileWriter = new FileWriter(logPath + logName, true )) {
            fileWriter.write(fullRemark);
        }
        catch (IOException e) {
            System.err.println("Invalid log file path");
        }
    }
}
