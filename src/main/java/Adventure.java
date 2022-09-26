public class Adventure {


    private Room currentRoom = null;
    //1
    private Room wilderedHills = new Room("Wildered hills", "You are standing in the middle of a blooming field," +
            " with a strong wind in the back guiding you outwards towards the massive sea", null, getCurrentRoom().getEast(), getCurrentRoom().getSouth(), null);
    //2
    private Room desertIsland = new Room("Deserted Island", "You've arrived at an unknown island and before you lays a sea of sand. " +
            "The wind gushes sand in your face, and you barely glimpse a port at the other side of the island. But in this hot and intense climate you wont last a day without water", null, getCurrentRoom().getEast(), null, getCurrentRoom().getWest());
    //3
    private Room ships = new Room("Pirates", "You set sails to Piratos Vile, 30 minutes into the trip you're approached " +
            "by a pirate ship. They seem full of gluttony and rage, they won't let you continue, its a fight og flight situation!", null, null, getCurrentRoom().getSouth(), getCurrentRoom().getWest());
    //4
    private Room overgrownIsland = new Room("Overgrown island", "One massive tree sticks up from the island before you, the tree reaches the sky." +
            " As you explora the island you spot a dangling rope ladder, its seems to be hanging from the upper branches of the tree", getCurrentRoom().getNorth(), null, getCurrentRoom().getSouth(), null);
    //5
    private Room bossfightVulkano = new Room("Vulcano isle", "vulcano and  boss fight", null, null, getCurrentRoom().getSouth(), null);

    //6
    private Room rockyHill = new Room("Rocky hill", "You've arrived at a small little island, the island seems to be one big hollow rock," +
            " the ground is filled up wtih hay and you see a man sleeping on the ground", getCurrentRoom().getNorth(), null, getCurrentRoom().getSouth(), null);
    //7
    private Room iceIsland = new Room("Icy island", "You have set the anchor before reaching the island because of the thick layer of ice surrounding it. " +
            "You tread through the knee-high snow and spot a cabin on top of a hill, its been long forgotten but the wood kept strong in the cold weather, you look around and find a bunch of goods", getCurrentRoom().getNorth(), getCurrentRoom().getEast(), null, null);
    //8
    private Room amazonianIsland = new Room("AmazonianIsland", "jungle island / last island before boss", getCurrentRoom().getNorth(), getCurrentRoom().getEast(), null, getCurrentRoom().getWest());

    //9
    private Room pirateIsland = new Room("PirateIsland", "Ahh finally arrived, and in one piece. The atmosphere is dull and depressing at the harbour, " +
            "you go to the local bar to get some information on the legendary island mentioned in fathers last will", getCurrentRoom().getNorth(), null, null, getCurrentRoom().getWest());




    public Room getCurrentRoom() {
        return currentRoom;
    }

}
