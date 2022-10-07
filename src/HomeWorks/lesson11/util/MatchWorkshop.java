package HomeWorks.lesson11.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchWorkshop {
    String loginRegex = "\\w{4,16}";
    String loginRegexDescription = "4-16 symbols or figures with no spaces";

    String passwordRegex = "\\w{4,12}";
    String passwordRegexDescription = "4-12 symbols or figures with no spaces";

    String phoneRegex = "\"(((\\\\+38|8)\\s)|)\\\\(\\\\d{3}\\\\)\\\\s\\\\d{3}((-|\\\\s|)\\\\d{2}){2}\"";
    String phoneRegexDescription = "UA format";

    String emailRegex = "[A-Za-z\\\\d!#$%&'*+-\\\\/=?^_`{|]{1,64}@[A-Za-z\\\\d.-]{1,253}.[A-Za-z]{3}\"";
    String emailRegexDescription = "e-mail standard";

    String dateRegex = "([0-2]\\d|3[0-1])((\\.(0\\d|1[0-2])\\.)|(\\s+[а-яА-ЯёЁa-zA-Z]+\\s+))\\d{4}";
    String dateRegexDescription = "dd.mm.yy or dd month yy";

    public String getLoginRegex() {
        return loginRegex;
    }

    public void setLoginRegex(String loginRegex) {
        this.loginRegex = loginRegex;
    }

    public String getLoginRegexDescription() {
        return loginRegexDescription;
    }

    public void setLoginRegexDescription(String loginRegexDescription) {
        this.loginRegexDescription = loginRegexDescription;
    }

    public String getPasswordRegex() {
        return passwordRegex;
    }

    public void setPasswordRegex(String passwordRegex) {
        this.passwordRegex = passwordRegex;
    }

    public String getPasswordRegexDescription() {
        return passwordRegexDescription;
    }

    public void setPasswordRegexDescription(String passwordRegexDescription) {
        this.passwordRegexDescription = passwordRegexDescription;
    }

    public String getPhoneRegex() {
        return phoneRegex;
    }

    public void setPhoneRegex(String phoneRegex) {
        this.phoneRegex = phoneRegex;
    }

    public String getPhoneRegexDescription() {
        return phoneRegexDescription;
    }

    public void setPhoneRegexDescription(String phoneRegexDescription) {
        this.phoneRegexDescription = phoneRegexDescription;
    }

    public String getEmailRegex() {
        return emailRegex;
    }

    public void setEmailRegex(String emailRegex) {
        this.emailRegex = emailRegex;
    }

    public String getEmailRegexDescription() {
        return emailRegexDescription;
    }

    public void setEmailRegexDescription(String emailRegexDescription) {
        this.emailRegexDescription = emailRegexDescription;
    }

    public String getDateRegex() {
        return dateRegex;
    }

    public void setDateRegex(String dateRegex) {
        this.dateRegex = dateRegex;
    }

    public String getDateRegexDescription() {
        return dateRegexDescription;
    }

    public void setDateRegexDescription(String dateRegexDescription) {
        this.dateRegexDescription = dateRegexDescription;
    }

    public boolean checkRegex(String string, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
