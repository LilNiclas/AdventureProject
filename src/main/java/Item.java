public class Item {

    public String name;
    public String description;

    public Item(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getItemName() {
        return name;
    }

    @Override
    public String toString() {
        return name + description;
    }
}
