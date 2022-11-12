package HomeWorks.lesson20.services;

import java.util.Optional;

public class StringService {
//    /**
//     * @param string плохой параметр, если на проекте применяется подход работы с Optional!
//     */
//    public void checkString(final String string) {
//        if (string == null) {
//            // some logic....
//        }
//    }

    public void checkString(final Optional<String> stringOptional) {
//        final String string = stringOptional.orElseThrow();
        final String string = stringOptional.orElse("DEFAULT STRING");
        //some logic with string variable
        System.out.println("string is: " + string);
        System.out.println("string is: " + string);
        System.out.println("string is: " + string);
        System.out.println("string is: " + string);
    }

    public String checkIntAndConvertToString(final Integer integer) {
        if (integer > 0) {
            if (integer == 3) {
                return "    ";
            }
            return String.valueOf(integer);
        }
        throw new RuntimeException("integer is < 0");
    }
}

