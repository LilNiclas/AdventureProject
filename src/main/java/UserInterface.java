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
            String direction = "";
            if (userInputList.length > 1) {
                direction = userInputList[1];
            }

            switch (command) {
                //go north
                case "go" -> {
                    if (adventure.go(direction)) {
                        System.out.println("your direction");
                        System.out.println(adventure.getPlayer().getCurrentRoom().getName());
                        System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());
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
                    System.out.println(adventure.getPlayer().getCurrentRoom().getName());
                    System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());
                    System.out.println(adventure.getPlayer().getCurrentRoom().getItemList());
                }


                case "take" -> {
                    //First the item is removed from the arraylist connected to the room
                    // Then the removed item is added to the arraylist connected to the player (inventory)
                    Item pickedUpItem = adventure.getPlayer().getCurrentRoom().removeItem(direction);
                    if (pickedUpItem == null) {
                        System.out.println("There is nothing called that..");
                    } else {
                        System.out.println("you have removed" + pickedUpItem);
                        adventure.getPlayer().addItem(pickedUpItem);
                        System.out.println("You now have " + adventure.getPlayer().getItemList() + "in your inventory");
                    }
                }

                default -> {
                    System.out.println("Invalid input");
                }

            }
        }

    }

}
