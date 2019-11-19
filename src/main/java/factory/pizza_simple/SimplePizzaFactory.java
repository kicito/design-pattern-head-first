package factory.pizza_simple;

public class SimplePizzaFactory {

    public enum PizzaType {
        CHEESE, PEPPERONI, CLAM, VEGGIE
    }

    public Pizza createPizza(PizzaType type) {

        Pizza pizza = null;

        switch (type) {
        case CHEESE:
            pizza = new CheesePizza();
            break;
        case PEPPERONI:
            pizza = new PepperoniPizza();
            break;
        case CLAM:
            pizza = new ClamPizza();
            break;
        case VEGGIE:
            pizza = new VeggiePizza();
            break;
        default:
            System.out.println("unrecognized type" + type.name());
        }

        return pizza;
    }
}