public class Adventure {

    private Room currentRoom = new Room("House", "You are in the first room");
    //1
    private Room woodsIsland = new Room("Wildered Island", "woods");
    //2
    private Room desertIsland = new Room("Deserted Island", "desert, warmth");
    //3
    private Room ships = new Room("ships", "place full of ships");
    //4
    private Room iceIsland = new Room("Icy island", "Ice and snow");
    //5
    private Room bossfightVulkano = new Room("Vulcano isle", "vulcano and  boss fight");
    //6
    private Room largeCity = new Room("Largecity", "You are in a large city");
    //7
    private Room extraLarge = new Room("Overgrown island", "Massive trees");
    //8
    private Room pirateIsland = new Room("PirateIsland", "island full of pirates, watch out");
    //9
    private Room amazonianIsland = new Room("AmazonianIsland", "Island of women");



    public Room getCurrentRoom() {
        return currentRoom;
    }

}
