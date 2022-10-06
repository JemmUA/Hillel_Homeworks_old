package HomeWorks.lesson11.util;

import HomeWorks.lesson11.entity.FileWorkshop;

public class Optimizer {
    public void writeAndLog (String fileData, String myFilePath, String myFileName, boolean append, FileWorkshop fileWorkshop, String currentDateTime, String logFilePath, String logFileName, String remark, char overline, char underline, boolean spaceTop, boolean spaceBottom){
        fileWorkshop.writeFile(myFilePath, myFileName, fileData, append);
        fileWorkshop.writeLog(logFilePath, logFileName, currentDateTime, myFilePath, myFileName, FileWorkshop.getFileLastOperation());

    }
}
