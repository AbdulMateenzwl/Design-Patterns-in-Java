
class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

    private Car() {
        // Private constructor to prevent instantiation from outside
    }

    public Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}

class Director {

    public void buildLambo(CarBuilder carBuilder) {
        carBuilder
                .Id(1)
                .Brand("Lamborghini")
                .Model("Aventador")
                .Color("Yellow");
    }
}

class CarBuilder {
    private int id;
    private String brand;
    private String model;
    private String color;

    public CarBuilder Id(int id) {
        this.id = id;
        return this;
    }

    public CarBuilder Brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder Model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder Color(String color) {
        this.color = color;
        return this;
    }

    public Car build() {
        Car car = new Car(id, brand, model, color);
        return car;
    }

}

public class Main {

    public static void main(String[] args) {

        Car car = new CarBuilder()
                .Id(1)
                .Brand("brand")
                .Model("Model")
                .Color("color").build();

        System.out.println(car);

        CarBuilder carBuilder = new CarBuilder();
        Director director = new Director();
        director.buildLambo(carBuilder);
        Car lambo = carBuilder.build();
        System.out.println(lambo);
    }
}
