package HomeWorks.lesson04.entity.cars;

public final class Formula1 extends RaceCar{
    //Data
    private int frontWing;
    private boolean drs;
    private boolean ers;
    //Constructors
    public Formula1(String model, String color, float engineVolume, int weight, int fuelTank, float fuelConsumption, double fuelLevel, int maxSpeed, int carNumber, int rearWing, int diffuser, float pitStopTime, int frontWing, boolean drs, boolean ers) {
        super(model, color, engineVolume, weight, fuelTank, fuelConsumption, fuelLevel, maxSpeed, carNumber, rearWing, diffuser, pitStopTime);
        this.frontWing = frontWing;
        this.drs = drs;
        this.ers = ers;
    }
    //Getters and setters

    public int getFrontWing() {
        return frontWing;
    }

    public void setFrontWing(int frontWing) {
        this.frontWing = frontWing;
    }

    public boolean isDrs() {
        return drs;
    }

    public void setDrs(boolean drs) {
        this.drs = drs;
    }

    public boolean isErs() {
        return ers;
    }

    public void setErs(boolean ers) {
        this.ers = ers;
    }

    //Skills
    public void chargeERS() {
        System.out.println(getModelAndNumber(" - ") + "ERS charged");
    }
    public void engageERS() {
        System.out.println(getModelAndNumber(" - ") + "ERS engaged");
    }
    public void drsOn (){
        setDrs(true);
        System.out.println(getModelAndNumber(" - ") + "DRS On");
    }
        public void drsOff (){
        setDrs(false);
        System.out.println(getModelAndNumber(" - ") + "DRS Off");
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
        System.out.println(getModelAndNumber(" - ") + wingFrontRear +"wing changed.");
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
        System.out.println(getModelAndNumber(" - ") + tyresType +" tyres set.");
    }

    @Override
    public void setUp(){
        System.out.println(getModelAndNumber(" - ") + "Car setup performed.");
    }
}
