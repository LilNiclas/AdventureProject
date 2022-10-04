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
                case "go" -> {
                    if (adventure.go(commandParameter)) {
                        System.out.println("your direction");
                        System.out.println(room.getName());
                        System.out.println(room.getDescription());
                    } else {
                        System.out.println("Can't go that way");
                    }
                }

                case "exit" -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }

                case "help" -> {
                    System.out.println("Hjælpe informationer"); //todo indsæt hjælpe info til brugen
                }

                case "look", "look around" -> {
                    System.out.println("In front of me i see");
                    System.out.println(room.getName());
                    System.out.println(room.getDescription());
                    System.out.println(room.getItemListRoom());
                }


                case "take" -> {
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

                case "drop" -> {
                    Item droppedItem = adventure.dropItem(commandParameter);
                    if (droppedItem == null) {
                        System.out.println("There is nothing called that..");
                    } else {
                        System.out.println("you have dropped up " + droppedItem);
                        adventure.getPlayer().getCurrentRoom().addItem(droppedItem);
                    }
                }

                case "inv", "inve", "inven", "inventory" -> {
                    System.out.println("Your inventory cointains " +  adventure.getPlayer().getItemListPlayer() + " . ");
                }

                case "health", "hp" -> {
                    System.out.println("HP " + player.getHealth() + "");
                }

                case "eat" -> {
                    Item itemInRoom = adventure.getPlayer().getCurrentRoom().getItem(commandParameter);
                    Item itemInPlayer = adventure.getPlayer().getItem(commandParameter);

                    if (itemInRoom != null) {
                        // hvis objekt er typen food så slet
                        if ( itemInRoom instanceof Food) {
                            adventure.getPlayer().getCurrentRoom().removeItem(commandParameter);
                            System.out.println("You have eating " + itemInRoom);
                            //Todo add hp from fod to player
                            System.out.println("You now have " + ((Food) itemInRoom).getHealthPoints() + " More Hp");
                            int addedHp = ((Food) itemInRoom).getHealthPoints();
                            //give hp til player metode
                            adventure.getPlayer().setHealth(addedHp);
                        } else {
                            System.out.println(itemInRoom.getItemName() + " not eatable");
                        }

                    } else if (itemInPlayer != null) {
                        if (itemInPlayer instanceof Food) {
                            adventure.getPlayer().removeItem(commandParameter);
                            System.out.println("You have eating " + itemInPlayer );
                            System.out.println("You now have " + ((Food) itemInPlayer).getHealthPoints() + " More Hp");
                            int addedHp = ((Food) itemInPlayer).getHealthPoints();
                            adventure.getPlayer().setHealth(addedHp);
                            } else {
                            System.out.println(itemInPlayer.getItemName() + " not eatable");
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
