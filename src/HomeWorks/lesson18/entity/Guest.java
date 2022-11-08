package HomeWorks.lesson18.entity;

public class Guest {
    private String name;
    private static Integer guestsCount = 0;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
        guestsCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void sayHello() {
        System.out.println(name + ": Доброго вечора, everybody! :)");
    }
    public void sayGoodbye(Guest guest) {
        System.out.println("See you soon!");
    }

    public static Integer guestsCount (){
        System.out.println( "We have " + guestsCount + " guests");
        return guestsCount;
    }
    public static String nameIntoQuotes(String s) {
        s = s.format("\"%s\"", s);
        return s;
    }
}
