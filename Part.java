package Assign1;

public class Part {
    int id;
    String name;
    int quantity;

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getId() { return id; }

    public Part(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
