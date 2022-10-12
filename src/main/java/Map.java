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
    private Item lamp = new Item("lamp", ". Rusty oil lamp");
    private Item chest = new Item("chest", "A big chest that contains you grandfathers lost treasure");

    //MeeleWeapons
    private MeleeWeapon bat = new MeleeWeapon("bat", 15);

    //RangedWeapons
    private RangedWeapon gun = new RangedWeapon("gun", 20, 2);

    //Enemy Weapons
    private MeleeWeapon sword = new MeleeWeapon("sword", 40);

    //food item
    private Food cheese = new Food(25, "cheese", ". A big block of cheese");
    private Food water = new Food(-15, "dirty water", ". A bucket of dirty water");
    private Food beans = new Food(20, "beans", "A can of baked beans");
    private Food coconut = new Food(50,"coconut", "A huge overgrown coconut");
    private Food frozenWater = new Food(10, "frozenwater", "A bottle of water that is frozen");
    private Food berries = new Food(25, "berries", "A bush with a lot of bribe berries, ready to be eaten ");
    private Food flesh = new Food(-25, "flesh", "Rotten flesh from a death body");
    private Food meat = new Food(40, "meat", "dried meat that contains a lot of protein");
    private Food basket = new Food(30, "basket", "A basket full of fresh fruits" );


    //Enemy "name", health, dmg
    private Enemy pirate = new Enemy("pirate", 60, sword);

    public void setRooms() {
        //Rooms attributes
        //1
        pirate.setRoom(wilderedHills);
        wilderedHills.setEast(desertIsland);
        wilderedHills.setSouth(overgrownIsland);

        wilderedHills.addItem(bat);
        wilderedHills.addItem(cheese);
        wilderedHills.addItem(lamp);

        //2
        desertIsland.setEast(ships);
        desertIsland.setWest(wilderedHills);

        desertIsland.addItem(flesh);

        //3
        ships.setEast(desertIsland);
        ships.setSouth(rockyHill);

        ships.addItem(water);
        ships.addItem(beans);

        //4
        overgrownIsland.setNorth(wilderedHills);
        overgrownIsland.setSouth(iceIsland);

        overgrownIsland.addItem(coconut);

        //5
        bossfightVulkano.setSouth(amazonianIsland);

        //6
        rockyHill.setNorth(ships);
        rockyHill.setSouth(pirateIsland);

        rockyHill.addItem(berries);

        //7
        iceIsland.setNorth(overgrownIsland);
        iceIsland.setEast(amazonianIsland);

        iceIsland.addItem(frozenWater);
        //8
        amazonianIsland.setNorth(bossfightVulkano);
        amazonianIsland.setEast(pirateIsland);
        amazonianIsland.setWest(iceIsland);

        amazonianIsland.addItem(basket);
        //9
        pirateIsland.setNorth(rockyHill);
        pirateIsland.setWest(amazonianIsland);

        pirateIsland.addItem(meat);
    }

    public Room getStartRoom() {
        return wilderedHills;
    }

}
