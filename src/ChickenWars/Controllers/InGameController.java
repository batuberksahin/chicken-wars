package ChickenWars.Controllers;

import ChickenWars.GameStates;
import ChickenWars.Objects.*;
import ChickenWars.Utils.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class InGameController extends BaseController {
    private Chicken chicken;
    private Cat cat1;
    private Cat cat2;
    private Dart dart1;
    private Dart dart2;
    
    public InGameController() {
        chicken = new Chicken(300, 50);
        
        Random rand = new Random();
        
        cat1 = new Cat(rand.nextInt(600) + 100, rand.nextInt(300) + 300);
        cat2 = new Cat(rand.nextInt(600) + 100, rand.nextInt(300) + 300);
        dart1 = new Dart(0, 600 + rand.nextInt(150));
        dart2 = new Dart(730, 600 + rand.nextInt(150));
    }
    
    @Override
    public void controllerKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                chicken.setPosition(chicken.getPositionX() - chicken.speed, chicken.getPositionY());
                chicken.isDirectionLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                chicken.setPosition(chicken.getPositionX() + chicken.speed, chicken.getPositionY());
                chicken.isDirectionLeft = false;
                break;
            case KeyEvent.VK_SPACE:
                shoot();
                break;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        
        chicken.setPosition(chicken.getPositionX(), chicken.getPositionY());
        cat1.setPosition(cat1.getPositionX(), cat1.getPositionY() - rand.nextInt(7) - 3);
        cat2.setPosition(cat2.getPositionX(), cat2.getPositionY() - rand.nextInt(7) - 3);
        
        dart1.setPosition(dart1.getPositionX(), dart1.getPositionY() - 2);
        dart2.setPosition(dart2.getPositionX(), dart2.getPositionY() - 2);
        
        if (cat1.getPositionY() < -150) {
            cat1.setPosition(rand.nextInt(500) + 100, rand.nextInt(300) + 600);
        }
        
        if (cat2.getPositionY() < -150) {
            cat2.setPosition(rand.nextInt(500) + 100, rand.nextInt(300) + 600);
        }
        
        if (dart1.getPositionY() < -100) {
            dart1.setPosition(0, rand.nextInt(150) + 600);
        }
        
        if (dart2.getPositionY() < -100) {
            dart2.setPosition(730, rand.nextInt(150) + 600);
        }
    }
    
    private void shoot() {
        
    }
}
