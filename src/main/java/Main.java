import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------TASK1------------");

        Shop shop1 = new Sosedi();
        Item mouse1 = new Mouse(1, "A4Tech", 10);
        Item mouse2 = new Mouse(2, "Logitech", 20);
        Item mouse3 = new Mouse(3, "Samsung", 30);
        Item mouse4 = new Mouse(4, "C4", 40);

        shop1.putInShop(mouse1);
        shop1.putInShop(mouse2);
        shop1.putInShop(mouse3);
        shop1.putInShop(mouse4);
        shop1.putInShop(mouse4);

        List<Integer> listOfIdsPurchasedItems1 = new ArrayList<>();
        /*listOfIdsPurchasedItems1.add(1);
        listOfIdsPurchasedItems1.add(2);
        listOfIdsPurchasedItems1.add(3);
        listOfIdsPurchasedItems1.add(4);
        listOfIdsPurchasedItems1.add(4);*/
        try {
            Check check1 = shop1.getCheck(listOfIdsPurchasedItems1);
            System.out.println(check1);
        }
        catch (NoBuyingItemsException e){
            System.out.println(e.getMessage());
        }


        System.out.println("\n" +"-----------TASK2------------");
        Item keyboard1 = new Keyboard(1, "A4Tech", 10);
        Item keyboard2 = new Keyboard(2, "Logitech", 20);
        Item keyboard3 = new Keyboard(3, "Samsung", 30);
        Item keyboard4 = new Keyboard(4, "C4", 40);

        Shop shop2 = new Green();
        shop2.putInShop(keyboard1);
        shop2.putInShop(keyboard1);
        shop2.putInShop(keyboard2);
        shop2.putInShop(keyboard3);
        shop2.putInShop(keyboard4);

        List<Integer> listOfIdsPurchasedItems2 = new ArrayList<>();
        /*listOfIdsPurchasedItems2.add(1);
        listOfIdsPurchasedItems2.add(1);
        listOfIdsPurchasedItems2.add(1);
        listOfIdsPurchasedItems2.add(2);*/
        try {
            Check check2 = shop2.getCheck(listOfIdsPurchasedItems2);
            System.out.println(check2);
        }
        catch (NoBuyingItemsException e){
            System.out.println(e.getMessage());

        }



        /*FileReader fileReader = new FileReader("123.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String productString = "";
        Item item;
        Shop1 shop1 = new Shop1();

        while (productString != null) {
            productString = bufferedReader.readLine();
            if (productString == null) {
                break;
            }
            String[] split = productString.split(",");
            item = new Item(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]));
            shop1.putInShop(item);
        }*/
    }

}

