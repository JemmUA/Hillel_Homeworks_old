package HomeWorks.lesson17;

import HomeWorks.lesson17.interfaces.FiveDigits;

import java.util.HashMap;
import java.util.function.*;

public class MainFunctionalInterfaces {
    public static void main(String[] args) {

        System.out.println("\nPredicate\n-------------");
        Predicate<Double> predicate = (salary) -> salary > 1500.0;
        double salary = 2000.0;
        System.out.println("Salary " + salary + " is enough: " + predicate.test(salary));
        salary = 1000.0;
        System.out.println("Salary " + salary + " is enough: " + predicate.test(salary));

        System.out.println("\nConsumer\n-------------");
        Consumer<String> consumer = (string) -> { for (Character character: string.toCharArray()) System.out.println(character); };
        consumer.accept("Symbols");

        System.out.println("\nFunction\n-------------");
        HashMap <Integer, String> digits = new HashMap<>();
        digits.put(1,"One");
        digits.put(2,"Two");
        digits.put(3,"Three");
        digits.put(4,"Four");
        digits.put(5,"Five");
        digits.put(6,"Six");
        digits.put(7,"Seven");
        digits.put(8,"Eight");
        digits.put(9,"Nine");
        digits.put(10,"Ten");
        Function<Integer, String> function = (digit) -> digits.containsKey(digit) ? digits.get(digit) : "unknown";
        for (int i = 1; i < 12; i++) System.out.println(i + ": " + function.apply(i));

        System.out.println("\nSupplier\n-------------");
        Supplier<Object> supplier = () -> "Hello world! :)";
        System.out.println(supplier.get());

        System.out.println("\nBiFunction\n-------------");
        BiFunction<Double, Integer, String> biFunction = (aDouble, aInteger) -> aDouble - aInteger < 1 ? "remainder less 1" :  "remainder: " + (aDouble - aInteger);
        System.out.println(biFunction.apply(3.5, 3));
        System.out.println(biFunction.apply(12.78, 7));

        System.out.println("\nFiveDigitFunction\n-------------");
        final Double universalGasConstant = 8.3144598;
        FiveDigits<Double, Double, Integer, Double, Double> gasVolume = (moles, gasConstant, gasTemperature, gasPressure) -> (moles * gasConstant * gasTemperature) / gasPressure;
        System.out.println("Gas Volume = " + gasVolume.getGasVolume(50.3, universalGasConstant, 21, 3.5));

        System.out.println("\nToDoubleBiFunction\n-------------");
        Double numOne;
        Integer numTwo;
        numOne = 11.0;
        numTwo = 77;
        ToDoubleBiFunction<Double, Integer> percents = (numberOne, numberTwo) -> numberOne / numberTwo * 100;
        System.out.println(numOne + " from " + numTwo + " is " + percents.applyAsDouble(numOne, numTwo) + " %");

    }
}
