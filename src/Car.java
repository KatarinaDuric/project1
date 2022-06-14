class Car extends Vehicle {
    private int num_of_doors;
    private int car_type;

    Car (int num_of_doors,String car_type){
        this.num_of_doors= num_of_doors;
        this.car_type = Integer.parseInt(car_type);
    }
    @Override
    public float calculateRegistration() {
        return (power*num_of_doors*7);
    }

    public int getNum_of_doors() {
        return num_of_doors;
    }

    public void setNum_of_doors(int num_of_doors) {
        this.num_of_doors = num_of_doors;
    }

    public int getCar_type() {
        return car_type;
    }

    public void setCar_type(int car_type) {
        this.car_type = car_type;
    }
}