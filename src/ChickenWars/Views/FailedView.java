package ChickenWars.Views;

import javax.swing.*;
import java.awt.*;

public class FailedView extends BaseView {
    public FailedView() {
        this.setBackground(Color.white);
    }
    
    @Override
    public void draw(Graphics g) {
       g.setColor(Color.BLACK);
       g.drawString("FAILED", 100, 100);
    }
}
