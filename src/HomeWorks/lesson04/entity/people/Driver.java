package HomeWorks.lesson04.entity.people;

public final class Driver extends Professional{
    //Data
    int cars;
    int buses;
    int garageSize;
    //Constructors

    public Driver() {
    }

    public Driver(String name, String surName, int age, String sex, int health, String profession, int skillLevel, int cars, int buses, int garageSize) {
        super(name, surName, age, sex, health, profession, skillLevel);
        this.cars = cars;
        this.buses = buses;
        this.garageSize = garageSize;
    }

    // Getters and setters


    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public int getBuses() {
        return buses;
    }

    public void setBuses(int buses) {
        this.buses = buses;
    }

    public int getGarageSize() {
        return garageSize;
    }

    public void setGarageSize(int garageSize) {
        this.garageSize = garageSize;
    }

    //Skills
    public void takeTo (String destination, String ... passengers){
        System.out.print(getProfNameSurname() + " takes " );
        for (int i = 0; i < passengers.length; i++) {
            System.out.print(passengers[i] + " and ");
        }
        System.out.println("\b\b\b\b\b" + " to the " + destination );
    }

    //Implementing interfaces
    @Override
    public void makeDiagnostic(){
        System.out.println(getProfNameSurname() + " diagnoses his car park." );
    }
    @Override
    public void makeReport() {
        System.out.println(getProfNameSurname() + " records used spare parts." );
    }


    @Override
    public void makeJob(String passenger) {
        System.out.println(getProfNameSurname() + " transports " + passenger + "."  );
    }
    @Override
    public void doBest(String passenger) {
        System.out.println(getProfNameSurname() + " delivered the " + passenger + " quickly, without violations and fines." );
    }

    @Override
    public void haveRest () {
        System.out.println(getProfNameSurname() + " has cup of coffee. ");
    }
    @Override
    public void getSalary () {
        System.out.println(getProfNameSurname() + " receives a delivery charge." );
    }
    @Override
    public void getSatisfaction () {
        System.out.println(getProfNameSurname() + "People smile at " + getProfNameSurname() + " as a sign of gratitude." );
    }
}
