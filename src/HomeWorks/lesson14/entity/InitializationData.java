package HomeWorks.lesson14.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class InitializationData {

    Information information = new Information();
    public Information fillData(){

        String defaultNick = "Nick";
        String mailDomain = "mail.ua";
        String currentNick = "";
        String currenMail = "";

        //fill collections -  30 values for each
        System.out.println("\nFill collections. 30 values for each collection.");
        for (int i = 0; i < 30; i++) {
            currentNick = String.format("%s_%03d", defaultNick, i);
            currenMail = makeMail(currentNick, mailDomain);

            information.getNicksList().add(currentNick);
            information.getMailsList().add(currenMail);
            information.getMailNickMap().put(currenMail,currentNick);
        }

        //watch collections
        printCollections(information);

        //print collections sizes
        System.out.println("\nCollections sizes: ");
        printCollectionsSizes(information);

        //add 10 identical values. For set and map will be added only one value, rest will be rewritten.
        System.out.println("\nAdd 10 identical values to lists.");
        for (int i = 0; i < 10; i++) {
            currentNick = String.format("%s_%03d", defaultNick, 30);
            information.getNicksList().add(currentNick);

            currenMail = String.format("%s@%s",information.getNicksList().get(30).toLowerCase(), mailDomain);
            information.getMailsList().add(currenMail);

            information.getMailNickMap().put(currenMail, currentNick);
        }

        //watch collections
        printCollections(information);

        // watch collections length
        System.out.println("\nCollections sizes: ");
        printCollectionsSizes(information);


        // equalize List Sizes
        equalizeListSizes(information);

        // watch equalized collections length
        System.out.println("\nEqualized collections sizes: ");
        printCollectionsSizes(information);

        return information;
    }

    private void equalizeListSizes (Information information) {
        System.out.print("\nEqualizing List Sizes. ");

        //set is smallest
        int smallestSize = information.getMailsList().size();

        // equalize list sizes
        while (information.getNicksList().size() > smallestSize) {
            information.getNicksList().remove(information.getNicksList().size() - 1);
        }
        if ((smallestSize == information.getNicksList().size()) &&
                (smallestSize == information.getMailsList().size()) &&
                (smallestSize == information.getMailNickMap().size()) ){
            System.out.println("All lists sizes equalizes " + information.getNicksList().size()) ;
        } else {
            System.out.println("Equalizing of lists sizes failed." + information.getNicksList().size());
        }
    }

    private void printCollectionsSizes(Information information){
        System.out.println("nicksList size = " + information.getNicksList().size() +
                ", mailsList size = " + information.getMailNickMap().size() +
                ", mailNickMap size = " + information.getMailNickMap().size());
    }
    public void printCollections(Information information){
        System.out.println(String.format("\nNicknames (Arraylist, size - %d): ", information.getNicksList().size()));
        for (int i = 0; i < information.getNicksList().size(); i++)
            System.out.println(information.getNicksList().get(i));

        System.out.println(String.format("\neMails (set, size - %d): ", information.getMailsList().size()));
        Iterator iteratorMail = information.getMailsList().iterator();
        while (iteratorMail.hasNext()) System.out.println(iteratorMail.next());

        System.out.println(String.format("\nMatches email-nick (map, size - %d): ", information.getMailNickMap().size()));
        String[] emailsNicks = information.getMailNickMap().toString().substring(1, information.getMailNickMap().toString().length() - 1).split(", ");
        for (String emailNick: emailsNicks) System.out.println(emailNick);

    }
    private String makeMail(String nick, String mailDomain){
        return String.format("%s@%s", nick.toLowerCase(), mailDomain);
    }
}
