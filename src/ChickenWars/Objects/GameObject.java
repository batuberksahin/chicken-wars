package ChickenWars.Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import ChickenWars.GameObjects;

public class GameObject {
    public int x, y;
    
    public BufferedImage objectSprite;
    
    public GameObject(int xx, int yy, String location) {
        setPosition(xx, yy);
        
        try {
            objectSprite = ImageIO.read(new FileImageInputStream(new File(location)));
        } catch (IOException ex) {
            Logger.getLogger("Object").log(Level.SEVERE, null, ex);
        }
        
        GameObjects.objects.add(this);
        
        ChickenWars.Utils.Logger.log(location + " sprite is loaded!");
    } 
    
    public final void setPosition(int xx, int yy) {
        x = xx;
        y = yy;
    }
    
    public int getPositionX() {
        return x;
    }
    
    public int getPositionY() {
        return x;
    }
}
