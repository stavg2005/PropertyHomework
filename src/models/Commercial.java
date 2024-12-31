package models;

public class Commercial extends  Property
{
    private  boolean storeroom = false;

    private  double yield =0.0;
    private  static  final  double Tax=0.05;


    public Commercial(String address, float area, float price, double yield) {
        super(address, area, price);
        setYield(yield);
    }

    public Commercial(String address, float area, float price, double yield,boolean storeroom) {
        super(address, area, price);
        setYield(yield);
        setStoreroom(storeroom);
    }

    public boolean GetStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield)
    {
        if(yield>0.0)
            this.yield = yield;
    }

    public  double expected_yield(){
        return  (getPrice()*(yield/100))/12;
    }

    @Override
    public double Taxlt() {
        return getPrice()*Tax;
    }

    @Override
    public String toString() {
        return "Commercial: " +
                "storeroom=" + storeroom +
                ", yield=" + yield + " " +super.toString();

    }
}
