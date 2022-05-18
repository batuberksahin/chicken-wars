package ChickenWars.Views;

import javax.swing.*;
import java.awt.*;
import ChickenWars.*;

public class Viewer extends JPanel {
    private BaseView notAssignView;
    private BaseView menuView;  
    private BaseView inGameView;
    private BaseView completedView;
    private BaseView failedView;
    
    public Viewer(int width, int height) {
        // Views
        notAssignView = new NotAssignView();
        menuView = new MenuView();
        inGameView = new InGameView();
        completedView = new CompletedView();
        failedView = new FailedView();
        
        this.setPreferredSize(new Dimension(width, height));

    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        draw(g);
    }
    
    private void draw(Graphics g) {
       GameStates.States currentGameState = GameStates.getGameState();

        switch (currentGameState) {
            case NOTASSIGN -> notAssignView.draw(g);
            case MENU -> menuView.draw(g);
            case INGAME -> inGameView.draw(g);
            case COMPLETED -> completedView.draw(g);
            case FAILED -> failedView.draw(g);
        }
    }
}
