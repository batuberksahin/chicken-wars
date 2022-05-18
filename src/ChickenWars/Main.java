package ChickenWars;

import ChickenWars.Utils.Logger;

public class Main {
    public static void main(String[] args) {        
        new GameEngine(800, 600);
        GameStates.changeGameState(GameStates.States.MENU);
        
        Logger.log("Game started!");
    }
}
