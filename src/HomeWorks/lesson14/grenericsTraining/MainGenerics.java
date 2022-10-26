package HomeWorks.lesson14.grenericsTraining;

public class MainGenerics {
    public static void main(String[] args) {
        ObjectHolder<String, String, String> stringHolder = new ObjectHolder<>("String One", "Strring Two", "String Three");
//        stringHolder.setObject("aaaaallleee");
        String stringI = stringHolder.getObjectI();
        String stringS = stringHolder.getObjectS();
        String stringD = stringHolder.getObjectD();
        System.out.println(stringI);
        System.out.println(stringD);
        System.out.println(stringS);
        ObjectHolder<Integer, Double, String> diffHolder = new ObjectHolder<>(1234567890, 1234567889.0, "String");
        Integer integers = diffHolder.getObjectI();
        Double doubles = diffHolder.getObjectD();
        String strings = diffHolder.getObjectS();
        System.out.println(integers);
        System.out.println(doubles);
        System.out.println(strings);
        System.out.println();


        System.out.println("--------------");
        System.out.println(diffHolder.sum(1,2.555555));
        System.out.println("--------------");
        System.out.println(stringHolder.sum("Lets learn ","step by step"));
        System.out.println("--------------");
        System.out.println(stringHolder.sum("Lets learn ",null));
        System.out.println(diffHolder.sum(1,null));



    }
}
