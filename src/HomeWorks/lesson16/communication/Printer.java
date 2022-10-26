package HomeWorks.lesson16.communication;

public interface Printer {
    String mode = "Printer";
    static void equipmentStatus () {
        System.out.println(mode + ": Ready");
    }
    default void requestReport(String speaker){
        System.out.println(mode + ": All office employees have until Friday to provide reports on the work done! " + speaker + ".");
    }
}
