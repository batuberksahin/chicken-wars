package ChickenWars;

import ChickenWars.Utils.Logger;

public class GameStates {
    public static enum States {NOTASSIGN, MENU, INGAME, COMPLETED, FAILED};
    private static States gameState = States.NOTASSIGN;
    
    public static void changeGameState(States newState) {        
        if (gameState == newState) return;
        
        Logger.log("Game state changed " + gameState.toString() + " to " + newState.toString());

        gameState = newState;
    }
    
    public static States getGameState() {
        return gameState;
    }
}
