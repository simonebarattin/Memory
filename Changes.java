package memory;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by simone on 26/04/16.
 */
class Changes extends MouseAdapter {
    Card c1,c2;
    static Card select;
    JLabel score,err;
    int er;
    JFrame f;

    public Changes(JLabel score, JLabel err,JFrame f) {
        this.err=err;
        this.score=score;
        this.f=f;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if(c1==null && c2==null) {
            c1 = (Card) e.getSource();
            c1.turn();
            c1.repaint();
        }
        if(c1!=null && c1!=(Card)e.getSource() && c2==null){
            c2 = (Card) e.getSource();
            c2.turn();
            c2.repaint();
            GUI.t.start();
        }

    }

    public void check(){
        if(c1.getId()==c2.getId()){
            c1.setMatch(true);
            c2.setMatch(true);
            if(GUI.gameWon()){
                int a = JOptionPane.showConfirmDialog(null,"Hai vinto! Vuoi rigiocare?","Winner",0);
                if(a==JOptionPane.NO_OPTION)
                    System.exit(0);
                else{
                    f.dispose();
                    new GUI();
                }
            }
        }
        else{
            c1.turn();
            c1.repaint();
            c2.turn();
            c2.repaint();
            er++;
            if(er==2){
                int a = JOptionPane.showConfirmDialog(null,"Hai perso.. Vuoi rigiocare?","Looser",0);
                if(a==JOptionPane.NO_OPTION)
                    System.exit(0);
                else{
                    f.dispose();
                    new GUI();
                }
            }
        }
        c1=null;
        c2=null;
    }
}
