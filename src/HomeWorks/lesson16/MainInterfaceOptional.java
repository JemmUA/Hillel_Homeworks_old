package HomeWorks.lesson16;

import HomeWorks.lesson16.communication.Communicator;
import HomeWorks.lesson16.communication.Email;
import HomeWorks.lesson16.communication.Messenger;
import HomeWorks.lesson16.communication.Printer;
import HomeWorks.lesson16.entity.Director;
import HomeWorks.lesson16.entity.HelperMail;
import HomeWorks.lesson16.entity.Secretary;

import java.util.ArrayList;

public class MainInterfaceOptional {
    public static void main(String[] args) {

        Communicator.equipmentStatus();
        Email.equipmentStatus();
        Messenger.equipmentStatus();
        Printer.equipmentStatus();
        System.out.println();

        Director director = new Director("Director");
        Secretary secretary = new Secretary("Secretary Hellen");

        director.sayHello(director.getJobTitle());
        secretary.sayHello(secretary.getJobTitle());
        director.requestReport(director.getJobTitle());
        secretary.requestReport(secretary.getJobTitle());
        director.sayGoodbye(director.getJobTitle());
        secretary.sayGoodbye(secretary.getJobTitle());

        HelperMail checkMail = new HelperMail();
        //Check different values
        ArrayList anythingList = new ArrayList();
        anythingList.add("Alex");
        anythingList.add(2022);
        anythingList.add(true);
        anythingList.add(2022.323892F);
        anythingList.add("");
        anythingList.add(new ArrayList());
        anythingList.add(new Object());
        anythingList.add("nick.2022@mail.ua");      // valid email
        anythingList.add("NICK@mail.ua");           // valid email
        anythingList.add("wdwa1@sss22s.sss");       // valid email
        anythingList.add(null);

        //get data from Optional, actually we get valid emails
        for (Object something : anythingList) {
            System.out.println(checkMail.checkOptionalNull(something).orElse("Wrong data!"));
        }
        //getting valid mail
        System.out.println("\nGetting valid mail");
        System.out.println(checkMail.checkOptionalNull("good@mail.ua").orElseThrow());

        //getting error with null
        System.out.println("\nGetting error!");
        System.out.println(checkMail.checkOptionalNull(null).orElseThrow());

    }
}
