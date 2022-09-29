package HomeWorks.lesson09.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesHelper {

    public void detectPattern(String string){

        // STRICT MATCHES ======================

        // Check phone (UA)
        // Formats:
        // +38 (XXX) XXX-XX-XX      or      +38 (XXX) XXX XX XX     or      +38 (XXX) XXXXXXX
        // 8 (XXX) XXX-XX-XX
        // (XXX) XXX-XX-XX

        Pattern pattern = Pattern.compile("(((\\+38|8)\s)|)\\(\\d{3}\\)\\s\\d{3}((-|\\s|)\\d{2}){2}");
        Matcher matcher = pattern.matcher(string);
        boolean strictMatch = matcher.matches();
        if (strictMatch) {
            System.out.println(String.format("Detected phone: %s", string));
        } else {
            matcher = pattern.matcher(" ".concat(string));
            int i = 0;
            while (matcher.find()) ++i ;
            if (i > 0) System.out.println(String.format("Phone matches found: %d", i));
        }

        //Check e-mail
        pattern = Pattern.compile("[A-Za-z\\d!#$%&'*+-\\/=?^_`{|]{1,64}@[A-Za-z\\d.-]{1,253}.[A-Za-z]{3}");
        matcher = pattern.matcher(string);
        strictMatch = matcher.matches();
        if (strictMatch) {
            System.out.println(String.format("Detected e-mail: %s", string));
        } else {
            matcher = pattern.matcher(" ".concat(string));
            int i = 0;
            while (matcher.find()) ++i ;
            if (i > 0) System.out.println(String.format("E-mail matches found: %d", i));
        }

        //Check Date of birth
        // dd.mm.yyyy
        // dd month yyyy
        pattern = Pattern.compile("([0-2]\\d|3[0-1])((\\.(0\\d|1[0-2])\\.)|(\\s+[а-яА-ЯёЁa-zA-Z]+\\s+))\\d{4}");
        matcher = pattern.matcher(string);
        strictMatch = matcher.matches();
        if (strictMatch) {
            System.out.println(String.format("Detected birthday: %s", string));
        } else {
            matcher = pattern.matcher(" ".concat(string));
            int i = 0;
            while (matcher.find()) ++i ;
            if (i > 0) System.out.println(String.format("Date of birth matches found: %d", i));
        }
        System.out.println("-------------------------------");
    }

}
