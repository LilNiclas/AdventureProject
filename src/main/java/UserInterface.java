import java.util.Scanner;

public class UserInterface {
    Scanner scan = new Scanner(System.in);

    private Adventure adventure = new Adventure();

    public void userInput() {

        System.out.println("Welcome to Adventure");

        boolean isRunning = true;


        while (isRunning) {
            String userInput = scan.nextLine();

            switch (userInput) {
                //go north
                case "go north", "north", "n" -> {
                    if (adventure.goNorth()) {
                        System.out.println("Going north");
                        System.out.println(adventure.getCurrentRoom().getName());
                        System.out.println(adventure.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("Can't go that way");
                    }
                }

                //go east
                case "go east", "east", "e" -> {
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

                case "exit" -> {
                    System.out.println("Exiting program...");
                    isRunning = false;
                }

                case "help" -> {
                    System.out.println("Hjælpe informationer"); //todo indsæt hjælpe info til brugen
                }

                case "look", "look around" -> {
                    System.out.println("In front of me i see"); //todo give beskrivelse af room
                    System.out.println(adventure.getCurrentRoom().getName());
                    System.out.println(adventure.getCurrentRoom().getDescription());
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }

}
