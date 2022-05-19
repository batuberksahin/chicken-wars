package ChickenWars.Controllers;

import ChickenWars.GameObjects;
import ChickenWars.GameStates;
import ChickenWars.Objects.*;
import ChickenWars.Utils.Logger;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class InGameController extends BaseController {    
    public int levelScoreCount = 0;
    
    private LevelText levelText;
    private Chicken chicken;
    private Cat cat1;
    private Cat cat2;
    private Dart dart1;
    private Dart dart2;
    
    public InGameController() {
        chicken = new Chicken(300, 50);
        
        levelScoreCount = 3 + (GameStates.level * 2);

        levelText = new LevelText(0, 0);
        levelText.isRendering = false;
        levelText.currentText = levelScoreCount - chicken.levelScore;
        
        Random rand = new Random();
        
        cat1 = new Cat(rand.nextInt(600) + 100, rand.nextInt(800) + 450);
        cat2 = new Cat(rand.nextInt(600) + 100, rand.nextInt(800) + 450);
        dart1 = new Dart(0, 400 + rand.nextInt(650));
        dart2 = new Dart(730, 400 + rand.nextInt(900));
    }
    
    public void resetGame() {
        GameObjects.objects = new ArrayList<>();
        
        chicken = new Chicken(300, 50);
        
        levelScoreCount = 3 + (GameStates.level * 2);

        levelText = new LevelText(0, 0);
        levelText.isRendering = false;
        levelText.currentText = levelScoreCount - chicken.levelScore;
        
        Random rand = new Random();
        
        cat1 = new Cat(rand.nextInt(600) + 100, rand.nextInt(800) + 450);
        cat2 = new Cat(rand.nextInt(600) + 100, rand.nextInt(800) + 450);
        dart1 = new Dart(0, 400 + rand.nextInt(650));
        dart2 = new Dart(730, 400 + rand.nextInt(900));
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
        cat1.setPosition(cat1.getPositionX(), cat1.getPositionY() - rand.nextInt(2 * (GameStates.level + 1)) - 2);
        cat2.setPosition(cat2.getPositionX(), cat2.getPositionY() - rand.nextInt(2 * (GameStates.level + 1)) - 2);
        
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
        
        for (GameObject gameObject:GameObjects.objects) {
            if (gameObject instanceof Egg) {
                Egg egg = (Egg) gameObject;
                
                egg.setPosition(egg.getPositionX() + (egg.isDirectionLeft ? -10 : 10), egg.getPositionY());
            }
        }
        
        checkDartColissions();
        checkChickenColissions();
    }
    
    private void shoot() {
        Egg egg;
        
        if (chicken.isDirectionLeft) {
            egg = new Egg(chicken.getPositionX() + 10, chicken.getPositionY() + 20);
            egg.isDirectionLeft = true;
        } else {
            egg = new Egg(chicken.getPositionX() + chicken.objectSprite.getWidth() - 10, chicken.getPositionY() + 20);
            egg.isDirectionLeft = false;
        }
    }

    private void checkDartColissions() {
        for (GameObject gameObject:GameObjects.objects) {
            if (gameObject instanceof Egg) {
                Egg egg = (Egg) gameObject;
                
                for (GameObject controlGameObject:GameObjects.objects) {
                    if (controlGameObject instanceof Dart) {
                        Dart dart = (Dart) controlGameObject;
                        
                        if (new Rectangle(egg.getPositionX(), egg.getPositionY(), egg.objectSprite.getWidth(), egg.objectSprite.getHeight()).intersects(
                        new Rectangle(dart.getPositionX(), dart.getPositionY(), dart.objectSprite.getWidth(), dart.objectSprite.getHeight()))) {
                            if (egg.isCollided) return;

                            Random rand = new Random();

                            egg.isCollided = true;
                            egg.isRendering = false;

                            dart.setPosition(dart.getPositionX(), rand.nextInt(150) + 600);

                            chicken.levelScore++;
                            levelText.currentText = levelScoreCount - chicken.levelScore;
                            
                            if (levelText.currentText == 0) {
                                GameStates.changeGameState(GameStates.States.COMPLETED);
                                resetGame();
                            }
                            
                        }
                    }
                }
            }
        }
    }

    private void checkChickenColissions() {
        for (GameObject gameObject:GameObjects.objects) {
            if (gameObject instanceof Cat) {
                Cat cat = (Cat) gameObject;
                
                if (new Rectangle(cat.getPositionX(), cat.getPositionY(), cat.objectSprite.getWidth() / 2, cat.objectSprite.getHeight() / 2).intersects(
                        new Rectangle(chicken.getPositionX(), chicken.getPositionY(), chicken.objectSprite.getWidth() / 2, chicken.objectSprite.getHeight() / 2))) {
                    
                    GameStates.changeGameState(GameStates.States.FAILED);
                    resetGame();
                }
            }
        }
    }
    
}
