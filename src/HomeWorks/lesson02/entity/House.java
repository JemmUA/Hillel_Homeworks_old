package HomeWorks.lesson02.entity;

public class House {
    // Data
    private House house;
    private String name;
    private boolean doorIsLocked ;
    private boolean lightIsON;
    private double temperature;
    private Human masterHuman;
    private TVset samsungTV;
    private WashingMachine zanussi;
    private HomeHelper homehelperOne;

    // Constructors
    public  House() {
        this.name = "";
        this.doorIsLocked = true;
        this.lightIsON = false;
        this.temperature = 18;
        masterHuman = new Human("Master", 55 , "man", 187.5, 99, false, 'A', 3, 100, 5);
        samsungTV = new TVset(false, 3, 15);
        zanussi = new WashingMachine();
        homehelperOne = new HomeHelper("R2D2", false);    Human masterHuman = new Human("Master", 55 , "man", 187.5, 99, false, 'A', 3, 100, 5);
    }
    public House(String name, boolean doorIsLocked, boolean lightIsON, double temperature) {
        this.name = name;
        this.doorIsLocked = doorIsLocked;
        this.lightIsON = lightIsON;
        this.temperature = temperature;
    }

    public House(String name, boolean doorIsLocked, boolean lightIsON, double temperature, Human masterHuman, TVset samsungTV, WashingMachine zanussi, HomeHelper homehelperOne) {
        this.name = name;
        this.doorIsLocked = doorIsLocked;
        this.lightIsON = lightIsON;
        this.temperature = temperature;
        this.masterHuman = masterHuman;
        this.samsungTV = samsungTV;
        this.zanussi = zanussi;
        this.homehelperOne = homehelperOne;
    }



//Methods
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setLightIsON(boolean lightIsON) {
        this.lightIsON = lightIsON;
        if (lightIsON == true) {
            System.out.println("Light is ON");
        } else {
            System.out.println("Light is OFF");
        }

    }
    public boolean getLightIsON() {
        return lightIsON;
    }
    public void setDoorIsLocked(boolean doorIsLocked) {
        this.doorIsLocked = doorIsLocked;
        if (doorIsLocked == true) {
            System.out.println("Door is locked");
        } else {
            System.out.println("Door is unlocked");
        }
    }

    public boolean getDoorIsLocked() {
        return doorIsLocked;
    }

    public void setTemperature(int temperature) {
        this.temperature = (double)temperature;
        System.out.println("Current temperature is: " + (int)temperature + "°C, enjoy");
    }
    public double getTemperature() {
        System.out.println("Current temperature is: " + (int)temperature + "°C, enjoy");
        return temperature;
    }

    public void setMasterHuman(Human masterHuman) {
        this.masterHuman = masterHuman;
    }

    public void setSamsungTV(TVset samsungTV) {
        this.samsungTV = samsungTV;
    }

    public void setZanussi(WashingMachine zanussi) {
        this.zanussi = zanussi;
    }

    public void setHomehelperOne(HomeHelper homehelperOne) {
        this.homehelperOne = homehelperOne;
    }

    public Human getMasterHuman() {
        return masterHuman;
    }

    public TVset getSamsungTV() {
        return samsungTV;
    }

    public WashingMachine getZanussi() {
        return zanussi;
    }

    public HomeHelper getHomehelperOne() {
        return homehelperOne;
    }

    public void sayHuman(String speech) {
        masterHuman.say(speech);
    }
    public String getHelperName() {
        return homehelperOne.getName();
    }

}
