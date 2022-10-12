//import javax.xml.namespace.QName;

public class Map {
// Map Class builds the map and gives the starting room to the Adventure class


    public Map() {
        setRooms();
    }

    //Rooms created
    //1
    private Room wilderedHills = new Room("Wildered hills", "You are standing in the middle of a blooming field, \n" +
            "with a strong wind in the back, guiding you towards the treasure of your grandfather.");
    //2
    private Room desertIsland = new Room("Deserted Island", "You've arrived at the neighbouring desert island and before you lays a \n" +
            "sea of sand. The wind gushes sand in your face, you spot a weak soldier along the coast.");
    //3
    private Room ships = new Room("Pirates", "You set sail onwards, 30 minutes into the trip you're approached \n" +
            "by a pirate ship. They seem full of gluttony and rage, its a fight og " +
            "flight situation!");
    //4
    private Room overgrownIsland = new Room("Overgrown island", "One massive tree sticks up from the island before you, " +
            "the tree reaches the sky. \n"+
            "As you explore the island you spot a strong 2 meter tall knight, you can move on but he might have some good loot");

    //5
    private Room bossfightVulkano = new Room("Vulcano Island", "VULCANO ISLAND. You've finally arrived, the island is dark and gloomy" +
            "all covered in smoke from the vulcano. \n" +
            "Out of the smoke steps a giant 3 meter tall troll with fire in his eyes its fight or flight!!");

    //6
    private Room rockyHill = new Room("Rocky hill", "You've arrived at a small little island, the island seems to be one \n" +
            "massive rock. A long the edge of the rock you spot a small hurdle of 2 goats");
    //7
    private Room iceIsland = new Room("Icy island", "You have thrown the anchor before reaching the island, because of the " +
            "thick layer of ice surrounding it. \n" +
            "There seems to be nothing special on the island, just a cold calm island \n" +
            "In the far distance you glimpse what seems to be smoke from the a massive vulcano");
    //8
    private Room amazonianIsland = new Room("The Amazonian Forest", "You've arrived at what seems to be a jungle island, " +
            "the trees are big and the forrest dense. \n" + "As you're exploring you stumble upon a local with a spear, fight or walk on? \n" +
            "The sky has gone grey, Vulcano Island is nearby, it seems to be coming from north");

    //9
    private Room pirateIsland = new Room("PirateIsland", "You've come to a pirate port, weirdly enough it seems to be quiet og chill. \n" +
            "Time to regain energy before heading on towards Vulcano Island" +
            "In the far distance you can spot what might be the top of a mountain...");


    // Items
    private Item lamp = new Item("lamp", ". Rusty oil lamp");
    private Item chest = new Item("chest", "A big chest that contains you grandfathers lost treasure");

    //MeeleWeapons
    private MeleeWeapon bat = new MeleeWeapon("bat", 15);

    //RangedWeapons
    private RangedWeapon handcannon = new RangedWeapon("handcannon", 50, 3);
    private RangedWeapon snowballs = new RangedWeapon("snowballs", 5, 10);
    private RangedWeapon bow = new RangedWeapon("bow", 40, 5);


    //Enemy Weapons
    private MeleeWeapon sword = new MeleeWeapon("sword", 40);
    private MeleeWeapon knife = new MeleeWeapon("knife", 25);
    private MeleeWeapon sabel = new MeleeWeapon("sabre", 35);
    private MeleeWeapon horns = new MeleeWeapon("horns", 20);
    private MeleeWeapon spear = new MeleeWeapon("spear", 40);
    private MeleeWeapon rock = new MeleeWeapon("rock", 20);

    //food item
    private Food cheese = new Food(25, "cheese", ". A big block of cheese");
    private Food water = new Food(-15, "dirty water", ". A bucket of dirty water");
    private Food beans = new Food(20, "beans", "A can of baked beans");
    private Food coconut = new Food(50,"coconut", "A huge overgrown coconut");
    private Food frozenwater = new Food(10, "frozenwater", "A bottle of water that is frozen");
    private Food berries = new Food(25, "berries", "A bush with a lot of bribe berries, ready to be eaten ");
    private Food flesh = new Food(-25, "flesh", "Rotten flesh from a death body");
    private Food meat = new Food(40, "meat", "meat that contains a lot of protein");
    private Food basket = new Food(30, "basket", "A basket full of fresh fruits" );


    //Enemy "name", health, dmg
    private Enemy pirate = new Enemy("pirate", 60, sabel);
    private Enemy soldier = new Enemy("soldier", 30, knife);
    private Enemy knight = new Enemy("knight", 125, sword);
    private Enemy goat = new Enemy("goat", 30, horns, meat);
    private Enemy warrior = new Enemy("worrier", 80, spear);
    private Enemy smallmonster = new Enemy("small Monster", 40, rock);
    private Enemy bigmonster = new Enemy("bigmonster", 90, rock);
    private Enemy heavyknight = new Enemy("heavyknight", 175, sword);



    public void setRooms() {
        //Rooms attributes
        //1
        pirate.setRoom(wilderedHills);
        wilderedHills.setEast(desertIsland);
        wilderedHills.setSouth(overgrownIsland);

        wilderedHills.addItem(bat);
        wilderedHills.addItem(cheese);

        //2
        desertIsland.setEast(ships);
        desertIsland.setWest(wilderedHills);

        desertIsland.addItem(flesh);
        desertIsland.addEnemy(soldier);
        //3
        ships.setEast(desertIsland);
        ships.setSouth(rockyHill);

        ships.addItem(water);
        ships.addItem(beans);
        ships.addItem(handcannon);

        //4
        overgrownIsland.setNorth(wilderedHills);
        overgrownIsland.setSouth(iceIsland);

        overgrownIsland.addItem(coconut);
        overgrownIsland.addEnemy(knight);

        //5
        bossfightVulkano.setSouth(amazonianIsland);

        bossfightVulkano.addEnemy(smallmonster);
        bossfightVulkano.addEnemy(bigmonster);
        bossfightVulkano.addEnemy(heavyknight);

        bossfightVulkano.addItem(chest);
        //6
        rockyHill.setNorth(ships);
        rockyHill.setSouth(pirateIsland);

        rockyHill.addItem(berries);
        rockyHill.addEnemy(goat);

        //7
        iceIsland.setNorth(overgrownIsland);
        iceIsland.setEast(amazonianIsland);

        iceIsland.addItem(frozenwater);
        iceIsland.addItem(snowballs);
        //8
        amazonianIsland.setNorth(bossfightVulkano);
        amazonianIsland.setEast(pirateIsland);
        amazonianIsland.setWest(iceIsland);

        amazonianIsland.addItem(basket);
        amazonianIsland.addEnemy(warrior);
        //9
        pirateIsland.setNorth(rockyHill);
        pirateIsland.setWest(amazonianIsland);

        pirateIsland.addItem(meat);
        pirateIsland.addItem(berries);

    }

    public Room getStartRoom() {
        return wilderedHills;
    }

}
