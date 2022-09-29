    package HomeWorks.lesson04;

import HomeWorks.lesson04.entity.cars.Formula1;
import HomeWorks.lesson04.entity.cars.GT3;
import HomeWorks.lesson04.entity.cars.Indycar;
import HomeWorks.lesson04.entity.skills.JobSatisfaction;
import HomeWorks.lesson04.entity.skills.PreparingForRace;
import HomeWorks.lesson04.entity.skills.Repairing;
import HomeWorks.lesson04.entity.skills.Work;
import HomeWorks.lesson04.entity.people.Doctor;
import HomeWorks.lesson04.entity.people.Driver;
import HomeWorks.lesson04.entity.people.Warrior;

    public class MainPolymorphism {
        public static void main(String[] args) {
            //test
            System.out.println("test");
            System.out.println();
            System.out.println("Cars");
            //Build cars
            Formula1 formula1 = new Formula1("Redbull", "blue", 2.7f, 651, 110, 2.7f, 60, 410, 11, 7, 3, 0, 4, false, false);
            GT3 gt3 = new GT3("Audi", "red", 3.2f, 987, 120, 3.4f, 50, 380, 35, 3, 5, 0, 2, 4, 5);
            Indycar indycar = new Indycar("Chevrolet", "blue", 2.3f, 701, 70, 3.3f, 20, 420, 157, 3, 2, 4, 0, 2, 1);

            //Test drive
            System.out.println("\nTest drive " + formula1.getModelAndNumber("") + "\n--------");
            formula1.standingStart();
            formula1.chargeERS();
            formula1.engageERS();
            formula1.drsOn();
            formula1.drsOff();
            formula1.pitStop();
            formula1.drive(12);
            formula1.returnToBoxes();

            System.out.println("\nTest drive car " + gt3.getModelAndNumber("") + "\n--------");
            gt3.standingStart();
            gt3.plusEngineMode();
            gt3.pitStop();
            gt3.refuel(100);
            gt3.drive(33);
            gt3.returnToBoxes();

            System.out.println("\nTest drive car " + indycar.getModelAndNumber("") + "\n--------");
            indycar.rollingStart();
            indycar.minusTC();
            indycar.pitStop();
            indycar.drive(1);
            indycar.pitStop();
            indycar.plusTC();
            indycar.drive(30);
            indycar.returnToBoxes();
            indycar.refuel(30);

            //People
            System.out.println("");
            System.out.println("People");

            //create professionals
            Warrior warrior = new Warrior("Andriy", "Bavovnyak", 29, "man", 100, "warrior", 5, 300, 4, 100);
            Driver driver = new Driver("Vasil", "Skoriy", 33, "man", 100, "driver", 5, 5, 3, 7);
            Doctor doctor = new Doctor("Olena", "Mudra", 41, "woman", 100, "doctor", 5, 50, 23, 7,33);

            //professionals act
            doctor.say(driver.getName() + ", take me to the war position, please.");
            driver.say("Sure, mem. Seat your belt.");
            driver.takeTo("war position", doctor.getName());
            doctor.say(warrior.getName() + " I have to exemine people.");
            warrior.say("Of course mem.");
            System.out.println("But suddenly the battle began.");
            warrior.say("Position is under attack! Everyone to shelter!");
            warrior.defend(doctor.getName());
            warrior.defend(driver.getName());
            System.out.println("At last battle is over.");
            doctor.examinePatient(warrior.getProfNameSurname());
            doctor.provideFirstAid("injured");
            driver.takeTo("hospital", warrior.getName(), doctor.getName(), "others injured");
            System.out.println();

            //HOMEWORK
            System.out.println("----------------------------------");
            System.out.println("HOMEWORK. Implementing interfaces.");
            System.out.println("----------------------------------");
            warrior.makeDiagnostic();
            doctor.makeDiagnostic();
            driver.makeDiagnostic();
            warrior.makeReport();
            doctor.makeReport();
            driver.makeReport();
            warrior.makeJob("people");
            warrior.getSatisfaction();
            driver.getSalary();
            doctor.haveRest();

            System.out.println();
            System.out.println("Getting interfaces' methods separately from classes' methods");
            System.out.println("------------------------------------------------------------");
            Repairing repairFerrari = new Formula1("Ferrari", "red", 2.7f, 651, 110, 2.7f, 60, 410, 7, 7, 3, 0, 4, false, false);
            PreparingForRace prepareLamborghini = new GT3("Lamborghini", "green", 3.2f, 987, 120, 3.4f, 50, 380, 111, 3, 5, 0, 2, 4, 5);
            repairFerrari.changeChassis();
            repairFerrari.changeEngine();
            prepareLamborghini.changeGearbox();
            repairFerrari.changeWings("rear");
            prepareLamborghini.changeWings("front");
            prepareLamborghini.setUp();
            prepareLamborghini.setNewTyres("slick");

            System.out.println();
            Work doctorSkills = new Doctor("Olena", "Mudra", 41, "woman", 100, "doctor", 5, 50, 23, 7,33);
            JobSatisfaction warriorSkills = new Warrior("Andriy", "Bavovnyak", 29, "man", 100, "warrior", 5, 300, 4, 100);
            doctorSkills.doBest(driver.getName());
            doctorSkills.makeJob(warrior.getName());
            warriorSkills.doBest("people");
            warriorSkills.haveRest();
            warriorSkills.getSatisfaction();

        }
    }