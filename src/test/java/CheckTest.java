import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckTest {
    private static Item item1;
    private static Item item2;
    private static Item item3;
    private static Item item4;
    private static Shop shop;

    @BeforeClass
    public static void init(){
        item1 = new Keyboard(1, "Keyboard A4Tech", 50);
        item2 = new Keyboard(2, "Keyboard Logitech", 100);
        item3 = new Mouse(3, "Mouse Defender", 150);
        item4 = new Mouse(4, "Mouse Marvo", 200);
    }

    @Before
    public void createSosedi(){
        shop = new Sosedi();
    }

    @Test
    public void testAddingItems(){
        shop.putInShop(item1);
        List<Integer> listIdsOfAddedItems = new ArrayList<>();
        listIdsOfAddedItems.add(item1.getId());
        Check check = shop.getCheck(listIdsOfAddedItems);
        assertTrue(check.getAddedItems().containsKey(item1));
    }

    @Test
    public void testCalculatePriceOfBuyingItems(){
        shop.putInShop(item1);
        shop.putInShop(item2);
        shop.putInShop(item3);
        shop.putInShop(item4);
        List<Integer> listIdsOfAddedItems = new ArrayList<>();
        listIdsOfAddedItems.add(item1.getId());
        listIdsOfAddedItems.add(item2.getId());
        listIdsOfAddedItems.add(item3.getId());
        listIdsOfAddedItems.add(item4.getId());
        Integer expectedSumOfAddedItems = item1.getPrice() +
                                    item2.getPrice() +
                                    item3.getPrice() +
                                    item4.getPrice();
        Check check = shop.getCheck(listIdsOfAddedItems);
        assertEquals(expectedSumOfAddedItems, check.getPriceOfAddedItems());
    }

    @Test
    public void testCantPutNullItemInShop() {
        Item item = null;
        Check check = new Check();
        check.addItemsToCheck(item);
        assertFalse(check.getAddedItems().containsKey(item));
    }
}
