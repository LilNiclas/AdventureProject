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

                //Todo health
                //viser spillerens aktuelle health-status – både som tal og forklarende tekst,
                // for eksempel: health: 50 – you are in good health, but avoid fighting right now.

                case "health", "hp" -> {
                    System.out.println("HP " + player.getHealth() + "/100 hp");
                }


                //Todo eat
                //efterfulgt af navnet på en mad,
                //tager den nævnte mad enten fra rummet eller fra spillerens inventory og spiser den.
                // Maden holder op med at eksistere, og spilleren får en mængde health fra den.

                /*
                eat
                Hvis man skriver eat efterfulgt af en ting som hverken er i rummet eller i inventory,
                svarer det til at take eller drop et item der ikke findes –


                hvis man skriver eat efterfulgt af en ting der ikke er spiseligt,
                skal programmet udskrive at man ikke kan spise den pågældende ting

                hvis tingen findes, og er spiselig, bliver den spist.

                 */

                /*
                kode
                todo: lave ny sub klasse der arver fra items der hedder foods
                todo: opret foods i maps og put dem i rum (ligesom andre items)

                food class
                todo: healhpoints som er det player optager, når den spiser et food-objekt
                todo: Lav for eksempel en overloaded constructor der udover name
                 og description også tager health
                 – så healthPoints bliver fastlagt når Map opretter de Food-objekter der skal være i spillet.


                 */

                default -> {
                    System.out.println("Invalid input");
                }

            }
        }

    }

}
