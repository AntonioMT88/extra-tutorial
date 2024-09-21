public class Main_Java {

    public static void main(String[] args) {
        Car car = new Car("Opel", "Corsa", 2015);
        String message = String.format("You have a %s %s from %d", car.getMake(), car.getModel(), car.getYear());
        System.out.println(message);
    }
}

class Car {
    String model;
    String make;
    int year;

    Car(String model, String make, int year) {
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}