public class Adventure {
// The Adventure class is the controler for the whole game
// But does not control the player

    public Map map = new Map();
    public Player player = new Player();


    public Player getPlayer() {
        return player;
    }

    public boolean go(String direction) {
        return player.move(direction);
    }

    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }


}
