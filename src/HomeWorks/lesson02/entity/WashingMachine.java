package HomeWorks.lesson02.entity;

public class WashingMachine {
    private boolean power;
    private String[] modesArray;

    // Constructors
    public WashingMachine() {
    power = false;
    modesArray = new String[4];
    modesArray[0] = "Short Mode";
    modesArray[1] = "Long Mode";
    modesArray[2] = "Soft Mode";
    modesArray[3] = "Bavovna";
    }
    public WashingMachine(boolean power, String[] modesArray) {
        this.power = power;
        this.modesArray = modesArray;
    }

    // Methods
    public void setPower(boolean power) {
        this.power = power;
        System.out.println("Washing Machine: power is: " + power);
    }
    public boolean getPower() {
        return power;
    }
    public void setModesArray(String[] modesArray) {
        this.modesArray = modesArray;
    }
    public String[] getModesArray() {
        return modesArray;
    }
    public void performWashing (int mode){
        switch (mode){
            case 1:
                System.out.println("Washing Machine: Performed mode \"" + modesArray[0] + "\". All is clean");
                break;
            case 2:
                System.out.println("Washing Machine: Performed mode \"" + modesArray[1] + "\". All is clean");
                break;
            case 3:
                System.out.println("Washing Machine: Performed mode \"" + modesArray[2] + "\". All is clean");
                break;
            case 4:
                System.out.println("Washing Machine: Performed mode \"" + modesArray[3] + "\". All is clean. Glory to Ukraine!");
                break;
            default:
                System.out.println("Washing Machine: Wrong mode "+ mode + ". Performing canceled.");

        }

        }
}
