public class Item {

    public String itemName;
    public String description;

    public Item(String itemName, String description) {
        this.description = description;
        this.itemName = itemName;
    }
    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName + description;
    }
}
