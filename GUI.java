package memory;

/**
 * Created by simone on 26/04/16.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.sound.sampled.*;

/**
 * Created by simone on 07/04/16.
 */
class GUI extends WindowAdapter{
    JFrame f=new JFrame();
    JPanel c=new JPanel();
    public static Timer t;
    int rand,x,y;
    JLabel score=new JLabel("score");
    static JLabel err=new JLabel("errors");
    Logic ch=new Logic(score,err,f);
    Vector<Integer> nope;
    static Card[] cards=new Card[3];
    String path[]={"src/memory/img1.jpg","src/memory/img2.jpg","src/memory/img3.jpg"};
    int i1[]={0,1,2,0,1,2};

    GUI(){
        f.addWindowListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(200,0,800,655);
        c.setLayout(null);
        x=0;
        y=20;
        for(int i=0;i<2;i++) {
            for (int j = 0; j <= 2; j++) {
                rand = (int) (Math.random() * 6);
                System.out.print(rand);
                System.out.println(i1[rand]);
                while (i1[rand]==-1){
                    rand = (int) (Math.random() * 6);
                    System.out.println(rand);
                }
                cards[j] = new Card(path[i1[rand]],i1[rand]);
                cards[j].setBounds(x += 50, y, cards[j].getWidth(), cards[j].getHeight());
                x += 200;
                cards[j].addMouseListener(ch);
                c.add(cards[j]);
                i1[rand]=-1;
            }
            x=0;
            y=50+cards[0].getHeight();
            f.add(c);
        }
        t = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ch.check();
            }
        });

        t.setRepeats(false);
    }

    static boolean gameWon() {
        for(int i=0;i<3;i++)
            if(cards[i].getMatch()==false)
                return false;
        return true;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        int a = JOptionPane.showConfirmDialog(null,"Vuoi uscire?","Exit",0);
        if(a==JOptionPane.YES_OPTION)
            System.exit(0);

    }
}
