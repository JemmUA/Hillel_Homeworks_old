package HomeWorks.lesson03.entity;
import HomeWorks.lesson03.MainInheritance;

import java.util.Scanner;

public class User {
    //Data
    private String name;
    private String surName;
    private String mail;
    private String passWord;
    private String sex;
    private String country;


    //Constructors
    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(String name, String surName, String mail) {
        this.name = name;
        this.surName = surName;
        this.mail = mail;
    }

    public User(String name, String surName, String mail, String passWord, String sex, String country) {
        this.name = name;
        this.surName = surName;
        this.mail = mail;
        this.passWord = passWord;
        this.sex = sex;
        this.country = country;
    }

    //Methods
    //Setters and Getters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getCountry() {
        return country;
    }



    public void read(String message) {
        System.out.println(message);
    }
    public void write() {
        System.out.println("please, type text:");
        Scanner typeScanner = new Scanner(System.in);
        String type = typeScanner.nextLine();
        MainInheritance.stringForCheck = type;
//        typeScanner.close();
        System.out.println("Typed: " + MainInheritance.stringForCheck);
    }
    public String getClassShort (String classFull) {
        String[] classWords = classFull.split("\\.");
        return classWords[classWords.length-1];
    }

}
