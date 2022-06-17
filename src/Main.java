import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Main {

    static List<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Path path
            = Paths.get(".\\src\\vehicles.txt");
    public static void main(String[] args) {
        loadVehiclesFromFile();


        while (true) {
            System.out.println("Welcome to system for registration of vehicles.Input what type of vehicle you want" +
                    "to register\n" +
                    "1. Motorcycle\n" +
                    "2. Car\n" +
                    "3. Truck\n" +
                    "4. Registering a vehicle\n" +
                    "5. Deleting a vehicle from the system\n" +
                    "6. Vehicle Search\n" +
                    "7. Exit");
            ;
            String choice = sc.nextLine();

            if (choice.equals("1"))
                createMotorcycle();
            if (choice.equals("2"))
                createCar();
            if (choice.equals("3"))
                createTruck();
            if (choice.equals("4"))
                register_vehicles();
            if (choice.equals("5"))
                deleteVehicleFromTheSystem();
            if (choice.equals("6"))
                searchVehicles();
            if (choice.equals("7"))
                break;
        }

//        String num_of_doors = sc.nextLine();
//        String car_type = sc.nextLine();
//        Car car1 = new Car(num_of_doors, car_type);
//        System.out.println(car1.toString());
//        ArrayList<String> cars = new ArrayList<String>();
//        for (int i=0; i < cars.length; i++) {
//            if ()
//        }

    }

    private static void Exit() {
    }

    public static void loadVehiclesFromFile() {
        //TODO pogledaj sta je split funkcija za stringove, citanje iz fajla...
        //opening the file to read
        try {
            Scanner scanner = new Scanner(new File(".\\src\\vehicles.txt"));
            //reading the file until the end

            while (scanner.hasNextLine()) {
                String tempObject = scanner.nextLine();
                System.out.println(tempObject);
                String[] values = tempObject.strip().split(",");
                if (values.length==6) {
                    Motorcycle motorcycle = new Motorcycle();
                    motorcycle.setNum_chassis(Integer.parseInt(values[0]));
                    motorcycle.setRegistration_num(values[1]);
                    motorcycle.setNum_horsepower(Integer.parseInt(values[2]));
                    motorcycle.setPower(Integer.parseInt(values[3]));
                    motorcycle.setMileage(Integer.parseInt(values[5]));
                    motorcycle.setVehicle_manufacturer(values[4]);
                    vehicles.add(motorcycle);
                } else{
                    try{
                        int temp= Integer.parseInt(values[7]);
                        Truck truck = new Truck();
                        truck.setNum_chassis(Integer.parseInt(values[0]));
                        truck.setRegistration_num(values[1]);
                        truck.setNum_horsepower(Integer.parseInt(values[2]));
                        truck.setPower(Integer.parseInt(values[3]));
                        truck.setMileage(Integer.parseInt(values[5]));
                        truck.setVehicle_manufacturer(values[4]);
                        truck.setMax_load_capacity(Integer.parseInt(values[6]));
                        truck.setTrailer_length(Integer.parseInt(values[7]));
                        vehicles.add(truck);

                    }
                    catch(Exception e){
                        Car car = new Car();
                        car.setNum_chassis(Integer.parseInt(values[0]));
                        car.setRegistration_num(values[1]);
                        car.setNum_horsepower(Integer.parseInt(values[2]));
                        car.setPower(Integer.parseInt(values[3]));
                        car.setMileage(Integer.parseInt(values[5]));
                        car.setVehicle_manufacturer(values[4]);
                        car.setNum_of_doors(Integer.parseInt(values[6]));
                        car.setCar_type(values[7]);
                        vehicles.add(car);
                    }
                        System.out.println("This is car");
                    }

                }
            //if not, closing the scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void saveVehiclesToFile(){
        String vehiclesToSave = "";
        for(Vehicle vehicle: vehicles) {
            if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                vehiclesToSave += motorcycle.getNum_chassis() + "," + motorcycle.getRegistration_num() + "," + motorcycle.getNum_horsepower() + "," +
                        motorcycle.getPower() + "," + motorcycle.getVehicle_manufacturer() + "," + motorcycle.getMileage() + "\n";
            }
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                vehiclesToSave += car.getNum_chassis() + "," + car.getRegistration_num() + "," + car.getNum_horsepower() + "," +
                        car.getPower() + "," + car.getVehicle_manufacturer() + "," + car.getMileage() + "," + car.getNum_of_doors() + "," +
                        car.getCar_type() + "\n";
            }
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                vehiclesToSave += truck.getNum_chassis() + "," + truck.getRegistration_num() + "," + truck.getNum_horsepower() + "," +
                        truck.getPower() + "," + truck.getVehicle_manufacturer() + "," + truck.getMileage() + "," + truck.getMax_load_capacity() + "," +
                        truck.getTrailer_length() + "\n";
            }

        }
        try {
            Files.writeString(path, vehiclesToSave,
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
        System.out.println("Enter vehicle manufacturer:");
        motorcycle.setVehicle_manufacturer(sc.nextLine());
        System.out.println("Enter the mileage:");
        motorcycle.setMileage(Integer.parseInt(sc.nextLine()));
        System.out.println("Motorcycle is saved to system..!");
        vehicles.add(motorcycle);
        saveVehiclesToFile();


    }

    public static void createCar(){
        Car car = new Car();
        System.out.println("Enter the number of chassis:");
        car.setNum_chassis(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the registration number:");
        car.setRegistration_num(sc.nextLine());
        System.out.println("Enter the number of horsepower:");
        car.setNum_horsepower(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the power:");
        car.setPower(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the mileage:");
        car.setMileage(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter vehicle manufacturer:");
        car.setVehicle_manufacturer(sc.nextLine());
        System.out.println("Enter the number of doors:");
        car.setNum_of_doors(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the car type:");
        car.setCar_type(sc.nextLine());
        System.out.println("Car is saved to system..!");
        vehicles.add(car);
        saveVehiclesToFile();
    }

    public static void createTruck(){
        Truck truck = new Truck();
        System.out.println("Enter the number of chassis:");
        truck.setNum_chassis(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the registration number:");
        truck.setRegistration_num(sc.nextLine());
        System.out.println("Enter the number of horsepower:");
        truck.setNum_horsepower(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the power:");
        truck.setPower(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the mileage:");
        truck.setMileage(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter vehicle manufacturer:");
        truck.setVehicle_manufacturer(sc.nextLine());
        System.out.println("Enter the maximum load capacity:");
        truck.setMax_load_capacity(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the trailer length:");
        truck.setTrailer_length(Integer.parseInt(sc.nextLine()));
        System.out.println("Car is saved to system..!");
        vehicles.add(truck);
        saveVehiclesToFile();
    }

    public static void register_vehicles(){
        List<Vehicle> unregistered_vehicles = new ArrayList<>();
        HashMap<Integer, Integer> unr_vehicles_and_prices = new HashMap<Integer, Integer>();
        for(Vehicle vehicle : vehicles) {
            if (!vehicle.isRegistered()){
                unr_vehicles_and_prices.put(vehicle.num_chassis, vehicle.registration_price);
                unregistered_vehicles.add(vehicle);
            }
        }
        for (Vehicle vehicle: unregistered_vehicles) {
            int price = unr_vehicles_and_prices.get(vehicle.num_chassis);
            System.out.println("The information about the vehicle:" + vehicle.toString() + price);
        }
        System.out.println("Choose the vehicle you want to register by entering its number of chassis:");
        int num_chassis = Integer.parseInt(sc.nextLine());
        int price = unr_vehicles_and_prices.get(num_chassis);
//        int numC = vehicles.get(num_chassis);
        boolean isChosen = true;
        for (Vehicle vehicle: vehicles) {
            if (vehicle.getNum_chassis() == num_chassis) {
                vehicle.setRegistered(true);
                vehicle.setRegistration_price(price);
                saveVehiclesToFile();
                break;
            }
        }
    }
    public static void deleteVehicleFromTheSystem() {
        System.out.println("Choose the vehicle you want to delete from the system by entering its number of chassis:");
        int num_chassis = Integer.parseInt(sc.nextLine());
        boolean isDeleted = true;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNum_chassis() == num_chassis) {
                vehicle.setDeleteVehicle(true);
                System.out.println("Vehicle deleted");
                saveVehiclesToFile();
                break;
            }
        }


    }

    public static void searchVehicles(){
        System.out.println("Enter the manufacturer of the vehicle you are interested in.");
        String manufacturer = (sc.nextLine());
        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicle_manufacturer.equals(manufacturer)) {
                System.out.println(vehicle.toString());

        }





        }
}