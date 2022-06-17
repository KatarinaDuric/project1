class Motorcycle extends Vehicle {
    Motorcycle() {

    }
    @Override
    public float calculateRegistration() {
        return power * 10;
    }

    @Override
    public String toString() {
        return "This motorcycle's information is{" +
                "num_chassis=" + num_chassis +
                ", registration_num='" + registration_num + '\'' +
                ", num_horsepower=" + num_horsepower +
                ", power=" + power +
                ", vehicle_manufacturer='" + vehicle_manufacturer + '\'' +
                ", mileage=" + mileage +
                ", registration_price=" + registration_price +
                ", isRegistered=" + isRegistered +
                ", deleteVehicle=" + deleteVehicle +
                '}';
    }
}
