public class Adventure {

    public Map map = new Map();
    public Player player = new Player();

    public Player getPlayer() {
        return player;
    }

    //todo +go(direction: string)
    public boolean go(String direction) {
        return player.move(direction);
    }

    
    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
    }

}
