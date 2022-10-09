public class RangedWeapon extends Weapon{
    protected int ammunition;

    public RangedWeapon(String name, String description, int damage, double range, int ammunition) {
        super(name, description, damage, range);
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void ammoUse() {
        ammunition--;
    }



}
