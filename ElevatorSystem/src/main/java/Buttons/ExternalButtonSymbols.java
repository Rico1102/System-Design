package Buttons;

public enum ExternalButtonSymbols {

    UP("^"),
    DOWN("v");

    private final String symbol;

    ExternalButtonSymbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
