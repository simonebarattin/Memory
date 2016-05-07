package memory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by simone on 26/04/16.
 */
class Card extends JPanel {
    static int width=200,heigth=280;
    static int x,y;
    boolean  state=false, match=false;
    int id;
    String front,back="src/memory/back.jpg";
    Card(String path, int id){
        this.id=id;
        front=path;
    }

    void turn(){
        if(state) {
            state = false;
        }
        else {
            state = true;
        }
    }

    public void setFront(String front) {
        this.front = front;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return heigth;
    }

    public int getId() {
        return id;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public boolean getMatch() {
        return match;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = null;
        if(state) {
            try {
                img = ImageIO.read(new File(front));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
        else{
            try {
                img = ImageIO.read(new File(back));
            } catch (IOException e) {
            }
            g.drawImage(img, 0, 0, null);
        }
    }
}
