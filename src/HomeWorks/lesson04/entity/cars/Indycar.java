package HomeWorks.lesson04.entity.cars;

public final class Indycar extends RaceCar{
    //Data
    private int frontWing;
    private int TC;

    //Constructors
    public Indycar(String model, String color, float engineVolume, int weight, int fuelTank, float fuelConsumption, double fuelLevel, int maxSpeed, int carNumber, int rearWing, int diffuser, float pitStopTime, int frontWing, int TC, int i) {
        super(model, color, engineVolume, weight, fuelTank, fuelConsumption, fuelLevel, maxSpeed, carNumber, rearWing, diffuser, pitStopTime);
        this.frontWing = frontWing;
        this.TC = TC;
    }

    //Getters and setters
    public int getFrontWing() {
        return frontWing;
    }

    public void setFrontWing(int frontWing) {
        this.frontWing = frontWing;
    }

    public int getTC() {
        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
    }
    //Skills
    public void plusTC() {
        TC++;
        if (TC > 8) TC = 1;
        System.out.println(getModelAndNumber(" - ") + "Traction control +: " + TC);
    }

    public void minusTC() {
        TC--;
        if (TC < 1) TC = 8;
        System.out.println(getModelAndNumber(" - ") + "Traction control -: " + TC);
    }

    //Implementing interfaces

    @Override
    public void makeDiagnostic(){
        System.out.println(getModelAndNumber(" - ") + "performed full diagnostic." );
    }
    @Override
    public void makeReport() {
        System.out.println(getModelAndNumber(" - ") + "The report has been created." );
    }


    @Override
    public void changeEngine() {
        System.out.println(getModelAndNumber(" - ") + "engine changed.");

    }
    @Override
    public void changeWings(String wingFrontRear){
        //front, rear
        System.out.println(getModelAndNumber(" - ") + wingFrontRear +" wing changed.");
    }
    @Override
    public void changeGearbox(){
        System.out.println(getModelAndNumber(" - ") + "gearbox changed.");
    }
    @Override
    public void changeChassis(){
        System.out.println(getModelAndNumber(" - ") + "chassis changed.");
    }

    @Override
    public void setNewTyres(String tyresType){
        //slick, wet, intermediate
        System.out.println(getModelAndNumber(" - ") + tyresType +"tyres set.");
    }

    @Override
    public void setUp(){
        System.out.println(getModelAndNumber(" - ") + "Car setup performed.");
    }

}
