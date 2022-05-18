package ChickenWars.Views;

import javax.swing.*;
import java.awt.*;

public class NotAssignView extends BaseView {
    public NotAssignView() {
        this.setBackground(Color.black);
    }
    
    @Override
    public void draw(Graphics g) {
       g.setColor(Color.BLACK);
       g.drawString("NOT ASSIGN", 100, 100);
    }
}
