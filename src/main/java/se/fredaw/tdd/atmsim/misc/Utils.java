package se.fredaw.tdd.atmsim.misc;

public class Utils {


    public static void print(Message message) {
        System.out.println(message.getColor().getColorCode() + message.getPlaceholder() + Color.RESET.getColorCode());
    }
}
