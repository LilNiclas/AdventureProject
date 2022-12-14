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

    public int getPlayerHealth() {
        return player.getHealth();
    }

    public int getEnemyHealth(String name) {
        return player.getEnemyHealth(name);
    }


    //Items
    public Weapon getCurrentWeapon() {
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


    //Actions
    public boolean go(String commandParameter) {
        return player.move(commandParameter);
    }

    public EatFood eatFood(String itemName) {
        return player.eatFood(itemName);
    }

    public EquipItem equipItem(String itemName) {
        return player.equipItem(itemName);
    }

    public EquipItem unEquipItem(String itemName) {
        return player.unEquipItem(itemName);
    }

    public Attack attack(String itemName) {
        return player.attack(itemName);
    }

}
