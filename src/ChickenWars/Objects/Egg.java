package ChickenWars.Objects;

public class Egg extends GameObject {    
    public boolean isDirectionLeft = true;
    
    public Egg(int x, int y) {        
        super(x, y, "rsc/images/egg.png");
    }
}
