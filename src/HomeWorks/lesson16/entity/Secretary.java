package HomeWorks.lesson16.entity;

import HomeWorks.lesson16.communication.Email;
import HomeWorks.lesson16.communication.Printer;

public class Secretary implements Printer, Email {
    private String jobTitle;

    public Secretary(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public void requestReport(String speaker){
        System.out.println("All employees! Please send a report on the work done to my e-mail or messenger. " + speaker + ".");
    }

    public void sayHello(String speaker){
        System.out.println("Greetings, everybody! " + speaker + ".");
    }
    public void sayGoodbye(String speaker){
        System.out.println("The working day is over. Goodbye. " + speaker + ".");
    }

}
