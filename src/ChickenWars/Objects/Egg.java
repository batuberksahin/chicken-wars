package ChickenWars.Objects;

public class Egg extends GameObject {    
    public boolean isDirectionLeft = true;
    public boolean isCollided = false;
    
    public Egg(int x, int y) {        
        super(x, y, "rsc/images/egg.png");
    }
}
