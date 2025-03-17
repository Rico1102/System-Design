package Buttons;

public enum InternalButtonSymbols {
    ONE("1", true),
    TWO("2", true),
    THREE("3", true),
    FOUR("4", true),
    FIVE("5", true),
    SIX("6", true),
    SEVEN("7", true),
    EIGHT("8", true),
    NINE("9", true),
    OPEN("<->", false),
    CLOSE(">-<", false),
    ;

    private final String symbol;

    private final boolean isFloorButton;

    InternalButtonSymbols(String s, boolean isFloorButton) {
        this.symbol = s;
        this.isFloorButton = isFloorButton;
    }

    public static InternalButtonSymbols getInternalButtonSymbol(String s) {
        for (InternalButtonSymbols symbol : InternalButtonSymbols.values()) {
            if (symbol.getSymbol().equals(s)) {
                return symbol;
            }
        }
        return null;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isFloorButton() {
        return isFloorButton;
    }
}
