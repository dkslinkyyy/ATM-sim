package se.fredaw.tdd.atmsim.misc;

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
}
