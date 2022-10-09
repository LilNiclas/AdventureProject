import ENUM.EatFood;
import ENUM.EquipItem;

import java.util.Scanner;

public class UserInterface {
    private Adventure adventure = new Adventure();
    Scanner scan = new Scanner(System.in);

    public void userInput() {
        boolean isRunning = true;
        System.out.println("Welcome to Adventure");

        while (isRunning) {
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
                    if (adventure.go(commandParameter)) {
                        System.out.println("your direction");
                        System.out.println(room.getName());
                        System.out.println(room.getDescription());
                    } else {
                        System.out.println("Can't go that way");
                    }
                }

                case "exit", "Exit", "Shut down", "Close game" -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }

                case "help", "Help", "Instruction", "Instructions", "instruction", "instructions" -> {
                    System.out.println("Instruction manual");
                    System.out.println("'Look' Player will give a description of the area surrounding the player");
                    System.out.println("'Go + direction(north, east, south, west)' Player will move the player in the given direction");
                    System.out.println("'Inv' or 'Inventory' Player will show the players inventory");
                    System.out.println("'Health' Player will show the players health");
                    System.out.println("'Take + item' Player will pick up items. The item will be located in the players inventory");
                    System.out.println("'Drop + item' Player will drop the item. The item will be located in the room");
                    System.out.println("'Eat + item' Player will eat the item if possible");
                    System.out.println("'Equip + item' Player will equip a weapon");
                    System.out.println("'Exit' The game will shut down");
                }

                case "look", "look around", "Look", "Room", "room" -> {
                    System.out.println("Oh a new island");
                    System.out.println(room.getName());
                    System.out.println(room.getDescription());
                    System.out.println(room.getItemListRoom());
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
                    } else if (eatFood == EatFood.NOT_FOOD){
                        System.out.println(itemInPlayer.getItemName() + ". Isn't edible");
                    } else if (eatFood == EatFood.NOT_FOUND) {
                        System.out.println("Item not found");
                    }
                }





                case "equip", "Equip", "wield", "Wield" -> {
                    EquipItem equipItem = adventure.equipItem(commandParameter);
                    Item itemInPlayer = adventure.searchItemInv(commandParameter);


                    if (equipItem == EquipItem.EQUIPPING_WEAPON) {
                        System.out.println(" equipped");
                    } else if (equipItem == EquipItem.NOT_WEAPON) {
                        System.out.println(itemInPlayer + " can not be equipped");
                    } else if (equipItem == EquipItem.NOT_FOUND) {
                        System.out.println("No item was found");
                    }
                }




                    /*Item itemInPlayer = adventure.searchItemInv(commandParameter);

                    if (itemInPlayer != null) {
                        if (!(itemInPlayer instanceof Weapon)) {
                            System.out.println("That is not a weapon, try a different item");
                        } else if (itemInPlayer instanceof Weapon) {
                            System.out.println("you have equipped: " + itemInPlayer);
                            //remove fra player inventory
                            adventure.removeItemInventory(commandParameter);

                            //add til equiped arraylist
                            adventure.addEquippedWeapon(commandParameter); //udskriver null
                            System.out.println("You have added" + adventure.getPlayer().getEquippedItem(commandParameter));
                            //adventure.getCurrentWeapon()




                        }
                        //todo plus metode til ad deEquip sidste våben
                        //fjern fra equipweapon og add til inventory igen

                    } else {
                        System.out.println("This is not a weapon");
                    }*/




            default -> {
                System.out.println("Invalid input");
            }
        }
    }
}
}
