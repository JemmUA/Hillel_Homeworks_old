
package lesson20;

import HomeWorks.lesson20.entity.Client;
import HomeWorks.lesson20.services.StringService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainJava8Practice {
    public static void main(String[] args) {
        final String stringForCheck1 = "STRING 1 FOR CHECK ";
        final String stringForCheck2 = "checking string... ";
        final String stringForCheck3 = null;
        final Function<String, String> function = (string) -> string.trim().repeat(5);
        function.apply(stringForCheck1);

        checkAndValidateString(stringForCheck1);
        checkAndValidateString(stringForCheck2);
//        function.apply(stringForCheck3);

        final Optional<String> stringOptional = checkAndValidateString(stringForCheck3);
//        String result = stringOptional.isPresent() ? stringOptional.get() : null;
//        String result = stringOptional.orElse(null);
//        if (stringOptional.isPresent()) {
//            result = stringOptional.get();
//        }
        final StringService stringService = new StringService();
        stringService.checkString(stringOptional);

        function.apply(stringForCheck2);

        List<String> first = List.of("first", "second");
//        first.add("third");

        final List<Client> clients = List.of(new Client(), new Client());
        System.out.println(clients.get(0).getName());
        clients.get(0).setName("Immutable");
        System.out.println(clients.get(0).getName());

        final List<Integer> integers = List.of(1, 2, 3, 4);
        final List<String> collect = integers.stream()
                .map(stringService::checkIntAndConvertToString)
                .filter(var -> !var.trim().isEmpty())
//                                             .map(stringService::checkIntAndConvertToString)
//                                             .map(stringService::checkIntAndConvertToString)
//                                             .map(stringService::checkIntAndConvertToString)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(new List[]{collect}));
    }

    /**
     * @param string параметр для проверки и каста в нужное значение
     * @return преобразованная строка
     */
    private static Optional<String> checkAndValidateString(final String string) {
        return string == null
                ? Optional.empty()
                : Optional.of(string.trim().repeat(7).concat(" :the end"));
    }
}

