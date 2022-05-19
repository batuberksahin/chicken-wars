package ChickenWars;

import ChickenWars.Utils.Logger;

public class GameStates {
    public static enum States {NOTASSIGN, MENU, INGAME, COMPLETED, FAILED};
    private static States gameState = States.NOTASSIGN;
    
    private static int level;
    
    public static void changeGameState(States newState) {        
        if (gameState == newState) return;
        if (newState == States.COMPLETED)
            level++;
        
        Logger.log("Game state changed " + gameState.toString() + " to " + newState.toString());

        gameState = newState;
    }
    
    public static States getGameState() {
        return gameState;
    }
}
