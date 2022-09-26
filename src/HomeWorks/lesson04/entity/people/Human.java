package HomeWorks.lesson04.entity.people;

import HomeWorks.lesson04.entity.skills.Diagnostics;
import HomeWorks.lesson04.entity.skills.JobSatisfaction;

public abstract class Human implements Diagnostics, JobSatisfaction {
    //Data
    String name ;
    String surName;
    int age;
    String sex;
    int health;

    //Constructors
    public Human() {
    }

    public Human(String name, String surName, int age, String sex, int health) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.sex = sex;
        this.health = health;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //Skills
    public void say(String speech) {
        System.out.println(this.getClassShort(this.getClass().getName()) + " "   + name + " said: " + speech);
    }
    public void walk(int distance) {
        System.out.println(this.getClassShort(this.getClass().getName()) + name + " walked " + distance + " m");
    }
    public String getClassShort (String classFull) {
        String[] classWords = classFull.split("\\.");
        return classWords[classWords.length-1];
    }
    }
