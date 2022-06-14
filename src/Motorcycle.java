class Motorcycle extends Vehicle {
    @Override
    public float calculateRegistration() {
        return power * 10;
    }
}
