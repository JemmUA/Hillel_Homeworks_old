package HomeWorks.lesson16.entity;

import HomeWorks.lesson16.communication.Communicator;
import HomeWorks.lesson16.communication.Messenger;

public class Director implements Communicator, Messenger{
    private String jobTitle;

    public Director(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void sayHello(String speaker){
        System.out.println("Hello, everybody! " + speaker + ".");
    }
    public void sayGoodbye(String speaker){
        System.out.println("Everybody can feel free util tomorrow. Thank You. " + speaker + ".");
    }

}
