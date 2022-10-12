public abstract class Weapon extends Item {

    protected int damage;

    public Weapon(String itemName, int damage) {
        super(itemName);
        this.damage = damage;
    }


    public int getDamage() {
        return damage;
    }

    public abstract void useAmmo();

    public abstract Boolean canUse();

    public abstract int getAmmunition();

}
