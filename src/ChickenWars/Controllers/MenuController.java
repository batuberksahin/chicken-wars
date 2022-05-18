package ChickenWars.Controllers;

import ChickenWars.GameStates;
import ChickenWars.Utils.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuController extends BaseController {
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
