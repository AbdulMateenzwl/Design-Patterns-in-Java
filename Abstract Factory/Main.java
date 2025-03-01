
interface Burger {
    void prepare();
}

class BeefBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing BeefBurger");
    }
}

class VeggieBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing VeggieBurger");
    }
}

interface Pizza {
    void prepare();
}

class ChickenPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza");
    }
}

class VegPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza");
    }
}

abstract class Restaurant {
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public Pizza orderPizza() {
        Pizza pizza = createPizza();
        pizza.prepare();
        return pizza;
    }

    public abstract Burger createBurger();

    public abstract Pizza createPizza();
}

class BeefBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }

    @Override
    public Pizza createPizza() {
        return new ChickenPizza();
    }
}

class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }

    @Override
    public Pizza createPizza() {
        return new VegPizza();
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurant beefResto = new BeefBurgerRestaurant();
        Burger beefBurger = beefResto.orderBurger();
        Pizza chickenPizza = beefResto.orderPizza();

        Restaurant veggieResto = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieResto.orderBurger();
        Pizza vegPizza = veggieResto.orderPizza();
    }
}
