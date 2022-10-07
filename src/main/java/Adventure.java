import java.util.ArrayList;

public class Adventure {
// The Adventure class is the controler for the whole game
// But does not control the player

    public Map map = new Map();
    public Player player = new Player();

//Getter
//Get player
//Get currentroom
//Get Item
    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
            return player.getCurrentRoom();
    }

    public Item getItem(String itemName) {
            return player.getItem(itemName);
    }

//Metoder
    public boolean go(String direction) {
        return player.move(direction);
    }

    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
    }



    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public Player setHealth(int health) {
        return player.setHealth(health);
    }

    public Item removeItemInventory(String itemName) {
        return player.removeItem(itemName);
    }

    public ArrayList<Item> getItemListPlayer() {
        return player.getItemListPlayer();
    }

    public ArrayList<Weapon> getCurrentWeapon() {
        return player.getCurrentWeapon();
    }

    /*public Item getItemPlayer(String itemName) {
        return player.getItemPlayer(itemName);
    }*/

    public Item addEquippedWeapon(String itemName) {
        return player.takeEquippedItem(itemName);
    }





}
