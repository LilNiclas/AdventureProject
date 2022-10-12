public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String itemName, int damage) {
        super(itemName, damage);
    }

    @Override
    public void useAmmo() {
    }

    public Boolean canUse() {
    return true;
    }

    @Override
    public int getAmmunition() {
        return 0;
    }
}

