package HomeWorks.lesson02.entity;

public class HomeHelper {
    private String name = new String();
    private boolean power;

    //Constructours
    public HomeHelper() {
        name = "";
        power = false;
    }
    public HomeHelper(String name, boolean power) {
        this.name = name;
        this.power = power;
    }

    //Methods
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPower(boolean power) {
        this.power = power;
        System.out.println(name + ": Home Helper - power is " + power);
    }
    public boolean getPower() {
        return power;
    }
    public void masterCame(House myFlat, TVset samsungTV, WashingMachine zanussi) {
        myFlat.setDoorIsLocked(false);
        myFlat.setLightIsON(true);
        myFlat.getTemperature();
        samsungTV.setPower(true);
        zanussi.setPower(true);
        zanussi.performWashing(5);
        this.say("Oooops! O_o, lets try another one...");
        zanussi.performWashing(4);
        this.say("Glory to heroes!");
        zanussi.setPower(false);
    }

        public void masterGoSleep(House myFlat, TVset samsungTV) {
            myFlat.setDoorIsLocked(true);
            myFlat.setTemperature(18);
            samsungTV.setVolume(3);
            myFlat.setLightIsON(false);
    }


    public void say(String speech) {
        System.out.println(name + ": " + speech);
    }
}
