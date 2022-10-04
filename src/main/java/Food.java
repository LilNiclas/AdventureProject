public class Food extends Item {

    public int healthPoints;

    public Food(int healthPoints, String name, String description ) {
        super(name, description);
        this.healthPoints = healthPoints;
    }



}
