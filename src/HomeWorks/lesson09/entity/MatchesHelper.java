package HomeWorks.lesson09.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesHelper {

    public void detectPattern(String string){
        // Check phone (UA)
        // Acceptable formats:
        // +38 (XXX) XXX-XX-XX      or      +38 (XXX) XXX XX XX     or      +38 (XXX) XXXXXXX
        // 8 (XXX) XXX-XX-XX
        // (XXX) XXX-XX-XX

        Pattern pattern = Pattern.compile("(((\\+38|8)\s)|)\\(\\d{3}\\)\\s\\d{3}((-|\\s|)\\d{2}){2}");
        Matcher matcher = pattern.matcher(string);
        boolean result = matcher.matches();
//        System.out.println(result);
        if (result) {
            System.out.println(String.format("Phone: %s", string));
            return;
        }

        //Check e-mail
        pattern = Pattern.compile("[A-Za-z\\d!#$%&'*+-\\/=?^_`{|]{1,64}@[A-Za-z\\d.-]{1,253}.[A-Za-z]{3}");
        matcher = pattern.matcher(string);
        result = matcher.matches();
//        System.out.println(result);
        if (result) {
            System.out.println(String.format("E-mail: %s", string));
            return;
        }

        //Check Date of birth
        // dd.mm.yyyy
        // or
        // dd month yyyy
        pattern = Pattern.compile("([0-2]\\d|3[0-1])((\\.(0\\d|1[0-2])\\.)|(\\s+[а-яА-ЯёЁa-zA-Z]+\\s+))\\d{4}");
        matcher = pattern.matcher(string);
        result = matcher.matches();
//        System.out.println(result);
        if (result) {
            System.out.println(String.format("Date of birth: %s", string));
            return;
        }
        System.out.println("Phone, e-mail or date of birth are NOT detected.");
    }

}
