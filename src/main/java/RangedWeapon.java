public class RangedWeapon extends Weapon{
    protected int uses;

    public RangedWeapon(String name, String description, int damage, double range, int uses) {
        super(name, description, damage, range);
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public int useWeapon() {
        int x = getUses();
        x--;
        return x;
    }



}
