package HomeWorks.lesson18;

import HomeWorks.lesson18.entity.Guest;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class MainStreamAPIFixed {
    public static void main(String[] args) {

        taskHeader(1);
        System.out.println("Empty collection - empty print");
        Stream<Object> emptyStream = Stream.empty(); // create empty stream
        emptyStream
                .distinct() // choose distinct from nothing
                .limit(0) // limit empty stream to zero
                .forEach(System.out::println); // print nothing from empty stream

        taskHeader(2);
        ArrayList<Integer> randoms = new ArrayList<>();
        int range = 200;
        for (int i = 0 ; i < 20 ; i++) randoms.add((int)((Math.random() * range)-range/2)); // 20 integers in range -100 : 99
        System.out.println("Collection 'randoms' of random Integers: " + randoms);
        Stream<Integer> integerStream = randoms.stream();
        List<Integer> oddNumbers = integerStream
                .filter(number -> number % 2 == 1 || number % 2 == -1)
                .sorted()
                .collect(toList());
        System.out.println("Sorted list of odd Integers from 'randoms': " + oddNumbers);

        taskHeader(3);
        HashSet <String> stringHeshSet = new HashSet<>(Arrays.asList("Нобор ", "данных ", "- ", "это  ", "SET ", "! ", " :D "));
        Stream<String> stringStream = stringHeshSet.stream();
        List<String> stringList = stringStream
                .toList();
        stringList.forEach(System.out::println);

//        taskHeader(3); // old
//        String[] wordsArray = "This is a string for the stream !".split("\s");
//        Stream<String> stringStream = Arrays.stream(wordsArray);
//        List<String> stringList = stringStream
//                .collect(toList());
//
//        stringList.forEach(System.out::println);

        taskHeader(4);
        System.out.println("MORSE CODE");
        final String[][] morseArray = {
                {"A", ".-  "}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.. "}, {"E", "."   }, {"F", "..-."},
                {"G", "--. "}, {"H", "...."}, {"I", "..  "}, {"J", ".---"}, {"K", "-.- "}, {"L", ".-.."},
                {"M", "--  "}, {"N", "-.  "}, {"O", "--- "}, {"P", ".--."}, {"Q", "--.-"}, {"R", ".-. "},
                {"S", "... "}, {"T", "-   "}, {"U", "..- "}, {"V", "...-"}, {"W", ".-- "}, {"X", "-..-"},
                {"Y", "-.--"}, {"Z", "--.."}};
        HashMap<String, String> morseMap = new HashMap<>();
        for (String[] strings : morseArray) morseMap.put(strings[0], strings[1]);
        Collection<String> valuesList = morseMap.values();
//        System.out.println(valuesList);
        Stream<String> keyStream = valuesList.stream();
                keyStream
                        .peek(System.out::println)
                        .toList();


//        taskHeader(4); // old
//        System.out.println("MORSE CODE");
//        final String[][] morseArray = {
//                {"A", ".-  "}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.. "}, {"E", "."   }, {"F", "..-."},
//                {"G", "--. "}, {"H", "...."}, {"I", "..  "}, {"J", ".---"}, {"K", "-.- "}, {"L", ".-.."},
//                {"M", "--  "}, {"N", "-.  "}, {"O", "--- "}, {"P", ".--."}, {"Q", "--.-"}, {"R", ".-. "},
//                {"S", "... "}, {"T", "-   "}, {"U", "..- "}, {"V", "...-"}, {"W", ".-- "}, {"X", "-..-"},
//                {"Y", "-.--"}, {"Z", "--.."}};
//        HashMap<String, String> morseMap = new HashMap<>();
//        for (String[] strings : morseArray) morseMap.put(strings[0], strings[1]);
//
//        Stream<Map.Entry<String, String>> morseStream = morseMap.entrySet().stream();
//        Map<String, String> morseCollection =
//                morseStream
//                .peek(System.out::println) // print as is
////                .peek(map -> System.out.println(map.getKey() + " -> " + map.getValue())) // print in custom style
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        taskHeader(5);
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("321");
        numbers.add("2");
        numbers.add("2");
        numbers.add("-11");
        numbers.add("-222");
        numbers.add("4");
        numbers.add("4");
        numbers.add("-2");
        numbers.add("10000");
        numbers.add("24");

        System.out.println("Even unique values of numbers " + numbers);
        Stream<String> numbersStream = numbers.stream();
        List<Integer> integers =
                numbersStream
                .skip(1)
                .limit(8)
                .map(Integer::valueOf)
//                .mapToInt(numberStr -> Integer.valueOf(numberStr))
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(toList());
        System.out.println("are: " + integers);


        taskHeader(6);
        Stream<Double> doubleStream = Stream.of(2.21, 0.1, -9.3, 3.7, 0.99, 0.3, 5.4, 3.1, 110.3);
        System.out.println("Doubles: ");
        Optional<Double> first = doubleStream
                .peek(System.out::println)
                .parallel()
                .sorted()
                .filter(aDouble -> aDouble > 1)
                .findFirst();
        System.out.println("Smallest element >1 is: " + first.get());

        taskHeader(7);

//        Runnable runnable = Guest::new;
//        Function<Guest, String> getName = Guest::getName;
//        Consumer<Guest> sayHello = Guest::sayHello;
//        Consumer<Guest> sayGoodbye = guest::sayGoodbye;
        Supplier guestsCount = Guest::guestsCount;

        Guest guest = new Guest("Ola");
        guestsCount.get();
        Stream<String> guestStream = Stream.of("Andrew", "Irina", "Vitaliy", "Elena", "Sasha", "Stanislav", "Alex", "Alex");
        List<Guest> guestList = guestStream
                .map(Guest::nameIntoQuotes)
//                .map(String::toUpperCase)
                .map(Guest::new)
                .peek(Guest::sayHello)
                .peek(guest::sayGoodbye)
                .toList();
        guestsCount.get();
    }

    /**
     * @param task
     */
    public static void taskHeader (Integer task){
        String upperline = "\n";
        String underline = "\n------\n";
        System.out.printf(String.format("%sTask %d %s", upperline, task, underline));
    }
}
