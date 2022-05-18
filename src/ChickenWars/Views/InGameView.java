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
import ChickenWars.Objects.GameObject;

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
       
       g.drawString("DENEME", 100, 100);
       
       for (GameObject gameObject:GameObjects.objects) {
           g.drawImage(gameObject.objectSprite, gameObject.getPositionX(), gameObject.getPositionY(), this);
       }
    }
}
