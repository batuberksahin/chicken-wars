package ChickenWars.Views;

import javax.swing.*;
import java.awt.*;

public class MenuView extends BaseView {
    public MenuView() {
        this.setBackground(Color.black);
    }
    
    @Override
    public void draw(Graphics g) {
       g.setColor(Color.BLACK);
       g.drawString("MENU VIEW", 100, 100);
    }
}
