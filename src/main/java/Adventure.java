import ENUM.EatFood;

import java.util.ArrayList;

public class Adventure {

    public Map map = new Map();
    public Player player = new Player();



//Getter
    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
            return player.getCurrentRoom();
    }

    public Item searchItemInv(String itemName) {
            return player.searchItemInv(itemName);
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

    /*public Player getHealth(int health) {
        return player.getHealth(health);
    }*/

    public Item removeItemInventory(String itemName) {
        return player.removeItem(itemName);
    }

    public ArrayList<Item> getItemListPlayer() {
        return player.getItemListPlayer();
    }

    public ArrayList<Weapon> getCurrentWeapon() {
        return player.getCurrentWeapon();
    }


    public EatFood eatFood(String itemName) {
        return player.eatFood(itemName);
    }



    public Item addEquippedWeapon(String itemName) {
        return player.takeEquippedItem(itemName);
    }





}
