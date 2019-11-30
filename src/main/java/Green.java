import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Green implements Shop {
    private Map<Item, Integer> mapOfItems = new HashMap<>();
    private Map<Integer, Item> idsOfItems = new HashMap<>();

    public Map<Item, Integer> getMapOfItems() {
        return new HashMap<>(mapOfItems);
    }

    public void putInShop(Item item) {
        if (item == null) {
            return;
        }
        Integer integer = mapOfItems.get(item);
        if (integer == null) {
            integer = 1;
            mapOfItems.put(item, integer);
        }
        else {
            mapOfItems.put(item, mapOfItems.get(item)+1);
        }
        idsOfItems.put(item.getId(), item);
    }

    public Check getCheck(List<Integer> listIds) {
        if (listIds.isEmpty()) {
            throw new NoBuyingItemsException("List of buying products is empty");
        }
        Check check = new Check();
        Integer countOfItemsInShop;
        for (int i = 0; i < listIds.size(); i++) {
            Item buyingItem = idsOfItems.get(listIds.get(i));
            countOfItemsInShop = mapOfItems.get(buyingItem);
            check.addItemsToCheck(buyingItem);
            if (countOfItemsInShop == null) {
            }
            else if (countOfItemsInShop > 1) {
                mapOfItems.put(buyingItem, countOfItemsInShop - 1);
            }
            else {
                mapOfItems.remove(buyingItem);
            }
        }
        return check;
    }
}
