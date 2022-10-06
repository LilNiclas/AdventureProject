public abstract class Weapon extends Item {

    protected int damage;
    protected double range;


    public Weapon(String name, String description, int damage, double range) {
        super(name, description);
        this.damage = damage;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public int getDamage() {
        return damage;
    }

    public double getRange() {
        return range;
    }





}
