package HomeWorks.lesson04.entity.people;

public abstract class Professional extends Human{
    //Data
    String profession ;
    int skillLevel;

    //Constructors
    public Professional() {
    }

    public Professional(String name, String surName, int age, String sex, int health, String profession, int skillLevel) {
        super(name, surName, age, sex, health);
        this.profession = profession;
        this.skillLevel = skillLevel;
    }

// Getters and setters

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
    public String getProfNameSurname() {
        return this.getClassShort(this.getClass().getName()) + " " + name + " " + surName;
    }

    //Skills
    public void study () {
        System.out.println(getProfNameSurname() + " replenishes his knowledge");
    }
    public void practice () {
        System.out.println(getProfNameSurname() + " improves his skills with practice");
    }
}
