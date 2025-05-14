package se.fredaw.tdd.atmsim.misc;

import java.util.Scanner;
import java.util.function.Function;

public class Utils {

    private static String format(Message message) {
       return message.getColor().getColorCode() + message.getPlaceholder() + Color.RESET.getColorCode();
    }
    public static void print(Message message) {
        System.out.println(format(message));
    }

    public static void throwWith(
            Message message,
            Function<String, ? extends RuntimeException> exceptionFactory
    ) {
        throw exceptionFactory.apply(format(message));
    }

    public static void throwIf(
            boolean condition,
            Message message,
            Function<String, ? extends RuntimeException> exceptionFactory
    ) {
        if(condition) {
            throw exceptionFactory.apply(format(message));
        }
    }


    public static int scannerInt(Scanner scanner, String prompt){
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            Utils.print(Message.INVALID_INPUT);
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }


}
