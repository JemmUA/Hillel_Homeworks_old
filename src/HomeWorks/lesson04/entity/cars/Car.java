package HomeWorks.lesson04.entity.cars;

import HomeWorks.lesson04.entity.skills.Diagnostics;
import HomeWorks.lesson04.entity.skills.PreparingForRace;

public abstract class Car implements Diagnostics, PreparingForRace {
    //Data field
    private String model;
    private String color;
    private float engineVolume;
    private int weight;
    private int fuelTank;
    private float fuelConsumption;
    private double fuelLevel;
    private int maxSpeed;

    //Constructors
    public Car() {
    }
    public Car(String model, String color, float engineVolume, int weight, int fuelTank, float fuelConsumption, double fuelLevel, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.engineVolume = engineVolume;
        this.weight = weight;
        this.fuelTank = fuelTank;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.maxSpeed = maxSpeed;
    }

    //Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // Methods

    public void drive(float distance) {
        System.out.println("\nDriving\n----------");

        if (fuelLevel >= distance/fuelConsumption) {
            fuelLevel -= distance/fuelConsumption;
            System.out.println(model + " traveled " + distance + " km");
        } else {
            distance = (float)fuelLevel*fuelConsumption;
            fuelLevel = 0;
            System.out.println(model + " traveled " + distance + " km and stopped. \nFuel tank is empty. Need refuel!");
        }
    }

    public void refuel(int addFuel) {
        System.out.print("Refueling: ");
            if (addFuel < 0) {
                System.out.println("You can't remove fuel!");
            } else {
                if (addFuel + fuelLevel <= fuelTank) {
                    fuelLevel += addFuel;
                    System.out.println("added " + addFuel + " L. Level of fuel: " + fuelLevel + " L");
                } else {
                    System.out.println("fuel added " + (fuelTank - fuelLevel)  + " L. Fueltank is full: " + fuelTank + " L");
                    fuelLevel = fuelTank;
                }
            }
        }


}

