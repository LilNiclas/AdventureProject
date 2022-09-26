public class Adventure {

    private Room currentRoom = new Room("House", "You are in the first room");
    //1
    private Room woodsIsland = new Room("Wildered hills", "You are standing in the middle of a blooming field," +
            " with a strong wind in the back guiding you outwards towards the massive sea");
    //2
    private Room desertIsland = new Room("Deserted Island", "You've arrived at an unknown island and before you lays a sea of sand. " +
            "The wind gushes sand in your face, and you barely glimpse a port at the other side of the island. But in this hot and intense climate you wont last a day without water");
    //3
    private Room ships = new Room("Pirates", "You set sails to Piratos Vile, 30 minutes into the trip you're approached " +
            "by a pirate ship. They seem full of gluttony and rage, they won't let you continue, its a fight og flight situation!");
    //4
    private Room iceIsland = new Room("Icy island", "You have set the anchor before reaching the island because of the thick layer of ice surrounding it. " +
            "You tread through the knee-high snow and spot a cabin on top of a hill, its been long forgotten but the wood kept strong in the cold weather, you look around and find a bunch of goods");
    //5
    private Room bossfightVulkano = new Room("Vulcano isle", "vulcano and  boss fight");
    //6
    private Room rockyHill = new Room("Rocky hill", "You've arrived at a small little island, the island seems to be one big hollow rock," +
            " the ground is filled up wtih hay and you see a man sleeping on the ground");
    //7
    private Room overgrownIsland = new Room("Overgrown island", "One massive tree sticks up from the island before you, the tree reaches the sky." +
            " As you explora the island you spot a dangling rope ladder, its seems to be hanging from the upper branches of the tree");
    //8
    private Room pirateIsland = new Room("PirateIsland", "Ahh finally arrived, and in one piece. The atmosphere is dull and depressing at the harbour, " +
            "you go to the local bar to get some information on the legendary island mentioned in fathers last will");
    //9
    private Room amazonianIsland = new Room("AmazonianIsland", "Island of women");



    public Room getCurrentRoom() {
        return currentRoom;
    }

}
