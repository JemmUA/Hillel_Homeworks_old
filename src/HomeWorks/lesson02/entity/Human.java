package HomeWorks.lesson02.entity;

public class Human {
    private String name ;
    private int age;
    private String sex;
    private double height, weight;
    private boolean merried;
    private char bloodGroup;
    private int childs;
    private int friends;
    private int pets;

    // Constructors
    public  Human() {
    }
    public Human(String name) {
        this.name = name;
    }
    public  Human(String name, int age, String sex, double height, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }
    public Human(String name, int age, String sex, double height, double weight, boolean merried, char bloodGroup, int childs, int friends, int pets) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.merried = merried;
        this.bloodGroup = bloodGroup;
        this.childs = childs;
        this.friends = friends;
        this.pets = pets;
    }

    // Methods. Getters, setters
    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMerried(boolean merried) {
        this.merried = merried;
    }

    public void setBloodGroup(char bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setChilds(int childs) {
        this.childs = childs;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public void setPets(int pets) {
        this.pets = pets;
    }


    //getters


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isMerried() {
        return merried;
    }

    public char getBloodGroup() {
        return bloodGroup;
    }

    public int getChilds() {
        return childs;
    }

    public int getFriends() {
        return friends;
    }

    public int getPets() {
        return pets;
    }

    public void engageWashingMachine(WashingMachine washingMachine,int mode) {
        washingMachine.performWashing(mode);
    }

    public void say (String speech) {
        System.out.println(name + ": " + speech);
    }

}
