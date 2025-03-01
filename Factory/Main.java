
import javax.print.attribute.standard.RequestingUserName;

interface Burger{
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

abstract class Restaurant {

    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}

class BeefBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger(){
        return new BeefBurger();
    }
}

class VeggieBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger(){
        return new VeggieBurger();
    }
}

public class Main {

    public static void main(String[] args) {
        Restaurant beefResto = new BeefBurgerRestaurant();
        Burger beefBurger = beefResto.orderBurger();

        Restaurant veggieResto = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieResto.orderBurger();
        
    }
}
