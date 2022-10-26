package HomeWorks.lesson16.communication;

public interface Communicator extends Messenger{
    String mode = "Communicator";

    static void equipmentStatus () {
        System.out.println(mode + ": Ready");
    }
    default void requestReport(String speaker){
        System.out.println(mode + ": All the employees, please provide reports on the work done! " + speaker + ".");
    }
    void sayHello(String speaker);
    void sayGoodbye(String speaker);
}
