class Truck extends Vehicle {
    @Override
    public String toString() {
        return "This truck's information is{" +
                "num_chassis=" + num_chassis +
                ", registration_num='" + registration_num + '\'' +
                ", num_horsepower=" + num_horsepower +
                ", power=" + power +
                ", vehicle_manufacturer='" + vehicle_manufacturer + '\'' +
                ", mileage=" + mileage +
                ", registration_price=" + registration_price +
                ", isRegistered=" + isRegistered +
                ", deleteVehicle=" + deleteVehicle +
                "max_load_capacity=" + max_load_capacity +
                ", trailer_length=" + trailer_length +
                '}';
    }

    private int max_load_capacity;
    private int trailer_length;

    Truck() {

    }

    public int getMax_load_capacity() {
        return max_load_capacity;
    }

    public void setMax_load_capacity(int max_load_capacity) {
        this.max_load_capacity = max_load_capacity;
    }

    public int getTrailer_length() {
        return trailer_length;
    }

    public void setTrailer_length(int trailer_length) {
        this.trailer_length = trailer_length;
    }

    @Override
    public float calculateRegistration() {
        return (power * (max_load_capacity / trailer_length) * 2);
    }
}
