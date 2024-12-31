package models;

public class Vacation extends Residential
{
    private  int guests =1;
    private  static  final  double TAX=0.25;

    public Vacation(String address, float area, float price, int parkinglots, int guests) {
        super(address, area, price, parkinglots);
        setGuests(guests);
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests)
    {
        if(guests>1)
            this.guests = guests;
    }

    @Override
    public double Taxlt() {
        return getPrice()*TAX;
    }

    @Override
    public String toString() {
        return "Vacation: " +
                "guests= " + guests +" "+ super.toString();

    }
}
