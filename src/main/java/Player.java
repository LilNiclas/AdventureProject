import java.util.ArrayList;

public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory
    // list of player items

    // todo inventory skal havde at vide hvilket våben man har equpied


    private Room currentRoom;
    private int health;
    private ArrayList<Item> itemListPlayer;
    private ArrayList<Weapon> currentWeapon;

    public Player() {
        itemListPlayer = new ArrayList<>();
        currentWeapon = new ArrayList<>();
        health = 100;
    }

    public ArrayList<Item> getItemListPlayer() {
        return itemListPlayer;
    }

    public ArrayList<Weapon> getCurrentWeapon() {
        return currentWeapon;
    }


    //Getter
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getHealth() {
            return health;
        }

    //setter
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Player setHealth(int health) {
        this.health = this.health + health;
        return null;
    }


    //Metoder til move
    //Move          (n, e, S, w)
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

    //Metoder til player array
    //AddItem       (add Item til playerinventory Array)
    //RemoveItem    (remove item fra fra playerInventory Array)
    //TakeItem      (takeItem getter fra room array og sletter item der og adder til playerinventory)
    //dropItem      (sletter fra player array og adder til room array)
    //getItem       (getter item fra player array)
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

    public Item getItem(String name) {
        for (Item item : itemListPlayer) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }





    //Metode til currentWeapon array
    //add
    //remove
    //
    public Item addEquippedItem(Item item) {
            currentWeapon.add((Weapon) item);
            return item;
    }

    public Item removeToEquipped(String name) {
        for (Item item : currentWeapon) {
            if (item.getItemName().equals(name)) {
                currentWeapon.remove(item);
                return item;
            }
        }
        return null;
    }

    public Item takeEquippedItem(String itemName) {

        Item itemInPlayer = removeToEquipped(itemName);
        addEquippedItem(itemInPlayer);
        return itemInPlayer;
    }

    public Item getEquippedItem(String name) {
        for (Item item : currentWeapon) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }


}
