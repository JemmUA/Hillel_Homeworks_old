package HomeWorks.lesson01;

public class MainDataTypes {
    public static void main(String[] args) {

        // Homework 01
        // 1. Примитивные и Ссылочные типы данных

        System.out.println("Homework 01\n");

        // Data field
        final byte ZERO = 0;
        short numberShort = -32000;
        long numberLong = 9_000_000_000_000_000_000l;
        char symbolA = 'a', symbolZ = 122;
        float numberFloat = 1.13234423f;
        final boolean weWin = true;
        int coordX, coordY, radius;
        coordX = 44;
        coordY = 100;
        radius = 100;
        double height = 187.1, width = 30.23487, weight = 99.99999;
        String myCountry = "Ukraine";
        String greetings = new String("Hi, we are from Ukraine!");


        // Arithmetics
        System.out.println("Arithmetics");
        System.out.println((numberLong - numberShort) / 2);
        System.out.println((numberLong +1) % 2);
        System.out.println(numberShort * numberShort - 100);
        numberLong = ZERO * numberShort - numberShort;
        System.out.println(numberLong);
        System.out.println((char)(symbolA + 1));
        System.out.println(symbolZ - symbolA);
        System.out.println();

        System.out.println(ZERO * numberFloat - numberShort);
        System.out.println(numberShort * numberFloat + 1);
        System.out.println(numberShort / numberFloat + 100000);
        System.out.println((height * width) / 1000);
        System.out.println((weight * numberFloat) % 2);
        System.out.println();

        // Arithmetics + assignment
        System.out.println("Arithmetics + assignment");
        coordX += 10;
        System.out.println(coordX);
        coordY -= 1;
        System.out.println(coordY);
        radius /= 2;
        System.out.println(radius);
        numberLong *= ZERO;
        System.out.println(numberLong);
        numberFloat %= 2;
        System.out.println(numberFloat);
        numberLong -= numberLong;
        System.out.println(numberLong);
        numberLong /= 2;
        System.out.println(numberLong);
        numberLong %= numberShort;
        System.out.println(numberLong);
        coordX -= 3;
        System.out.println(coordX);
        numberLong /= numberLong + 1;
        System.out.println(numberLong);
        System.out.println();

        // Boolean
        System.out.println("Boolean");
        System.out.println(weWin);
        System.out.println(!true);
        System.out.println(true || false);
        System.out.println(!true || false);
        System.out.println(1 < 0);
        System.out.println(3 > 2 && 4 > 3);
        System.out.println(0 != ZERO);
        System.out.println(!(0 == ZERO));
        System.out.println('a' >= 0);
        System.out.println((1 > ZERO && -5 < ZERO) || (100 * ZERO == 0));
        System.out.println();


        // Increment and Decrement.
        // Variants for increment: ++var , var++ , var += 1, var = var + 1 .
        // Variants for decrement: --var , var-- , var -= 1, var = var - 1 .
        System.out.println("Increment and Decrement");

        int number = 1;
        System.out.println(number);
        number--;
        System.out.println(number);
        number++;
        System.out.println(number);
        System.out.println(number);
        System.out.println(number++);
        System.out.println(number);
        System.out.println(--number);
        System.out.println(number);
        System.out.println();

        // Array
        System.out.println("Array");
        int[] arrayFigures = new int[10];
        for (int i = 0; i < arrayFigures.length; i++) {
            arrayFigures[i] = i;
            System.out.println(arrayFigures[i]);
        }

    }

}

