package HomeWorks.lesson09;
import HomeWorks.lesson09.entity.MatchesHelper;
import HomeWorks.lesson09.entity.StringHelper;

import java.util.Scanner;


public class MainStrings {
    public static void main(String[] args) {

        //Homework #07 for lesson #09

        //StringHelper HOMEWORK
        String string = "            My string    ";
        char[] array = "      and array   "
                .toCharArray();
        StringHelper testString = new StringHelper();
        testString.transform(string, array);

        MatchesHelper matchesHelper = new MatchesHelper();

        //MatchesHelper test ==========================
        System.out.println();
        System.out.println("-------TEST-------");
        System.out.println("PHONE");
        String[] phones = {
                "+38 (050) 334-33-45",
                "8 (050) 334-33-45",
                "(050) 334-33-45",
                "+38 (050) 334 33 45",
                "8 (050) 334 33 45",
                "(050) 334 33 45",
                "+38 (050) 3343345",
                "8 (050) 3343345",
                "(050) 3343345"};
        for (String phone: phones)
            matchesHelper.detectPattern(phone);
        System.out.println();

        System.out.println("E-MAIL");
        String[] emails = {
                "simple@example.com",
                "very.common@example.com",
                "disposable.style.email.with+symbol@example.com",
                "other.email-with-hyphen@example.com",
                "fully-qualified-domain@example.com",
                "x@example.com",
                "example-indeed@strange-example.com",
                "test/test@test.com",
                "example@s.example"};
        for (String email: emails)
            matchesHelper.detectPattern(email);
        System.out.println();

        System.out.println("BIRTHDAY");
        String[] birthdays = {
                "31.01.2012",
                "27 листопада 2001"};
        for (String birthday: birthdays)
            matchesHelper.detectPattern(birthday);

        System.out.println();
        System.out.println("Finding matches for string:");
        System.out.println("31.01.2012 +38 (050) 334-33-45 simple@example.com +38 (050) 334 33 45 27 листопада 2001 very.common@example.com 8 (050) 334 33 45 admin@mailserver1 ");
        matchesHelper.detectPattern("31.01.2012 +38 (050) 334-33-45 simple@example.com +38 (050) 334 33 45 27 листопада 2001 very.common@example.com 8 (050) 334 33 45 admin@mailserver1 ");
        //MatchesHelper test END ============================
        System.out.println("----- Test END -----");

        //MatchesHelper HOMEWORK
        System.out.println();
        System.out.println("----- Input -----");
//        String myPattern =
//                "Place here phone, e-mail or date of birth";
//        matchesHelper.detectPattern(myPattern);

        boolean notTired = true;
        Scanner typeScanner = new Scanner(System.in);
        System.out.println("Please, type phone, e-mail or date of birth for strict matches\nOR string to find matches \nOR type \"q\" for exit:");
        while (notTired){
            String type = typeScanner.nextLine();
            if (type.toLowerCase().equals("q")){
                notTired = false;
            } else {
                matchesHelper.detectPattern(type);
                System.out.println("Try again OR type \"q\" for exit:");
            }
        }
        System.out.println("===============================");
        System.out.println("Homework is over. Good luck! :)");

        typeScanner.close();
    }
}
