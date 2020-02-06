import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
     private static Item item;

     @BeforeClass
     public static void init(){
        item = new Keyboard(1, "Defender", 100);
     }

    @Test
    public void testPriceOfItem() {
        int expectedPrice = 100;
        assertEquals(item.getPrice(), expectedPrice);
    }

    @Test
    public void testIdOfItem() {
        int expectedID = 1;
        assertEquals(item.getId(), expectedID);
    }

    @Test
    public void testNameOfItem() {
        String expectedName = "Defender";
        assertEquals(item.getName(), expectedName);
    }

}
