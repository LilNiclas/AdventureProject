//import javax.xml.namespace.QName;

public class Map {
// Map Class builds the map and gives the starting room to the Adventure class


    public Map() {
        setRooms();
    }

    //Rooms created
    //1
    private Room wilderedHills = new Room("Wildered hills", "You are standing in the middle of a blooming field," +
            " with a strong wind in the back, guiding you towards the massive barren sea");
    //2
    private Room desertIsland = new Room("Deserted Island", "You've arrived at an unknown island and before you lays a " +
            "sea of sand. " +
            "The wind gushes sand in your face, and you can barely glimpse a port at the other side of the island. " +
            "But in this hot and intense climate you wont last a day without water");
    //3
    private Room ships = new Room("Pirates", "You set sails to Piratos Vile, 30 minutes into the trip you're approached " +
            "by a pirate ship. They seem full of gluttony and rage, they won't let you continue, its a fight og " +
            "flight situation!");
    //4
    private Room overgrownIsland = new Room("Overgrown island", "One massive tree sticks up from the island before you, " +
            "the tree reaches the sky." +
            " As you explora the island you spot a dangling rope ladder, its seems to be hanging from the upper " +
            "branches of the tree");
    //5
    private Room bossfightVulkano = new Room("Vulcano isle", "vulcano and  boss fight");

    //6
    private Room rockyHill = new Room("Rocky hill", "You've arrived at a small little island, the island seems to be one" +
            " big hollow rock," +
            " the ground is filled up wtih hay and you see a man sleeping on the ground");
    //7
    private Room iceIsland = new Room("Icy island", "You have set the anchor before reaching the island because of the " +
            "thick layer of ice surrounding it. " +
            "You tread through the knee-high snow and spot a cabin on top of a hill, its been long forgotten " +
            "but the wood kept strong in the cold weather, you look around and find a bunch of goods");
    //8
    private Room amazonianIsland = new Room("AmazonianIsland", "jungle island / last island before boss");

    //9
    private Room pirateIsland = new Room("PirateIsland", "Ahh finally arrived, and in one piece. The atmosphere is dull" +
            " and depressing at the harbour, " +
            "you go to the local bar to get some information on the legendary island mentioned in your fathers last will");


    // Items
    private Item sword = new Item("Sword", "A massive 6 foot sword, perfect for slaying your foes");
    private Item water = new Item("Bucket of water", "A bucket of freshly melted water");
    private Item lamp = new Item("Lamp", "Rusty oil lamp");

    // food item
    private Food cheese = new Food(25, "Cheese", "A big block of cheese");

    public void setRooms() {
        //designate rooms direction
        //1
        wilderedHills.setEast(desertIsland);
        wilderedHills.setSouth(overgrownIsland);
        wilderedHills.addItem(sword);
        wilderedHills.addItem(cheese);
        //2
        desertIsland.setEast(ships);
        desertIsland.setWest(wilderedHills);
        //3
        ships.setEast(desertIsland);
        ships.setSouth(rockyHill);
        //4
        overgrownIsland.setNorth(wilderedHills);
        overgrownIsland.setSouth(iceIsland);
        //5
        bossfightVulkano.setSouth(amazonianIsland);
        //6
        rockyHill.setNorth(ships);
        rockyHill.setSouth(pirateIsland);
        //7
        iceIsland.setNorth(overgrownIsland);
        iceIsland.setEast(amazonianIsland);
        iceIsland.addItem(water);
        iceIsland.addItem(lamp);
        //8
        amazonianIsland.setNorth(bossfightVulkano);
        amazonianIsland.setEast(pirateIsland);
        amazonianIsland.setWest(iceIsland);
        //9
        pirateIsland.setNorth(rockyHill);
        pirateIsland.setWest(amazonianIsland);
    }

    public Room getStartRoom() {
        return wilderedHills;
    }

}
