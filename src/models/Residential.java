package models;

public abstract class Residential extends Property {

    private  int parkinglots=0;

    public Residential(String address, float area, float price, int parkinglots) {
        super(address, area, price);
        setParkinglots(parkinglots);
    }

    public int getParkinglots() {
        return parkinglots;
    }

    public void setParkinglots(int parkinglots)
    {
        if(this.parkinglots>0)
            this.parkinglots = parkinglots;
    }
}
