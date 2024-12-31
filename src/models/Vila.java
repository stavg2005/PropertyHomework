package models;

public class Vila extends  Residential
{
    private  int levels=1;
    private  static  final  double TAX =0.08;


    public Vila(String address, float area, float price, int parkinglots, int levels) {
        super(address, area, price, parkinglots);
        setLevels(levels);
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels)
    {
        if(levels>1)
            this.levels = levels;
    }

    @Override
    public double Taxlt() {
        return getPrice()*TAX;
    }

    @Override
    public String toString() {
        return "Vila :" +
                "levels=" + levels +" "+super.toString();

    }
}
