package memory;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Menu extends MouseAdapter{

    JFrame f=new JFrame();

    Menu(){
        JPanel p=new JPanel();
        p.setLayout(null);

        JLabel title = new JLabel();
        title.setBounds(113, 34, 198, 60);
        p.add(title);
        title.setIcon(new ImageIcon("src/memory/title.png"));

        JLabel start = new JLabel("Start");
        start.setBounds(164, 111, 77, 36);
        p.add(start);

        JLabel credit = new JLabel("Credit");
        credit.setBounds(164, 165, 77, 36);
        p.add(credit);

        JLabel exit = new JLabel("Exit");
        exit.setBounds(164, 215, 77, 36);
        p.add(exit);

        start.addMouseListener(this);
        credit.addMouseListener(this);
        exit.addMouseListener(this);

        f.setBounds(500, 250, 419, 317);
        f.setUndecorated(true);
        f.getContentPane().add(p);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        JLabel l=(JLabel)e.getSource();
        if(l.getText().equals("Start")){
            new GUI();
            f.dispose();
        }
        else if(l.getText().equals("Exit")){
            System.exit(0);
        }
    }


}