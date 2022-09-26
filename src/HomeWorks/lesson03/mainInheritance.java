package HomeWorks.lesson03;

import HomeWorks.lesson03.entity.Admin;
import HomeWorks.lesson03.entity.CheckService;
import HomeWorks.lesson03.entity.Support;
import HomeWorks.lesson03.entity.User;

public class mainInheritance {
    //Define constant
    public static String[] quatrain = {
            "Земля і небо борються в мені,",
            "І хто кого подужає — не знаю.",
            "Люблю простори неба осяйні",
            "І до землі любов велику маю"
    };
    //Declare string for check
    public static String stringForCheck = "";
    public static boolean stringIsOk = false;

    public static void main(String[] args) {
        // Homework ===========

        System.out.println("Homework 03 ===========");
        System.out.println();
        //Show quatrain
        System.out.println("Quatrain:");

        for (int i = 0; i < quatrain.length; i++) {
            System.out.println(quatrain[i]);
        }
        System.out.println();

        //Creating new User, Support, Admin, CheckService
        User userOne = new User("John", "Peterson", "john.petterson@gmail.com", "pass", "man", "United Kingdom");
        Support supportOne = new Support("Hellen", "Fine", "hellen.fine@gmail.com", "supportHELLEN26", "woman", "USA");
        Admin adminOne = new Admin("Andrew", "Petrenko", "andrew.edisson@gmail.com", "%*$5Dsds_!jYUHOuaw74hd", "man", "Ukraine");
        CheckService checkService = new CheckService();

        checkService.inputString(userOne);
        System.out.println("-------------------------------------");
        checkService.inputString(supportOne);
        System.out.println("-------------------------------------");
        checkService.inputString(adminOne);
        System.out.println("-------------------------------------");


        // End of Homework ===========



/*

        // Test block =========

        System.out.println();
        System.out.println("Test block =========");

        stringForCheck = "простори";
        System.out.println();

        System.out.println(userOne.getName() + " (" + userOne.getClassShort(userOne.getClass().getName()) + ")" +
                ", you can't check the string \"" + stringForCheck + "\" in Quatrain ");

        System.out.println();
        System.out.println(supportOne.getName() + " (" + supportOne.getClassShort(supportOne.getClass().getName()) + ")" +
                ", please note - the string \"" + stringForCheck + "\" presents in Quatrain: " +  supportOne.checkString(stringForCheck));

        System.out.println();
        stringForCheck = "знаю";
        System.out.println(adminOne.getName()  + " (" + adminOne.getClassShort(adminOne.getClass().getName()) + ")" +
                ", admit please - the string \"" + stringForCheck + "\" presents in Quatrain: " +  adminOne.checkString(stringForCheck));

        System.out.println();
        userOne.read(userOne.getName() + ", let's type!");
        userOne.write();
        supportOne.read(supportOne.getName() + ", type something.");
        supportOne.write();
        adminOne.read(adminOne.getName() + ", type what you need, pls.");
        adminOne.write();
        System.out.println(stringForCheck);
        adminOne.clearIfWrong(adminOne.checkString(stringForCheck));
        // End of test block =========
        System.out.println("End of test block =========");*/
    }
}
