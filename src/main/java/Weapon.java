public abstract class Weapon extends Item {

    protected int damage;


    public Weapon(String itemName, int damage) {
        super(itemName);
        this.damage = damage;
    }

    //public String getName()

    public int getDamage() {
        return damage;
    }

    public abstract void useAmmo();





}
