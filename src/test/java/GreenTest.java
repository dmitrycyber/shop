import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GreenTest {
    private static Item item1;
    private static Item item2;
    private static Item item3;
    private static Item item4;
    private static Green shop;

    @BeforeClass
    public static void init(){
        item1 = new Keyboard(1, "Keyboard A4Tech", 100);
        item2 = new Keyboard(2, "Keyboard Logitech", 100);
        item3 = new Mouse(3, "Mouse Defender", 100);
        item4 = new Mouse(4, "Mouse Marvo", 100);
    }

    @Before
    public void createShop(){
        shop = new Green();
    }

    @Test
    public void testCountOfAddingItems(){
        shop.putInShop(item1);
        shop.putInShop(item2);
        shop.putInShop(item3);
        shop.putInShop(item4);
        Assert.assertEquals(4, shop.getMapOfItems().size());
    }

    @Test
    public void testReduceItemsAfterBuying(){
        shop.putInShop(item1);
        shop.putInShop(item2);
        shop.putInShop(item3);
        shop.putInShop(item4);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item4);
        List<Integer> collect = itemList
                .stream()
                .map(Item::getId)
                .collect(Collectors.toList());
        shop.getCheck(collect);
        Assert.assertEquals(3, shop.getMapOfItems().size());
    }

    @Test
    public void testDublicateItems(){
        shop.putInShop(item1);
        shop.putInShop(item1);
        shop.putInShop(item1);
        shop.putInShop(item4);
        shop.putInShop(item4);
        Assert.assertEquals(2, shop.getMapOfItems().size());
    }

    @Test
    public void testNotEnoughItems(){
        shop.putInShop(item1);
        shop.putInShop(item2);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item2);
        itemList.add(item2);
        List<Integer> collect = itemList
                .stream()
                .map(Item::getId)
                .collect(Collectors.toList());
        Check check = shop.getCheck(collect);
        Map<Item, Integer> addedItemsToCheck = check.getAddedItems();
        Assert.assertEquals(java.util.Optional.of(1).get(), addedItemsToCheck.get(item2));

    }

    @Test(expected = NoBuyingItemsException.class)
    public void testNotNullListOfBuyingItems(){
        List<Integer> listIdsOfBuyingItems = new ArrayList<>();
        shop.getCheck(listIdsOfBuyingItems);
    }
}
