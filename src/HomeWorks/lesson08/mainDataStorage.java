package HomeWorks.lesson08;

public class mainDataStorage {
    public static void main(String[] args) {
        // No homework

        Object object = new mainDataStorage();
        Object object2 = object;
        String s = new String("10");
        String s2 = new String("10");
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s.equals(s2));
        System.out.println(object.equals(s));
        System.out.println(object.hashCode());
        System.out.println(object2.hashCode());
    }

}
