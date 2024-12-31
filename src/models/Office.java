package models;

public class Office extends Property {
    static final double Tax = 0.05;



    public Office(String address, float area, float price) {
        super(address, area, price);
    }

    @Override
    public double Taxlt() {
        return getPrice()*Tax;
    }

    @Override
    public String toString() {
        return "Office: "+super.toString();
    }
}
