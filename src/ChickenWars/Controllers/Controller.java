package ChickenWars.Controllers;

import ChickenWars.GameStates;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private BaseController notAssignController;
    private BaseController menuController;  
    private BaseController inGameController;
    private BaseController completedController;
    private BaseController failedController;
    
    public Controller() {
        // Views
        notAssignController = new NotAssignController();
        menuController = new MenuController();
        inGameController = new InGameController();
        completedController = new CompletedController();
        failedController = new FailedController();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        GameStates.States currentGameState = GameStates.getGameState();

        switch (currentGameState) {
            case NOTASSIGN -> notAssignController.controllerKeyPressed(e);
            case MENU -> menuController.controllerKeyPressed(e);
            case INGAME -> inGameController.controllerKeyPressed(e);
            case COMPLETED -> completedController.controllerKeyPressed(e);
            case FAILED -> failedController.controllerKeyPressed(e);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        GameStates.States currentGameState = GameStates.getGameState();

        switch (currentGameState) {
            case NOTASSIGN -> notAssignController.actionPerformed(e);
            case MENU -> menuController.actionPerformed(e);
            case INGAME -> inGameController.actionPerformed(e);
            case COMPLETED -> completedController.actionPerformed(e);
            case FAILED -> failedController.actionPerformed(e);
        }
    }
}

/*

private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    System.out.println("tus");
                    break;
                
            }
        }
    }
*/