import java.util.ArrayList;

public class Room {
    //The Room Class constructs the attributes for the rooms
    //list of items in a room
    private ArrayList<Item> itemListRoom = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    private String name;
    private String description;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description) {
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


    //List of items + enemies
    public ArrayList<Item> getItemListRoom() {
        return itemListRoom;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }


    //Metoder
    //AddItem       (til room arraylist)
    //RemoveItem    (Fra room arrayList)
    //GetItem       (henter item fra bruger input i room arraylist)
    public void addItem(Item item) {
        itemListRoom.add(item);
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public Weapon addEnemyItem(Weapon weapon) {
        itemListRoom.add(weapon);
        return weapon;
    }

    public Item removeItem(String name) {
        for (Item item : itemListRoom) {
            if (item.getItemName().equals(name)) {
                itemListRoom.remove(item);
                return item;
            }
        }
        return null;
    }

    public Enemy removeEnemy(String name) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equals(name)) {
                enemies.remove(enemy);
                return enemy;
            }
        }
        return null;
    }

    public Item getItem(String name) {
        for (Item item : itemListRoom) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Enemy searchEnemy(String searchEnemy) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equals(searchEnemy)) {
                return enemy;
            }
        }
        return null;
    }

}
