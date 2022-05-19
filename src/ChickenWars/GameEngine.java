package ChickenWars;

import ChickenWars.Controllers.*;
import ChickenWars.Utils.Logger;
import ChickenWars.Views.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameEngine extends JFrame implements ActionListener {
    private Controller controller;
    private Viewer viewer;
    private Timer timer;
    
    public GameEngine(int width, int height) {
        // Constructors
        this.setTitle("ChickenWars");
                
        viewer = new Viewer(width, height);
        controller = new Controller();
                
        addViewToFrame();
        addControllerToFrame();

        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        timer = new Timer(1, this);
        timer.start();
        
        Logger.log("Graphic Window opened!");
    }

    private void addViewToFrame() {
        this.add(viewer);
    }

    private void addControllerToFrame() {
        this.addKeyListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.actionPerformed(e);
        
        repaint();
    }
}
