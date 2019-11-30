import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        WorkWithDB db = new WorkWithDB();
        //db.createTableOfProducts();
        //db.deleteTableOfProducts();
        //db.addProductsToTable();
        Green shop = new Green();
        db.putItemsFromDbToShop(shop);
        System.out.println(shop.getMapOfItems());
    }

}

