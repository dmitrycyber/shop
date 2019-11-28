import java.util.ArrayList;
import java.util.List;


public class Sosedi implements Shop {
    private List<Item> listOfItems = new ArrayList<>();

    public void putInShop(Item item) {
        if (item == null) {
            return;
        }
        listOfItems.add(item);
    }

    public Check getCheck(List<Integer> listIds){
        if (listIds.isEmpty()) {
            throw new NoBuyingItemsException("List of buying products is empty");
        }
        Check check = new Check();
        Integer idOfBuyingItem;
        Integer idOfItemInShop;
        Item itemInShop;
        for (int i = 0; i < listOfItems.size(); i++) {
            itemInShop = listOfItems.get(i);
            idOfItemInShop = itemInShop.getId();
            for (int j = 0; j < listIds.size(); j++) {
                idOfBuyingItem = listIds.get(j);
                if (idOfBuyingItem.equals(idOfItemInShop)) {
                    check.addItemsToCheck(itemInShop);
                }
            }
        }
        return check;
    }

    public List<Item> getListOfAddedItems(){
        List<Item> copyOfListOfAddedItems = new ArrayList<>(listOfItems);
        return copyOfListOfAddedItems;
    }
}

