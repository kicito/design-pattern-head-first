package decorator.starbuzz;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void testEspresso() {
        Beverage beverage = new Espresso();
        assertTrue(beverage.getDescription().equals("Espresso"));
        assertTrue(beverage.cost() == 1.99);
    }

    @Test
    public void testDarkRoastDoubleMocha() {
        Beverage beverage = new DarkRoast();
        assertTrue(beverage.getDescription().equals("Dark Roast Coffee"));
        assertTrue(beverage.cost() == .99);
        beverage = new Mocha(beverage);
        assertTrue(beverage.getDescription().equals("Dark Roast Coffee" + ", Mocha"));
        assertTrue(beverage.cost() == .99 + .2);
        beverage = new Mocha(beverage);
        assertTrue(beverage.getDescription().equals("Dark Roast Coffee" + ", Mocha" + ", Mocha"));
        assertTrue(beverage.cost() == .99 + .2 + .2);
        beverage = new Whip(beverage);
        assertTrue(beverage.getDescription().equals("Dark Roast Coffee" + ", Mocha" + ", Mocha" + ", Whip"));
        assertTrue(beverage.cost() == .99 + .2 + .2 + .1);
    }

    @Test
    public void testHouseBlend() {
        Beverage beverage = new HouseBlend();
        assertTrue(beverage.getDescription().equals("House Blend Coffee"));
        assertTrue(beverage.cost() == .89);
        beverage = new Soy(beverage);
        assertTrue(beverage.getDescription().equals("House Blend Coffee" + ", Soy"));
        assertTrue(beverage.cost() == .89 + .15);
        beverage = new Mocha(beverage);
        assertTrue(beverage.getDescription().equals("House Blend Coffee, Soy, Mocha"));
        assertTrue(beverage.cost() == .89 + .15 + .2);
        beverage = new Whip(beverage);
        assertTrue(beverage.getDescription().equals("House Blend Coffee, Soy, Mocha, Whip"));
        assertTrue(beverage.cost() == .89 + .15 + .2 + .1);
    }
}
