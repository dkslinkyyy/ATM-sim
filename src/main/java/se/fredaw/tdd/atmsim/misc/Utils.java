package se.fredaw.tdd.atmsim.misc;

import java.util.function.Supplier;

public class Utils {


    public static void print(Message message) {
        System.out.println(message.getColor().getColorCode() + message.getPlaceholder() + Color.RESET.getColorCode());
    }

    public static void throwIf(boolean condition, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (condition) {
            throw exceptionSupplier.get();
        }
    }
}
