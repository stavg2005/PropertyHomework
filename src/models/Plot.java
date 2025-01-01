package models;

public class Plot extends Property {

    public enum Type {URBAN, AGRICULTURAL, INDUSTRIAL}

    // Define tax rates as constants (double)
    private static final double URBAN_TAX_RATE = 0.10;
    private static final double AGRICULTURAL_TAX_RATE = 0.02;
    private static final double INDUSTRIAL_TAX_RATE = 0.05;

    protected Type type;

    public Plot(String address, float area, float price, Type type) {
        super(address,  area, price);
        this.type = type;
    }

    @Override
    public double Taxlt() {
        return switch (type) {
            case URBAN -> getPrice() * URBAN_TAX_RATE;
            case AGRICULTURAL -> getPrice() * AGRICULTURAL_TAX_RATE;
            case INDUSTRIAL -> getPrice() * INDUSTRIAL_TAX_RATE;
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }


    @Override
    public String toString() {
        return UpperCaseFirst(type.name())  +" Plot " +
                " "+ super.toString();

    }

    private  String UpperCaseFirst(String sentence){
        sentence= sentence.toLowerCase();
        sentence = (char)(sentence.charAt(0) -32) + sentence.substring(1);
        return  sentence;
    }
}
