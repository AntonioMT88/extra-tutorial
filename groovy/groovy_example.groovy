class Car_groovy {
    def model
    def make
    def year

    Car_groovy (model, def make, def year) {
        this.model = model
        this.make = make
        this.year = year
    }
}

def car = new Car_groovy("Opel", "Corsa", 2015)

println("You have a ${car.getMake()} ${car.getModel()} from ${car.getYear()}")