package HomeWorks.lesson20.entity;

public class Client {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("CLIENT SAY SOMETHING....");
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}

