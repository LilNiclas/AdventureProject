import ENUM.Attack;
import ENUM.EatFood;
import ENUM.EquipItem;

import java.util.ArrayList;

public class Player {
// Player Class knows the possion of the player
// Player Class will also be in control of the player's inventory
    // list of player items

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

    //Metoder til player array
    //AddItem       (add Item til playerinventory Array)
    //RemoveItem    (remove item fra fra playerInventory Array)
    //TakeItem      (takeItem getter fra room array og sletter item der og adder til playerinventory)
    //dropItem      (sletter fra player array og adder til room array)
    //getItem       (getter item fra player array)

    //Items
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

    public Item searchItemInv(String itemName) {
        for (Item item : itemListPlayer) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Item getEquippedItem(String name) {
        for (Item item : currentWeapon) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        return null;
    }


    //Actions
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

    public EatFood eatFood(String itemName) {
        Item itemInPlayer = searchItemInv(itemName);
        if (itemInPlayer != null) {
            if (itemInPlayer instanceof Food food) {
                int addedHp = food.getHealthPoints();
                setHealth(addedHp);
                removeItem(itemName);
                return EatFood.EAT_FOOD;
            } else {
                return EatFood.NOT_FOOD;
            }
        } else {
            return EatFood.NOT_FOUND;
        }
    }

    public EquipItem equipItem(String itemName) {
        Item itemInPlayer = searchItemInv(itemName);
        if (itemInPlayer != null) {
            if (itemInPlayer instanceof Weapon weapon) {
                removeItem(itemName);
                currentWeapon.add(weapon);
                return EquipItem.EQUIPPING_WEAPON;
            } else {
                return EquipItem.NOT_WEAPON;
            }
        } else {
            return EquipItem.NOT_FOUND;
        }
    }

    public Attack attack(String itemName) {
        Item itemInPlayer = searchItemInv(itemName);
        Item weapon = getEquippedItem(itemName);
        if (currentWeapon != null) {
            if (weapon instanceof MeleeWeapon meleeWeapon) {
                (meleeWeapon).getDamage();
                return Attack.ATTACK_MELEE;

            } else if (weapon instanceof RangedWeapon rangedWeapon) {
                (rangedWeapon).getDamage();
                (rangedWeapon).getAmmunition();

                //Ammo
                for (Weapon weapons : getCurrentWeapon())


                    return Attack.ATTACK_RANGE;
            }
        } else if (itemInPlayer != null) {
            return Attack.NOT_EQUIPPED;
        }
        return null;
    }
}
