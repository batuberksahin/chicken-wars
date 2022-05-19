package ChickenWars.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

import ChickenWars.GameObjects;
import ChickenWars.Objects.*;

public class InGameView extends BaseView {
    private BufferedImage background;
    
    public InGameView() {
        this.setBackground(Color.white);
        
        try {
            background = ImageIO.read(new FileImageInputStream(new File("rsc/images/background.png")));
        } catch (IOException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(background,0,0,this);
       
        for (GameObject gameObject:GameObjects.objects) {
            if (gameObject instanceof Chicken) {
                Chicken chicken = (Chicken) gameObject;
                
                if (chicken.isDirectionLeft)
                    g.drawImage(gameObject.objectSprite, gameObject.getPositionX(), gameObject.getPositionY(), this);
                else
                    g.drawImage(chicken.objectSprite, chicken.getPositionX() + chicken.objectSprite.getWidth(), chicken.getPositionY(), -chicken.objectSprite.getWidth(), chicken.objectSprite.getHeight(), this);
                continue;
            }
            
            if (gameObject.isRendering)
                g.drawImage(gameObject.objectSprite, gameObject.getPositionX(), gameObject.getPositionY(), this);
        }
    }
}
