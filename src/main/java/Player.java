import java.util.ArrayList;
public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory
    // list of player items

    private Room currentRoom;
    private int health;
    private ArrayList<Item> itemListPlayer;
    
    public Player() {
        itemListPlayer = new ArrayList<>();
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

    public void addItem(Item item) {
        itemListPlayer.add(item);
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



}
