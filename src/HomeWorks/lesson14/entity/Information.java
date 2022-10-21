package HomeWorks.lesson14.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Information {

    private ArrayList<String> nicksList = new ArrayList <>();
    private HashSet<String> mailsList = new HashSet <>();
    private HashMap<String, String> mailNickMap = new HashMap<>();


    public ArrayList<String> getNicksList() {
        return nicksList;
    }

    public void setNicksList(ArrayList<String> nicksList) {
        this.nicksList = nicksList;
    }

    public HashSet<String> getMailsList() {
        return mailsList;
    }

    public void setMailsList(HashSet<String> mailsList) {
        this.mailsList = mailsList;
    }

    public HashMap<String, String> getMailNickMap() {
        return mailNickMap;
    }

    public void setMailNickMap(HashMap<String, String> mailNickMap) {
        this.mailNickMap = mailNickMap;
    }
}
