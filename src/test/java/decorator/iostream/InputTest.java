package decorator.iostream;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class InputTest {
    @Test
    public void testLowerStream() {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("src/test/java/decorator/iostream/test.txt")));

            while ((c = in.read()) >= 0) {
                assertTrue(!Character.isUpperCase(c));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            fail("unexpected io exception");
        }
    }
}