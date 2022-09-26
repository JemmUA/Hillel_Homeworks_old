package HomeWorks.lesson03.entity;

import HomeWorks.lesson03.mainInheritance;

public class Support extends User{

    public Support() {
    }

    public Support(String name) {
        super(name);
    }

    public Support(String name, String surName, String mail) {
        super(name, surName, mail);
    }

    public Support(String name, String surName, String mail, String passWord, String sex, String country) {
        super(name, surName, mail, passWord, sex, country);
    }

    public Boolean checkString(String checkStr) {
        for (String stringOfQuatrain : mainInheritance.quatrain) {
            if (stringOfQuatrain.indexOf(checkStr) >= 0) {
                System.out.println("String consists in quatrain");
                return true;
            }
        }
        System.out.println("String does not consist in quatrain");
        return false;
    }
}
