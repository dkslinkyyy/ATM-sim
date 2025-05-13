package se.fredaw.tdd.atmsim.misc;

import java.util.function.Function;
import java.util.function.Supplier;

public class Utils {


    public static void print(Message message) {
        System.out.println(message.getColor().getColorCode() + message.getPlaceholder() + Color.RESET.getColorCode());
    }

    public static void throwWith(
            Message message,
            Function<String, ? extends RuntimeException> exceptionFactory
    ) {
        throw exceptionFactory.apply(message.getPlaceholder());
    }

}
