package se.fredaw.tdd.atmsim.misc;

public enum Message {
    INSUFFICIENT_BALANCE("Insufficient funds :(", Color.YELLOW),
    INVALID_INPUT("Invalid input. Please enter a number.", Color.YELLOW);


    private final String placeholder;
    private final Color color;
    Message(String placeholder, Color color) {
        this.placeholder = placeholder;
        this.color = color;
    }


    Message(String placeholder) {
        this(placeholder, Color.RED); // Default to white
    }

    public Color getColor() {
        return color;
    }

    public String getPlaceholder() {
        return placeholder;
    }
}
