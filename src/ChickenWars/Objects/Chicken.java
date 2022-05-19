package ChickenWars.Objects;

public class Chicken extends GameObject {
    public int speed = 8;
    public boolean isDirectionLeft = true;
    
    public Chicken(int x, int y) {        
        super(x, y, "rsc/images/chicken.png");
    }
}
