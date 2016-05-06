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
    Changes ch=new Changes(score,err,f);
    Vector<Integer> nope;
    static Card[] cards=new Card[3];
    String path[]={"src/memory/img1.jpg","src/memory/img2.jpg","src/memory/img3.jpg"};
    GUI(){
        f.addWindowListener(this);
        try{
            Clip clip;
            File f=new File("/home/simone/Scaricati/audioclip-1461697928.wav");
            AudioInputStream a=AudioSystem.getAudioInputStream(f);
            clip=AudioSystem.getClip();
            clip.open(a);
            clip.start();

        }catch(UnsupportedAudioFileException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (LineUnavailableException e){
            e.printStackTrace();
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(200,0,1000,710);
        c.setLayout(null);
        x=0;
        y=50;
        for(int i=0;i<2;i++) {
            nope=new Vector<>();
            for (int j = 0; j <= 2; j++) {
                rand = (int) (Math.random() * 3);
                while (nope.contains(rand)){
                    rand = (int) (Math.random() * 3);
                }
                nope.addElement(rand);
                cards[j] = new Card(path[rand],rand);
                cards[j].setBounds(x += 100, y, cards[j].getWidth(), cards[j].getHeight());
                x += 200;
                cards[j].addMouseListener(ch);
                c.add(cards[j]);
            }
            x=0;
            y=100+cards[0].getHeight();
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
