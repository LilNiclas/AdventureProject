import ENUM.Attack;
import ENUM.EatFood;
import ENUM.EquipItem;

import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();
    Scanner scan = new Scanner(System.in);

    public void userInput() {
        boolean isRunning = true;
        System.out.println("Welcome to Grandpa's Lost Treasure \n");
        System.out.println("You have received a letter from the government about your grandfather's death. Your grandfather left a personal Letter for you. \n" +
                "\n" +
                "My dearest\n" +
                "I'm at my last breath, and will not make it home. \n" +
                "There’s something I've been hiding from you all this time, \n" +
                "i have a treasure hidden away on Vulcano Island with all the riches in the world.\n" +
                "It’s not gonna be easy, there will be danger in your way, \n" +
                "so get yourself ready before you head to Vulcano island.\n" +
                "-Grandpa\n" +
                "\n" +
                "A journey lies ahead of you, you will have to leave the comforts of home and explore. \n" +
                "Type 'Look' to see your surroundings. \n" +
                "Type 'Help' to get help/instructions on what to do.");

        while (isRunning && adventure.getPlayer().playerDeath()) {

            String userInput = scan.nextLine();
            String[] userInputList = userInput.split(" ");
            String command = userInputList[0];
            String commandParameter = "";
            if (userInputList.length > 1) {
                commandParameter = userInputList[1];
            }

            Room room = adventure.getCurrentRoom();
            Player player = adventure.getPlayer();

            switch (command) {
                case "go", "Go", "move", "Move" -> {
                    // Fixed fejl med den skrev det info fra det room man gik fra når man gik i nyt room men hvis man skrev
                    // look så var man faktisk i det nye room
                    // fejlen var at vi har kortet koden ned med room. hvilket er gemt før switch casen og
                    // adventure.getCurrentRoom (før switch casen) er altid de sidste room man var i før man man kalder
                    // go funktionen
                    if (adventure.go(commandParameter)) {
                        System.out.println(adventure.getCurrentRoom().getName());
                        System.out.println(adventure.getCurrentRoom().getDescription());

                        System.out.println(adventure.getCurrentRoom().getItemListRoom());
                        System.out.println(adventure.getCurrentRoom().getEnemies());

                    } else {
                        System.out.println("Can't go that way");
                    }
                }

                case "exit", "Exit", "Shut down", "Close game" -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }

                case "help", "Help", "Instruction", "Instructions", "instruction", "instructions" -> {
                    System.out.println("Instruction manual \n" +
                            "'Look' Player will give a description of the area surrounding the player \n" +
                            "'Go + direction'(north, east, south, west) Player will move the in the given direction \n" +
                            "'Inv' or 'Inventory' Player will show the players inventory \n" +
                            "'Health' Player will show the players health \n" +
                            "'Take + item' Player will pick up items. The item will be located in the players inventory \n" +
                            "'Drop + item' Player will drop the item. The item will be located in the room \n" +
                            "'Eat + item' Player will eat the item if possible \n" +
                            "'Equip + item' Player will equip weapon \n" +
                            "'Unequip + item' Player will equip weapon \n" +
                            "'Attack + enemy' Player will attack an enemy \n" +
                            "'Exit' The game will shut down");
                }

                case "look", "look around", "Look", "Room", "room", "See", "see" -> {
                    System.out.println(room.getName());
                    System.out.println(room.getDescription());
                    System.out.println("\n");
                    System.out.println(room.getItemListRoom());
                    System.out.println(room.getEnemies());

                }

                case "take", "Take", "pick up", "Pick up" -> {
                    Item pickedUpItem = room.getItem(commandParameter);
                    if (pickedUpItem == null) {
                        System.out.println("There is nothing called that..");
                    } else {
                        System.out.println("you have picked up " + pickedUpItem);
                        adventure.takeItem(commandParameter);
                    }
                }

                case "drop", "Drop" -> {
                    Item droppedItem = adventure.dropItem(commandParameter);
                    if (droppedItem == null) {
                        System.out.println("There is nothing called that..");
                    } else {
                        System.out.println("You have dropped " + droppedItem);
                    }
                }

                case "inv", "Inv", "Inventory", "inventory" -> {
                    System.out.println("Inventory: " + adventure.getItemListPlayer());
                    System.out.println("Equipped: " + adventure.getCurrentWeapon());
                }

                case "health", "Health", "HP", "hp", "Hp" -> {
                    System.out.println(player.getHealth() + " HP");
                }

                case "eat", "Eat", "consume", "Consume" -> {
                    Item itemInPlayer = adventure.searchItemInv(commandParameter);
                    EatFood eatFood = adventure.eatFood(commandParameter);

                    if (eatFood == EatFood.EAT_FOOD) {
                        System.out.println("Consuming: " + itemInPlayer);
                        System.out.println("+" + ((Food) itemInPlayer).getHealthPoints() + " HP");
                    } else if (eatFood == EatFood.NOT_FOOD) {
                        System.out.println(itemInPlayer.getItemName() + ". Isn't edible");
                    } else if (eatFood == EatFood.NOT_FOUND) {
                        System.out.println("No item was found");
                    }
                }

                case "equip", "Equip", "wield", "Wield" -> {
                    EquipItem equipItem = adventure.equipItem(commandParameter);
                    Item itemInPlayer = adventure.searchItemInv(commandParameter);
                    Item searchEquippedItem = adventure.getCurrentWeapon();

                    if (equipItem == EquipItem.EQUIPPING_WEAPON) {
                        System.out.println(searchEquippedItem + " equipped");
                    } else if (equipItem == EquipItem.NOT_WEAPON) {
                        System.out.println(itemInPlayer + " can not be equipped");
                    } else if (equipItem == EquipItem.NOT_FOUND) {
                        System.out.println("No item was found");
                    }
                }

                case "unequip", "Unequip" -> {
                    EquipItem unEquipItem = adventure.unEquipItem(commandParameter);
                    Item itemInPlayer = adventure.searchItemInv(commandParameter);

                    if (unEquipItem == EquipItem.UNEQUIP) {
                        System.out.println(itemInPlayer + " unequipped");
                    } else if (unEquipItem == EquipItem.NOT_FOUND) {
                        System.out.println(itemInPlayer + "unequipped");
                    }
                }

                case "Attack", "attack", "Shoot", "shoot", "swing", "Swing" -> {
                    Attack attack = adventure.attack(commandParameter);
                    Item searchEquippedItem = adventure.getCurrentWeapon();
                    Item itemInPlayer = adventure.searchItemInv(commandParameter);

                    if (attack == Attack.ATTACK_ENEMY) {
                        System.out.println("Enemy attack. " + ((Weapon) searchEquippedItem).getDamage() + " damage dealt");
                        System.out.println(((Weapon) searchEquippedItem).getAmmunition() + " shots left");
                        System.out.println(commandParameter + " health: " + adventure.getEnemyHealth(commandParameter));
                        System.out.println("Player health: " + adventure.getPlayerHealth());
                    } else if (attack == Attack.KILLED_ENEMY) {
                        System.out.println(commandParameter + " is dead");
                    } else if (attack == Attack.NO_AMMO) {
                        System.out.println("No ammunition left");
                    } else if (attack == Attack.NOT_EQUIPPED) {
                        System.out.println("You dont have " + itemInPlayer + " equipped");
                    } else {
                        System.out.println("Invalid input (nothing matched your search)");
                    }
                }

                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
        if (!adventure.getPlayer().playerDeath()) {
            System.out.println("GAME OVER - YOU DIED");
        }
    }
}
