package models;

import Data.AdressException;

import java.util.Locale;
import java.util.Objects;

public abstract class Property
{

    protected  String address ="Na,na";
    protected  float area=0;
    protected  double price=0;



    public Property(String address, float area, float price) {
        setAddress(address);
        setArea(area);
        setPrice(price);
    }

    public  abstract  double Taxlt();
    public String getAddress() {
        return address;

    }
    public void setAddress(String address)
    {
        if(hasAtLeastTwoWords(address))
            this.address = address;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area)
    {
        if(area>0)
            this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price)
    {
        if(price>0)
            this.price = price;
    }

    @Override
    public String toString() {
        String FormatPrice =  String.format(Locale.US,"%,.2f",price);

        return
                "address='" + address + '\'' +
                ", area=" + area + " meters squared"+
                ", price=" + FormatPrice +"₪";

    }

    private boolean hasAtLeastTwoWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return false;
        }
        sentence = sentence.trim();
        String[] words = sentence.split(",");

        return words.length >= 2;
    }


}
