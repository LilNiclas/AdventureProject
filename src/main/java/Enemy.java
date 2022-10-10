public class Enemy {

    private String name;
    private String description;
    private int health;
    private int damage;
    private Weapon weapon;

    public Enemy(String name, String description, int health, int damage, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}


