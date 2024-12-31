package models;

import java.util.ArrayList;

public class RealEstateManager
{
    private  String  name;
    private ArrayList<Property> properties = new ArrayList<>();

    public RealEstateManager(String name, ArrayList<Property> properties) {
        this.name = name;
        this.properties = properties;
    }


    public RealEstateManager(String name) {
        this.name = name;

    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void AddPropety(Property p){
        properties.add(p);
    }

    public  ArrayList<Property> Budget(double price){
        ArrayList<Property> b = new ArrayList<>();
        for(Property p :properties){
            if(p.getPrice()<= price)
                b.add(p);
        }
        return  b;
    }

    public  double  TotalPrice(){
        double sum = 0;
        for(Property p :properties){
            sum =+ p.getPrice();
        }
        return  sum;
    }
}
