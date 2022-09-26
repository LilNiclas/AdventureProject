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
                case "go north":
                    System.out.println("Going north");
                    break;
                case "go east":
                    System.out.println("Going east");
                    break;
                case "go south":
                    System.out.println("Going south");
                    break;
                case "go west":
                    System.out.println("Going west");
                    break;
                case "exit":
                    System.out.println("Exiting program...");
                    isRunning = false;
                    break;
                case "help":
                    System.out.println("Hjælpe informationer"); //todo indsæt hjælpe info til brugen
                    break;
                case "look":
                    System.out.println("Looking around"); //todo give beskrivelse af room
                    System.out.println("I'm Looking around and I see");

                    System.out.println(adventure.getCurrentRoom().getName());

                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }

}
