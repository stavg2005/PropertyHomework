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
        switch (type) {
            case URBAN:
                return getPrice() * URBAN_TAX_RATE;
            case AGRICULTURAL:
                return getPrice() * AGRICULTURAL_TAX_RATE;
            case INDUSTRIAL:
                return getPrice() * INDUSTRIAL_TAX_RATE;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
    @Override
    public String toString() {
        return "Plot{" +
                "type=" + type +" "+ super.toString();

    }
}
