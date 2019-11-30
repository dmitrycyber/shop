import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDB {
    private String userName = "postgres";
    private String password = "postgres";
    private String connectionUrl = "jdbc:postgresql://localhost:5432/Shop";

    public void createTableOfProducts(){
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("create table products(id int not null, " +
                    "name varchar(50) not null, " +
                    "price int not null, " +
                    "type varchar(50) not null)");
            System.out.println("Table is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTableOfProducts(){
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop table products");
            System.out.println("Table is deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductToTable(int id, String name, int price, String type){
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("insert into products (id, name, price, type) values ('"+id+"', '"+name+"', '"+price+"', '"+type+"')");
            System.out.println(name + " successfully added to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProductsToTable(){
        addProductToTable(1, "Logitec", 100, "Mouse");
        addProductToTable(2, "A4Tech", 200, "Keyboard");
        addProductToTable(3, "Benq", 600, "Monitor");
        addProductToTable(1, "Logitec", 100, "Mouse");
        addProductToTable(2, "A4Tech", 200, "Keyboard");
        addProductToTable(3, "Benq", 600, "Monitor");
    }

    public void putItemsFromDbToShop(Shop shop){
        List<Item> listOfItems = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Keyboard")){
                    Item item = new Keyboard(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("price"));
                    shop.putInShop(item);
                }
                else if (resultSet.getString("type").equals("Mouse")){
                    Item item = new Mouse(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("price"));
                    shop.putInShop(item);
                }
                else if (resultSet.getString("type").equals("Monitor")){
                    Item item = new Monitor(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("price"));
                    shop.putInShop(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
