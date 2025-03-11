package Buttons;

public enum ExternalButtonSymbols {

    UP("^"),
    DOWN("v");

    private final String symbol;

    public String getSymbol() {
        return symbol;
    }

    ExternalButtonSymbols(String symbol) {
        this.symbol = symbol;
    }

}
