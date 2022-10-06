import java.util.Scanner;
// Userinterface Class is the Class that takes the input from the user

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

                case "exit", "Exit", "Shut down" -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }

                case "help", "Help", "Instruction", "Instructions", "instruction", "instructions" -> {
                    System.out.println("Instruction manual");
                    System.out.println("'Look' Player will give a description of the area surrounding the player");
                    System.out.println("'Go + direction(north, east, south, west)' Player will move the player in the given direction");
                    System.out.println("'Inv' or 'Inventory' Player will show the players inventory");
                    System.out.println("'Take + item' Player will pick up items. The item will be located in the players inventory");
                    System.out.println("'Drop + item' Player will drop the item. The item will be located in the room");
                    System.out.println("'Health' Player will show the players health");
                    System.out.println("'Eat + item' Player will eat the item if possible");
                    System.out.println("'Exit' The game will shut down");
                }

                case "look", "look around", "Look" -> {
                    System.out.println("Oh a new island");
                    System.out.println(room.getName());
                    System.out.println(room.getDescription());
                    System.out.println(room.getItemListRoom());
                }


                case "take", "Take" -> {
                    // First the item is removed from the arraylist connected to the room
                    // Then the removed item is added to the arraylist connected to the player (inventory)
                    Item pickedUpItem = adventure.takeItem(commandParameter);
                    if (pickedUpItem == null) {
                        System.out.println("There is nothing called that..");
                    } else {
                        System.out.println("you have picked up " + pickedUpItem);

                        //test for if it did add it to the inventory
                        //System.out.println("You now have " + adventure.getPlayer().getItemList() + "in your inventory");
                    }
                }

                case "drop", "Drop" -> {
                    Item droppedItem = adventure.dropItem(commandParameter);
                    if (droppedItem == null) {
                        System.out.println("There is nothing called that..");
                    } else {
                        System.out.println("You have dropped " + droppedItem);
                        room.addItem(droppedItem);
                    }
                }

                case "inv", "Inv", "Inventory", "inventory" -> {
                    System.out.println("Your inventory contains " + adventure.getItemListPlayer() + " . ");
                }





                /*
                hvis equip (input item) ikke er et våben man har
                print that is not a weapon you have

                else if (input item) er noget andet end et våben
                print that is not a weapon

                hvis euqip (input item) er et våben man har i sin inventory så bliver det euqiped

                */


                //todo attack

                /*
                hvis man har et meeleweapon
                kan man bare angribe

                hvis man har et rangedweapon

                hvis man prøver at attack med et tomt våben
                print you dont have any ammo

                hvis man prøver at attack og har ammo
                print you have attaced

                hvis du ikke har et våben equpied
                print you dont have a våben equpied

                 */


                case "health", "Health", "HP", "hp", "Hp" -> {
                    System.out.println("HP " + player.getHealth() + "");
                }


                case "eat", "Eat" -> {
                    Item itemInRoom = room.getItem(commandParameter);
                    Item itemInPlayer = adventure.getItem(commandParameter);

                    if (itemInRoom != null) {
                        if (itemInRoom instanceof Food) {
                            room.removeItem(commandParameter);
                            System.out.println("You're eating " + itemInRoom);
                            System.out.println("+" + ((Food) itemInRoom).getHealthPoints() + " HP");
                            int addedHp = ((Food) itemInRoom).getHealthPoints();
                            adventure.setHealth(addedHp);
                        } else {
                            System.out.println(itemInRoom.getItemName() + " not eatable");
                        }

                    } else if (itemInPlayer != null) {
                        if (itemInPlayer instanceof Food) {
                            adventure.removeItem(commandParameter);
                            System.out.println("You're eating " + itemInPlayer);
                            System.out.println("You now have " + ((Food) itemInPlayer).getHealthPoints() + " more Hp");
                            int addedHp = ((Food) itemInPlayer).getHealthPoints();
                            adventure.setHealth(addedHp);
                        } else {
                            System.out.println(itemInPlayer.getItemName() + " is not eatable");
                        }

                    } else {
                        System.out.println("There is nothing called that..");
                    }


                }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
