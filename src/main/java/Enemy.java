public class Enemy {

    private String name;
    private int health;
    private Room room;
    private Weapon currentWeapon;
    private Food food;

    public Enemy(String name, int health, Weapon currentWeapon) {
        this.name = name;
        this.health = health;
        this.currentWeapon = currentWeapon;
    }

    public Enemy(String name, int health, Weapon currentWeapon, Food food) {
        this.name = name;
        this.health = health;
        this.currentWeapon = currentWeapon;
        this.food = food;
    }



    public String getName() {
        return name;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean enemyDeath() {
        if (health <= 0) {
            room.addEnemyItem(currentWeapon);
            room.removeEnemy(name);
            return true;
        } else {
            return false;
        }
    }

    public void currentHealth(int damage) {
        health -= damage;
    }


    @Override
    public String toString() {
        return name + health;
    }

}


