import java.util.ArrayList;
public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory
    // list of player items

    private Room currentRoom;

    private ArrayList<Item> itemList = new ArrayList<>();

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
        itemList.add(item);
    }

    public Item removeItem(String name) {
        for (Item item : itemList) {
            if (item.getItemName().equals(name)) {
                itemList.remove(item);
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

}
