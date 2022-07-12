import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private float price;
    private float discount;
    private int quantity;

    public Product(int id, String name, float price, float discount, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSale(){
        return this.price - this.discount;
    }
}
