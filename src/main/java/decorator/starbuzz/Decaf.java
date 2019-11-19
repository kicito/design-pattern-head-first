package decorator.starbuzz;

public class Decaf extends Beverage{
    public Decaf(){
        description = "Decaffeinate coffee";
    }

    public double cost(){
        return 1.05;
    }
}