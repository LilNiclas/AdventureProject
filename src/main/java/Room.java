import java.util.ArrayList;

public class Room {
    //The Room Class constructs the attributes for the rooms
    //list of items in a room
    private ArrayList<Item> itemList = new ArrayList<>();

    private String name;
    private String description;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description, Room north, Room east, Room south, Room west) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getEast() {
        return east;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    //Setter
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }



    //List of items
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }


    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public boolean roomEmpty() {
        return itemList.isEmpty();
    }

}
