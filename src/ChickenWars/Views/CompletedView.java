package ChickenWars.Views;

import javax.swing.*;
import java.awt.*;

public class CompletedView extends BaseView {
    public CompletedView() {
        this.setBackground(Color.white);
    }
    
    @Override
    public void draw(Graphics g) {
       g.setColor(Color.BLACK);
       g.drawString("COMPLETED", 100, 100);
    }
}
