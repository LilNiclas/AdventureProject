import java.util.ArrayList;
public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory
    // list of player items

    // todo inventory skal havde at vide hvilket våben man har equpied


    private Room currentRoom;
    private int health;
    private ArrayList<Item> itemListPlayer;
    private ArrayList<Item> equipWeapon;
    
    public Player() {
        itemListPlayer = new ArrayList<>();
        equipWeapon = new ArrayList<>();
        health = 100;
    }
    

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;

        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouth();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWest();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public Item addItem(Item item) {
        itemListPlayer.add(item);
        return item;
    }

    public Item removeItem(String name) {
        for (Item item : itemListPlayer) {
            if (item.getItemName().equals(name)) {
                itemListPlayer.remove(item);
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItemListPlayer() {
        return itemListPlayer;
    }


    public Item takeItem(String itemName) {
        Item pickedUpItem = getCurrentRoom().removeItem(itemName);
        addItem(pickedUpItem);
        return pickedUpItem;
    }

    public Item dropItem(String itemName) {
        Item droppedItem = removeItem(itemName);
        currentRoom.addItem(droppedItem);
        return droppedItem;
    }


    // get til get health
    public int getHealth() {
        return health;
    }

    public Player setHealth(int health) {
        this.health = this.health+health;
        return null;
    }

    public Item getItem(String name) {
        for (Item item : itemListPlayer) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Item getEquippedItem(String name) {
        for (Item item : equipWeapon) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Item addEquipWeapon(Item item) {
        equipWeapon.add(item);
        return item;
    }




}
