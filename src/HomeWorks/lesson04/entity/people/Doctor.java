package HomeWorks.lesson04.entity.people;

public final class Doctor extends Professional {
    //Data
    int drugs;
    int bandage;
    int antibiotics;
    int painkillers;
    //Constructors

    public Doctor() {
    }

    public Doctor(String name, String surName, int age, String sex, int health, String profession, int skillLevel, int drugs, int bandage, int antibiotics, int painkillers) {
        super(name, surName, age, sex, health, profession, skillLevel);
        this.drugs = drugs;
        this.bandage = bandage;
        this.antibiotics = antibiotics;
        this.painkillers = painkillers;
    }
    // Getters and setters

    public int getDrugs() {
        return drugs;
    }

    public void setDrugs(int drugs) {
        this.drugs = drugs;
    }

    public int getBandage() {
        return bandage;
    }

    public void setBandage(int bandage) {
        this.bandage = bandage;
    }

    public int getAntibiotics() {
        return antibiotics;
    }

    public void setAntibiotics(int antibiotics) {
        this.antibiotics = antibiotics;
    }

    public int getPainkillers() {
        return painkillers;
    }

    public void setPainkillers(int painkillers) {
        this.painkillers = painkillers;
    }

    //Skills
    public void examinePatient(String patient) {
        System.out.println(getProfNameSurname() + " examines patient " + patient);
    }
    public void provideFirstAid(String patient) {
        System.out.println(getProfNameSurname() + " provides first aid to " + patient);
        this.drugs--;
        this.bandage-- ;
        this.antibiotics-- ;
        this.painkillers-- ;
    }
    public void restock() {
        System.out.println(getProfNameSurname() + " replenished stocks of medicine ");
        this.drugs = 500;
        this.bandage = 100;
        this.antibiotics = 200;
        this.painkillers = 500;
    }

    //Implementing interfaces
    @Override
    public void makeDiagnostic(){
        System.out.println(getProfNameSurname() + " checks medical equipment." );
    }
    @Override
    public void makeReport() {
        System.out.println(getProfNameSurname() + " notes the condition of medical equipment." );
    }


    @Override
    public void makeJob(String patient) {
        System.out.println(getProfNameSurname() + " treats patient " + patient + "."  );
    }
    @Override
    public void doBest(String patient) {
        System.out.println(getProfNameSurname() + " save life of " + patient + "." );
    }

    @Override
    public void haveRest () {
        System.out.println(getProfNameSurname() + " walks in park after job. ");
    }
    @Override
    public void getSalary () {
        System.out.println(getProfNameSurname() + " receives a good salary." );
            }
    @Override
    public void getSatisfaction () {
        System.out.println(getProfNameSurname() + " receives many thanks for help." );
    }


}
