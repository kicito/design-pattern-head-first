package intro.simuduck;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testMallard() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        assertEquals("Quack\n", outContent.toString());
        outContent.reset();
        mallard.display();
        assertEquals("I'm a real Mallard duck\n", outContent.toString());
        outContent.reset();
        
        mallard.performFly();
        assertEquals("I’m flying!!\n", outContent.toString());
        outContent.reset();

    }


    @Test
    public void testModelDuck() {
        Duck modelDuck = new ModelDuck();
        modelDuck.display();
        assertEquals("I'm a model duck\n", outContent.toString());
        outContent.reset();

        modelDuck.performQuack();
        assertEquals("Quack\n", outContent.toString());
        outContent.reset();
        
        modelDuck.performFly();
        assertEquals("I can't fly\n", outContent.toString());
        outContent.reset();


        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
        assertEquals("I'm flying with a rocket!\n", outContent.toString());
        outContent.reset();

    }
}