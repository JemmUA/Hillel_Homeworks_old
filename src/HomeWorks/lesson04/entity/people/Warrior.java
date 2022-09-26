package HomeWorks.lesson04.entity.people;

public final class Warrior extends Professional{
    //Data
    int cartridges ;
    int grenades;
    int armor;
    //Constructors

    public Warrior() {
    }

    public Warrior(String name, String surName, int age, String sex, int health, String profession, int skillLevel, int cartridges, int grenades, int armor) {
        super(name, surName, age, sex, health, profession, skillLevel);
        this.cartridges = cartridges;
        this.grenades = grenades;
        this.armor = armor;
    }
    // Getters and setters

    public int getCartridges() {
        return cartridges;
    }

    public void setCartridges(int cartridges) {
        this.cartridges = cartridges;
    }

    public int getGrenades() {
        return grenades;
    }

    public void setGrenades(int grenades) {
        this.grenades = grenades;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    //Skills
    public void defend(String underThreat) {
        System.out.println(getProfNameSurname() + " defends " + underThreat);
    }

    //Implementing interfaces
    @Override
    public void makeDiagnostic(){
        System.out.println(getProfNameSurname() + " checks his weapon." );
    }
    @Override
    public void makeReport() {
        System.out.println(getProfNameSurname() + " reports on the state of the weapon." );
    }


    @Override
    public void makeJob(String underThreat) {
        System.out.println(getProfNameSurname() + " protects peaceful life of " + underThreat + "."  );
    }
    @Override
    public void doBest(String underThreat) {
        System.out.println(getProfNameSurname() + " acts quickly, bravely and professionally to protect " + underThreat + "." );
    }

    @Override
    public void haveRest () {
        System.out.println(getProfNameSurname() + " has a rest in silence after battle. ");
    }
    @Override
    public void getSalary () {
        System.out.println(getProfNameSurname() + " receives a salary and sends it to relatives." );
    }
    @Override
    public void getSatisfaction () {
        System.out.println(getProfNameSurname() + " gets fame and love for protection." );
    }

}
