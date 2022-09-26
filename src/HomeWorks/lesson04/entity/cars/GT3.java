package HomeWorks.lesson04.entity.cars;

public final class GT3 extends RaceCar {
    //Data
    private int splitter;
    private int engineMode;
    private int abs;
    //Constructors
    public GT3(String model, String color, float engineVolume, int weight, int fuelTank, float fuelConsumption, double fuelLevel, int maxSpeed, int carNumber, int rearWing, int diffuser, float pitStopTime, int splitter, int engineMode, int abs) {
        super(model, color, engineVolume, weight, fuelTank, fuelConsumption, fuelLevel, maxSpeed, carNumber, rearWing, diffuser, pitStopTime);
        this.splitter = splitter;
        this.engineMode = engineMode;
        this.abs = abs;
    }
    //Getters and setters


    public int getSplitter() {
        return splitter;
    }

    public void setSplitter(int splitter) {
        this.splitter = splitter;
    }

    public int getEngineMode() {
        return engineMode;
    }

    public void setEngineMode(int engineMode) {
        this.engineMode = engineMode;
    }

    public int getABS() {
        return abs;
    }

    public void setABS(int abs) {
        this.abs = abs;
    }

    //Skills
    public void plusEngineMode() {
        engineMode++;
        if (engineMode > 5) engineMode = 1;
        System.out.println(getModel() + " #" + getCarNumber() + " - " + "Engine mode +: " + engineMode);
    }
    public void minusEngineMode() {
        engineMode--;
        if (engineMode < 1) engineMode = 5;
        System.out.println(getModelAndNumber(" - ") + "Engine mode -: " + engineMode);
    }
    public void plusABS() {
        abs++;
        if (abs > 8) abs = 1;
        System.out.println(getModelAndNumber(" - ") + "ABS +: " + abs);
    }
    public void minusABS() {
        abs--;
        if (abs < 1) abs = 8;
        System.out.println(getModelAndNumber(" - ") + "ABS -: " + abs);
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
        System.out.println(getModelAndNumber(" - ") + tyresType +" tyres set.");
    }

    @Override
    public void setUp(){
        System.out.println(getModelAndNumber(" - ") + "Car setup performed.");
    }
}

