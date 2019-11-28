import java.util.List;

public interface Shop {
    Check getCheck(List<Integer> listIds);
    void putInShop(Item item);
}
