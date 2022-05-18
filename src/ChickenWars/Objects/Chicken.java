package ChickenWars.Objects;

public class Chicken extends GameObject {
    public int speed = 10;
    
    public Chicken(int x, int y) {        
        super(x, y, "rsc/images/chicken.png");
    }
}
