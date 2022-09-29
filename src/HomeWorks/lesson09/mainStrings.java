package HomeWorks.lesson09;
import HomeWorks.lesson09.entity.MatchesHelper;
import HomeWorks.lesson09.entity.StringHelper;

import java.util.Scanner;


public class mainStrings {
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

        String[] emails = {
                "simple@example.com",
                "very.common@example.com",
                "disposable.style.email.with+symbol@example.com",
                "other.email-with-hyphen@example.com",
                "fully-qualified-domain@example.com",
                "user.name+tag+sorting@example.com ",
                "x@example.com",
                "example-indeed@strange-example.com",
                "test/test@test.com",
                "admin@mailserver1",
                "example@s.example"};
        for (String email: emails)
            matchesHelper.detectPattern(email);
        System.out.println();

        String[] birthdays = {
                "31.01.2012",
                "27 листопада 2001"};
        for (String birthday: birthdays)
            matchesHelper.detectPattern(birthday);
        //MatchesHelper test END ============================
        System.out.println("----- Test END -----");


        //MatchesHelper HOMEWORK
        System.out.println();
        System.out.println("----- Homework -----");
//        String myPattern =
//                "Place here phone, e-mail or date of birth";
//        matchesHelper.detectPattern(myPattern);

        boolean notTired = true;
        System.out.println("Type here phone, e-mail or date of birth \nOR \"q\" for exit");
        Scanner typeScanner = new Scanner(System.in);
        while (notTired){
            String type = typeScanner.nextLine();
            if (type.toLowerCase().equals("q")){
                notTired = false;
            } else {
                matchesHelper.detectPattern(type);
            }
        }
        System.out.println("Homework is over.");
        System.out.println("Good luck! :)");
        typeScanner.close();
    }
}
