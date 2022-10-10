import ENUM.Attack;
import ENUM.EatFood;
import ENUM.EquipItem;

import java.util.ArrayList;

public class Adventure {

    public Map map = new Map();
    public Player player = new Player();


    public Player getPlayer() {
        return player;
    }

    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
    }

    public Room getCurrentRoom() {
            return player.getCurrentRoom();
    }


    //Items
    public ArrayList<Weapon> getCurrentWeapon() {
        return player.getCurrentWeapon();
    }

    public ArrayList<Item> getItemListPlayer() {
        return player.getItemListPlayer();
    }

    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public Item searchItemInv(String itemName) {
        return player.searchItemInv(itemName);
    }

    public Item getEquippedItem(String itemName) {
        return player.getEquippedItem(itemName);
    }


    //Actions
    public boolean go(String direction) {
        return player.move(direction);
    }

    public EatFood eatFood(String itemName) {
        return player.eatFood(itemName);
    }

    public EquipItem equipItem(String itemName) {
        return player.equipItem(itemName);
    }

    public Attack attack(String itemName) {
        return player.attack(itemName);
    }

}
