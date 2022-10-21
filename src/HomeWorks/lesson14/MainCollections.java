package HomeWorks.lesson14;

import HomeWorks.lesson14.entity.Information;
import HomeWorks.lesson14.entity.InitializationData;

import java.util.ArrayList;

public class MainCollections {

//    Homework 11-12. Collections vs Generics
public static void main(String[] args) {

    InitializationData initializationData = new InitializationData();
//    initializationData.fillData(); // test

    ArrayList<Integer> numbersInteger = new  ArrayList<>();
    for (int i = 0; i < 10; i++) numbersInteger.add((int)(Math.round(1000000000 * Math.random()))); // 10 random numbers as nicks

    processingData(numbersInteger, initializationData.fillData()); // Execute HW. End.

}

public static Information processingData(ArrayList<? extends Number> numberList, Information information){
    System.out.println("\n========================================\nCheck and add 10 users\n");
    // accept numbers as nicks
    String defaultMail = "@mail.ua";
    String currentMail = "";

    for (int i = 0; i < numberList.size(); i++){
        currentMail = numberList.get(i) + defaultMail;
        if ( ! information.getMailsList().contains(currentMail)){
            System.out.println("Current mail '" + currentMail + "' is absent in set of 'information'. Addition data allowed.");
            information.getNicksList().add(String.valueOf(numberList.get(i))); //write nick
            information.getMailsList().add(numberList.get(i) + currentMail); //write mail
            information.getMailNickMap().put(String.valueOf(numberList.get(i)), currentMail); //write mail-nick
        }
    }
    System.out.println("\n========================================\nlets check all lists. Mamamia,  hold on )))");
    new InitializationData().printCollections(information); // make work for garbage collector
    System.out.println("\nTadaaaaaaaaaaa )))");

    return information;
}

}
