package models;

public class Apartment extends  Residential
{
    private  int rooms =1;
    private  static  final  double TAX =0.08;


    public Apartment(String address, float area, float price, int parkinglots, int rooms) {
        super(address, area, price, parkinglots);
        setRooms(rooms);
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms)
    {
        if(rooms>1)
            this.rooms = rooms;
    }

    @Override
    public double Taxlt() {
        return getPrice()*TAX;
    }

    @Override
    public String toString() {
        return "Apartment: " +
                "rooms=" + rooms + " "+ super.toString();

    }
}
