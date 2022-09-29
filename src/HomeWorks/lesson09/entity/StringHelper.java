package HomeWorks.lesson09.entity;

public class StringHelper {
    public String transform(String stringIn, char[] arrayCharsIn) {
        if (arrayCharsIn == null) {
            System.out.println("Array is null. Transformation is canceled.");
            return "";
        }

        String stringFromArray = new String(arrayCharsIn);

        if (stringIn.isBlank()){
            System.out.println("Incoming string is blank. Transformation is canceled.");
            return "";
        }
        if (stringFromArray.isBlank()){
            System.out.println("Incoming string array is blank. Transformation is canceled.");
            return "";
        }

        stringIn = stringIn.toUpperCase();
        System.out.println("Bring \'stringIn\' to upper case: " + stringIn);
        stringFromArray = stringFromArray.toLowerCase();
        System.out.println("Bring \'stringFromArray\' to lower case: " + stringFromArray);


        stringIn = stringIn.trim();
        System.out.println("Trimmed \'stringIn\': " + stringIn);
        // strip is newer version of trim. They write it uses Character.isWhitespace(int) method to determine a white space character.
        // Overall is better, as minimum better sounds xDDD https://www.youtube.com/watch?v=10JDA8SvwX8&t=180s
        stringFromArray = stringFromArray.strip();
        System.out.println("Stripped \'stringFromArray\': " + stringFromArray);

//        String stringSum = stringIn + " " + stringFromArray; //or
        String stringSum = stringIn.concat(" ").concat(stringFromArray);
        System.out.println(String.format("Concat strings = %s", stringSum)); // no need to use 'format' here - just for demo and funny )

        return this.cutMiddle(stringSum,1);
    }

    private String cutMiddle(String string, int cutSize) {

        if (string.length()/2 + string.length()%2 == cutSize)
            System.out.println("Warning! Cut=" + cutSize + " will remove whole string");

        if (string.length()/2 + string.length()%2 < cutSize) {
            System.out.println("cut=" + cutSize + " is too big");
            return string;
        }
        if (cutSize < 1) {
            System.out.println("cut=" + cutSize + " is too small");
            return string;
        }
        cutSize = string.length()%2 == 1 ? --cutSize : cutSize;
        String stringSum = string.substring(0,string.length()/2-cutSize) + string.substring((string.length()/2+cutSize+string.length()%2));
        System.out.println(String.format("Cut out string with (cut = %d) is: \'%s\'", cutSize+string.length()%2, stringSum ));
        return stringSum;
    }
}
