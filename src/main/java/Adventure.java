import ENUM.EatFood;
import ENUM.EquipItem;

import java.util.ArrayList;

public class Adventure {

    public Map map = new Map();
    public Player player = new Player();


    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
            return player.getCurrentRoom();
    }

    public Item searchItemInv(String itemName) {
            return player.searchItemInv(itemName);
    }

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

    public ArrayList<Item> getItemListPlayer() {
        return player.getItemListPlayer();
    }





    public EquipItem equipItem(String itemName) {
        return player.equipItem(itemName);
    }


    public EatFood eatFood(String itemName) {
        return player.eatFood(itemName);
    }





    public ArrayList<Weapon> getCurrentWeapon() {
        return player.getCurrentWeapon();
    }





    /*public Item removeItemInventory(String itemName) {
        return player.removeItem(itemName);
    }

    public Item addEquippedWeapon(String itemName) {
        return player.takeEquippedItem(itemName);
    }*/





}
