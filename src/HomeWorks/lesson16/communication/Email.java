package HomeWorks.lesson16.communication;

public interface Email {
    String mode = "Email";
    static void equipmentStatus () {
        System.out.println(mode + ": Ready");
    }
    default void requestReport(String speaker){
        System.out.println(mode + ": Please send a report on the work done to my e-mail. " + speaker + ".");
    }
}
