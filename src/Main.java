import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    static List<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Path path
            = Paths.get(".\\vehicles.txt");
    public static void main(String[] args) {

        System.out.println("Welcom to system for registration of vehicles.Input what type of vehicle you want" +
                "to registrate\n" +
                "1. Motorcycle\n" +
                "2. Car\n" +
                "3. Truck\n");
        String choice = sc.nextLine();
        if(choice.equals("1"))
            createMotorcycle();
        if(choice.equals("2"))
            createCar();
        if(choice.equals("3"))
            createTruck();

//        String num_of_doors = sc.nextLine();
//        String car_type = sc.nextLine();
//        Car car1 = new Car(num_of_doors, car_type);
//        System.out.println(car1.toString());
//        ArrayList<String> cars = new ArrayList<String>();
//        for (int i=0; i < cars.length; i++) {
//            if ()
//        }
//
//        if (Car.deleteVehicle == false) {
//            System.out.println("Vehicle not deleted");
//        }

    }


    public static void loadVehiclesFromFile(){
        //TODO pogledaj sta je split funkcija za stringove, citanje iz fajla...

    }

    public static void saveVehiclesToFile(Vehicle vehicle){
        String vehicleToSave = "";
        if(vehicle instanceof Motorcycle){
            Motorcycle motorcycle = (Motorcycle) vehicle;
            vehicleToSave = motorcycle.getNum_chassis()+","+ motorcycle.getRegistration_num()+","+motorcycle.getNum_horsepower()+","+
                    motorcycle.getPower() + "," + motorcycle.getVehicle_manufacturer() + "," + motorcycle.getMileage() +"\n";
        }
        if(vehicle instanceof Car){
            Car car = (Car) vehicle;
        }
        if(vehicle instanceof Truck){
            Truck truck = (Truck) vehicle;
        }
        try {
            Files.writeString(path, vehicleToSave,
                    StandardCharsets.UTF_8);
        }
        catch (IOException ex) {

            System.out.print("Invalid Path");
        }
    }

    public static void createMotorcycle(){
        Motorcycle motorcycle = new Motorcycle();
        System.out.println("Enter the number of chassis:");
        motorcycle.setNum_chassis(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the registration number:");
        motorcycle.setRegistration_num(sc.nextLine());
        System.out.println("Enter the number of horsepower:");
        motorcycle.setNum_horsepower(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the power:");
        motorcycle.setPower(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the mileage:");
        motorcycle.setMileage(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter vehicle manufacturer:");
        motorcycle.setVehicle_manufacturer(sc.nextLine());
        System.out.println("Motorcycle is saved to system..!");
        vehicles.add(motorcycle);
        saveVehiclesToFile(motorcycle);
    }

    public static void createCar(){

    }

    public static void createTruck(){

    }


}