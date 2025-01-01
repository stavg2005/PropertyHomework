package Data;


import java.util.ArrayList;
import java.util.List;
import models.Property;
import models.Plot;
import models.Apartment;
import models.Vila;
import models.Vacation;
import models.Commercial;
import models.Office;

public class DataManager {


    public static ArrayList<Property> mockProperties() {
        ArrayList<Property> properties = new ArrayList<>();

        // Add 2 Plots
        properties.add(new Plot("Tel Aviv, Rothschild 12", 500, 1000000, Plot.Type.URBAN));
        properties.add(new Plot("Hadera, Agricultural Area", 1000, 500000, Plot.Type.AGRICULTURAL));

        // Add 2 Apartments
        properties.add(new Apartment("Jerusalem, King George 10", 120, 2500000, 2, 3));
        properties.add(new Apartment("Haifa, Carmel 45", 90, 1800000, 1, 2));

        // Add 2 Villas
        properties.add(new Vila("Eilat, Coral Beach 3", 350, 7000000, 2, 2));
        properties.add(new Vila("Rishon Lezion, Private Street", 400, 8000000, 3, 3));

        // Add 2 Vacation Apartments
        properties.add(new Vacation("Dead Sea, Beachside", 200, 5000000, 2, 4));
        properties.add(new Vacation("Tiberias, Kinneret View", 150, 4500000, 1, 3));

        // Add 2 Commercial Properties
        properties.add(new Commercial("Ashdod, Industrial Zone", 1000, 3000000, 5.0, false));
        properties.add(new Commercial("Holon, Business Park", 800, 4000000, 6.5, true));

        // Add 2 Offices
        properties.add(new Office("Ramat Gan, Bialik 23", 150, 2000000));
        properties.add(new Office("Petah Tikva, Sgula Industrial Area", 250, 3000000));


        return properties;
    }
}

