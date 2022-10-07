public class RangedWeapon extends Weapon{
    protected int uses;

    public RangedWeapon(String name, String description, int damage, double range, int uses) {
        super(name, description, damage, range);
        this.uses = uses;
    }

    public int useWeapon() {
        int x = uses;
        x--;
        return x;
    }



}
