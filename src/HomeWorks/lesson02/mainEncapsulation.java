package HomeWorks.lesson02;

import HomeWorks.lesson02.entity.FinalArgs;
import HomeWorks.lesson02.entity.HomeHelper;
import HomeWorks.lesson02.entity.House;
import HomeWorks.lesson02.entity.Human;
import HomeWorks.lesson02.entity.TVset;
import HomeWorks.lesson02.entity.WashingMachine;


public class mainEncapsulation {
    public static void main(String[] args) {

        // Homework 02
        // 2. Введение в ООП. Принцип ООП: Инкапсуляция. Рефлексия.

/*      1. Создайте новый класс, у которого должно быть 9 переменных (8 примитивов разного типа + String);
        Для каждой переменной напишите getter и setter;
        Напишите конструкторы начиная от конструктора по-умолчанию до конструктора с 9 параметрами;

        Class Human
        */
        System.out.println("1.");
        Human hum1 = new Human();
        Human hum2 = new Human("Andrey", 22, "men", 190, 88);
        Human hum3 = new Human("Andrey", 22, "men", 190, 88,
                true, 'A', 1, 101,1);
        System.out.println(hum3.getName() + ", " + hum3.getSex() + ", blood group:" + hum3.getBloodGroup());
        System.out.println();

/*
        2. Создайте класс с 3 параметрами final. Создайте в нем конструктор по-умолчанию и конструктор со всеми параметрами.
        Создайте для всех полей getter и setter.
        ps: Задание с подвохом. Если что-то заметили, закомментируйте эту часть кода и напишите комментарий.

        Class FinalArgs
*/      System.out.println("2.");
        FinalArgs af = new FinalArgs();
        FinalArgs afa = new FinalArgs(1,2,3);
        System.out.println("af.x="+af.getX()+", af.y="+ af.getY()+", af.z="+af.getZ()); // right
        // System.out.println("af.x="+af.x+", af.y="+ af.y+", af.z="+af.z); // wrong
        System.out.println("get af x: "+afa.getX()+", get af y: "+afa.getY()+", get af z: "+afa.getZ());
        System.out.println();

/*      3. Создайте класс House. Заполните Ваш новый дом “мебелью”(подсказка: мебель - это отдельные классы,
        то есть внутри дома будут параметры = новые классы), для примера достаточно 2-3 вещи/предмета в доме.
        У каждой вещи также должно быть пару характеристик.*/

        //Classes: House, WashingMachine, TVset, HomeHelper, Human

//        System.out.println("3.");
//        Human myHuman10 = new Human("Master", 55 , "man", 187.5, 99, false, 'A', 3, 100, 5);
//        House myFlat = new House("myFlat", true, false, 21);
//        TVset samsungTV = new TVset(false, 3, 15);
//        WashingMachine zanussi = new WashingMachine();
//        HomeHelper homehelperOne = new HomeHelper("R2D2", false);
//
//        myHuman10.say("I'm came! Open the door!");
//
//        homehelperOne.say("Welcome home! I'l prepare all what you need, Ser.");
//        homehelperOne.masterCame(myFlat, samsungTV,zanussi);
//
//        myHuman10.humanWatchTV(samsungTV);
//
//        myHuman10.say("I go sleep...");
//
//        homehelperOne.say("As you wish... Good night");
//        homehelperOne.masterGoSleep(myFlat, samsungTV);
//        homehelperOne.say("Good night");


        House myFlatOne = new House("City flat", true, false, 24,new Human("Master"),
                new TVset(false, 0, 0), new WashingMachine(), new HomeHelper( "C-3PO",true));
        Human masterHuman = new Human();
        House myFlat = new House("myFlat", true, false, 21);
        TVset samsungTV = new TVset(false, 3, 15);
        WashingMachine zanussi = new WashingMachine();
        HomeHelper homehelperOne = new HomeHelper("R2D2", false);

//        myFlatOne.masterHuman.say(myFlatOne.homehelperOne.getName() + ", i came! Open the door!");
//        myFlatOne.sayHuman(myFlatOne.getHelperName() + ", i came! Open the door!");
//
//        myFlatOne.homehelperOne.say("Welcome home! I'l prepare all what you need, Master. ");
//        myFlatOne.setDoorIsLocked(false);
//        myFlatOne.homehelperOne.say("Come in, please.");
//        myFlatOne.zanussi.performWashing(4);
//        myFlatOne.samsungTV.setChannel(2);
//        myFlatOne.samsungTV.minusChannel();
//        myFlatOne.samsungTV.setVolume(15);
//        myFlatOne.samsungTV.plusVolume();
//        myFlatOne.masterHuman.engageWashingMachine(zanussi, 4);
    }


}
