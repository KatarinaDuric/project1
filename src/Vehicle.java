public abstract class Vehicle {
    protected int num_chassis;
    protected int registration_num;
    protected int num_horsepower;
    protected int power;
    protected String vehicle_manufacturer;
    protected int mileage;
    public abstract float calculateRegistration();

    protected boolean isRegistered;
    protected boolean deleteVehicle;

    public boolean isDeleteVehicle() {
        return deleteVehicle;
    }

    public void setDeleteVehicle(boolean deleteVehicle) {
        this.deleteVehicle = deleteVehicle;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public int getNum_chassis() {
        return num_chassis;
    }

    public void setNum_chassis(int num_chassis) {
        this.num_chassis = num_chassis;
    }

    public int getRegistration_num() {
        return registration_num;
    }

    public void setRegistration_num(int registration_num) {
        this.registration_num = registration_num;
    }

    public int getNum_horsepower() {
        return num_horsepower;
    }

    public void setNum_horsepower(int num_horsepower) {
        this.num_horsepower = num_horsepower;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getVehicle_manufacturer() {
        return vehicle_manufacturer;
    }

    public void setVehicle_manufacturer(String vehicle_manufacturer) {
        this.vehicle_manufacturer = vehicle_manufacturer;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
