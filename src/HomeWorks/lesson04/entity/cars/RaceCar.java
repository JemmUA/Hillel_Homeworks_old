package HomeWorks.lesson04.entity.cars;

public abstract class RaceCar extends Car{
    //Data
    private int carNumber;
    private int rearWing;
    private int diffuser;
    private float pitStopTime;

    //Constructor
    public RaceCar() {
    }

    public RaceCar(String model, String color, float engineVolume, int weight, int fuelTank, float fuelConsumption, double fuelLevel, int maxSpeed, int carNumber, int rearWing, int diffuser, float pitStopTime) {
        super(model, color, engineVolume, weight, fuelTank, fuelConsumption, fuelLevel, maxSpeed);
        this.carNumber = carNumber;
        this.rearWing = rearWing;
        this.diffuser = diffuser;
        this.pitStopTime = pitStopTime;
    }

    // Getters and setters
    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getRearWing() {
        return rearWing;
    }

    public void setRearWing(int rearWing) {
        this.rearWing = rearWing;
    }

    public int getDiffuser() {
        return diffuser;
    }

    public void setDiffuser(int diffuser) {
        this.diffuser = diffuser;
    }

    public float getPitStopTime() {
        return pitStopTime;
    }

    public void setPitStopTime(float pitStopTime) {
        this.pitStopTime = pitStopTime;
    }

    //Skills
    public String getModelAndNumber(String suffix) {
        return getModel() + " #" + getCarNumber() + suffix;
    }
    public void standingStart() {
        System.out.println(getModelAndNumber(" ") + "performed standing start");
    }
    public void rollingStart() {
        System.out.println(getModelAndNumber(" ") + "performed rolling start");
    }
    public float pitStop () {
        pitStopTime = (float)(2 + 1.5 * Math.random());
        System.out.println(getModelAndNumber(" ") + "performed pit stop: "
                + String.format("%.1f", pitStopTime)  + " sec");
        return pitStopTime;
    }
    public void returnToBoxes(){
        System.out.println(getModelAndNumber(" ") + "returned to boxes");
    }

    public void drive(int laps) {
        System.out.print(this.getModelAndNumber(" ") + "traveled " + laps + " laps");
        if (laps == 1 ) System.out.print("\b");
        System.out.println();
    }
    @Override
    public void refuel(int addFuel) {
        System.out.print(this.getModelAndNumber(". ") + "Refueling: ");
        if (addFuel < 0) {
            System.out.println("You can't remove fuel!");
        } else {
            if (addFuel + getFuelLevel() <= getFuelTank()) {
                setFuelLevel(getFuelLevel() + addFuel) ;
                System.out.println("added " + addFuel + " L. Level of fuel: " + getFuelLevel() + " L");
            } else {
                System.out.println("fuel added " + (getFuelTank() - getFuelLevel())  + " L. Fueltank is full: " + getFuelTank() + " L");
                setFuelLevel(getFuelTank());
            }
        }
    }
}
