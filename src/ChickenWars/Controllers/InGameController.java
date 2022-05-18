package ChickenWars.Controllers;

import ChickenWars.GameStates;
import ChickenWars.Objects.Chicken;
import ChickenWars.Utils.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InGameController extends BaseController {
    private Chicken chicken;
    
    public InGameController() {
        chicken = new Chicken(0, 0);
    }
    
    @Override
    public void controllerKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    GameStates.changeGameState(GameStates.States.INGAME);
                    break;
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
