import java.util.Scanner;
// Userinterface Class is the Class that takes the input from the user

public class UserInterface {
    Scanner scan = new Scanner(System.in);

    private Adventure adventure = new Adventure();


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
/*

                //go east
                case "go" -> {
                    if (adventure.goEast()) {
                        System.out.println("Going east");
                        System.out.println(adventure.getCurrentRoom().getName());
                        System.out.println(adventure.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("Can't go that way");
                    }
                }

                // go south
                case "go south", "south", "s" -> {
                    if (adventure.goSouth()) {
                        System.out.println("Going south");
                        System.out.println(adventure.getCurrentRoom().getName());
                        System.out.println(adventure.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("Can't go that way");
                    }
                }

                //go west
                case "go west", "west", "w" -> {
                    if (adventure.goWest()) {
                        System.out.println("Going west");
                        System.out.println(adventure.getCurrentRoom().getName());
                        System.out.println(adventure.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("Can't go that way");
                    }
                }
*/

                case "exit" -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }

                case "help" -> {
                    System.out.println("Hjælpe informationer"); //todo indsæt hjælpe info til brugen
                }

                case "look", "look around" -> {
                    System.out.println("In front of me i see"); //todo give beskrivelse af room
                    System.out.println(adventure.getPlayer().getCurrentRoom().getName());
                    System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());
                }
                default -> {
                    System.out.println("Invalid input");
                }

            }
        }

    }

}
