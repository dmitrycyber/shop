import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SosediTest {
    private static Item item1;
    private static Item item2;
    private static Item item3;
    private static Item item4;
    private static Sosedi sosedi;

    @BeforeClass
    public static void init(){
        item1 = new Keyboard(1, "Keyboard A4Tech", 100);
        item2 = new Keyboard(2, "Keyboard Logitech", 100);
        item3 = new Mouse(3, "Mouse Defender", 100);
        item4 = new Mouse(4, "Mouse Marvo", 100);
    }

    @Before
    public void createSosedi(){
        sosedi = new Sosedi();
    }

    @Test
    public void testAddingItems(){
        sosedi.putInShop(item1);
        sosedi.putInShop(item2);
        sosedi.putInShop(item3);
        sosedi.putInShop(item4);
        assertTrue(sosedi.getListOfAddedItems().contains(item3));
    }

    @Test
    public void testCantPutNullItemInShop() {
        Item item = null;
        sosedi.putInShop(item);
        assertFalse(sosedi.getListOfAddedItems().contains(item));
    }

    @Test(expected = NoBuyingItemsException.class)
    public void testNotNullListOfBuyingItems(){
        List<Integer> listIdsOfBuyingItems = new ArrayList<>();
        sosedi.getCheck(listIdsOfBuyingItems);
    }

    @Test
    public void testСountOfAddedItems(){
        sosedi.putInShop(item1);
        sosedi.putInShop(item2);
        sosedi.putInShop(item3);
        sosedi.putInShop(item4);
        Assert.assertEquals(4, sosedi.getListOfAddedItems().size());
    }

    @Test
    public void testDublicateItems(){
        sosedi.putInShop(item1);
        sosedi.putInShop(item2);
        sosedi.putInShop(item2);
        sosedi.putInShop(item3);
        sosedi.putInShop(item4);
        Assert.assertEquals(5, sosedi.getListOfAddedItems().size());
    }

    @Test
    public void testPriceOfItemsInShop(){
        sosedi.putInShop(item1);
        sosedi.putInShop(item2);
        sosedi.putInShop(item3);
        Assert.assertEquals(300, sosedi.priceOfAddedItems());
    }

    @Test
    public void testPriceNoItemsInShop(){
        Assert.assertEquals(0, sosedi.priceOfAddedItems());
    }
}
