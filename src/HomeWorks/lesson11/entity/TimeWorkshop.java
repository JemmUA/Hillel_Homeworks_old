package HomeWorks.lesson11.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeWorkshop {
        public String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }
}
