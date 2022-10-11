public class Enemy {

    private String name;
    private int health;
    private int damage;
    private Room room;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean death() {
        if (health <= 0) {
            room.removeEnemy(null); //ved ikke helt hvad der skal i parameteret
            return true;
        } else {
            return false;
        }
    }


}


