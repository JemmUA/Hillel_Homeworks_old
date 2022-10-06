package HomeWorks.lesson11.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchWorkshop {
    public boolean checkRegex(String string, String regex){
        Pattern pattern = Pattern.compile("\\w{4,16}");
//        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
