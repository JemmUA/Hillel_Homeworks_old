package HomeWorks.lesson03.entity;

import HomeWorks.lesson03.MainInheritance;

public class Admin extends Support {

    public Admin() {
    }
    public Admin(String name, String surName, String mail, String passWord, String sex, String country) {
        super(name, surName, mail, passWord, sex, country);
        }
    public void clearIfWrong(boolean booleanData) {
        if (booleanData == true) {
            System.out.println("Quatrain deleted");
            MainInheritance.quatrain = null;
        } else {
            System.out.println("Quatrain is not deleted");
        }

    }

}