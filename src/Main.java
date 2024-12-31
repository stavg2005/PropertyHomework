//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Data.AdressException;
import Data.DataManager;
import Data.PriceException;
import models.Property;
import models.Commercial;
import models.RealEstateManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    // Global variable for the real estate manager
    private static RealEstateManager realEstateManager = new RealEstateManager("Main");

    public static void main(String[] args) throws PriceException {
        // Initialize the real estate manager with properties from DataManager
        realEstateManager.setProperties(DataManager.mockProperties());

        // Infinite menu loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1 > Search Properties");
            System.out.println("2 > Financial Report");
            System.out.println("3 > Commercial Property Yield");
            System.out.println("4 > Properties by City");
            System.out.println("5 > Number of Cities");
            System.out.println("1- > Exit Program");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter your budget: ");
                    double price = scanner.nextDouble();
                    searchProperties(price);
                    break;
                case 2:
                    generateFinancialReport();
                    break;
                case 3:
                    calculateCommercialYield();
                    break;
                case 4:
                    listPropertiesByCity();
                    break;
                case 5:
                    countCities();
                    break;
                case -1:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void searchProperties(double Price) throws PriceException {
        if (Price < 0) {
            throw new PriceException("Price cannot be negative. Please enter a valid price.");
        }
        ArrayList<Property> b = realEstateManager.Budget(Price);

        if (b.isEmpty()) {
            System.out.println("No properties found within the given price range.");
        } else {
            System.out.println("Properties within the budget:");
            for(Property p:b){
                System.out.println(p.toString());
                System.out.println("\n");
            }
        }

    }


    private static void generateFinancialReport() {
            for(Property b:realEstateManager.getProperties()){
                System.out.println(b.getAddress() +" tax: "+b.Taxlt());
            }
    }




    private static void calculateCommercialYield() {
        double total=0;
        for(Property b:realEstateManager.getProperties()){
            if(b instanceof  Commercial)
                total =+ ((Commercial)(b)).expected_yield();
        }

        System.out.println("total yield is: "+total);
    }

    //פונקציה שמפשטת מחרוזת  בכך שמורידה מקפים והופכת לאותיות קטנות
    private static String normalizeCityName(String city) {
        return city.toLowerCase().replace("-", " ");
    }

    //פונקציה שמחזירה שם עיר מכתובת
    private static String GetCityfromAdress(String address) {
        int index = address.indexOf(',');
        if (index != -1) {
            return address.substring(0, index);
        } else {

            throw new AdressException("Address Not in Correct Format");
        }
    }

    // 4. Properties by City
    private static void listPropertiesByCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city to search: ");
        String city = scanner.nextLine();
        System.out.println("Properties in " + city + ":");

        for(Property b:realEstateManager.getProperties()){
            String CityFromAddress = GetCityfromAdress(b.getAddress());
            if(normalizeCityName(CityFromAddress).equals(normalizeCityName(city))){
                System.out.println(b.toString());
            }
        }
    }

    // 5. Number of Cities
    private static void countCities() {
        HashSet<String> cities = new HashSet<>();

        for(Property b:realEstateManager.getProperties()){
            String city= GetCityfromAdress(b.getAddress());
            cities.add(city);

        }
        System.out.println("Unique cities:");
        for (String city : cities) {
            System.out.println(city);
        }


        System.out.println("Total number of unique cities: " + cities.size());
    }
}
