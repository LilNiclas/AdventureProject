public class RangedWeapon extends Weapon{
    protected int ammunition;

    public RangedWeapon(String itemName, int damage, int ammunition) {
        super(itemName, damage);
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
    }

    @Override
    public void useAmmo() {
        ammunition--;
    }
}
