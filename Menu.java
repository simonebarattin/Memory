package memory;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Menu extends JPanel implements ActionListener{
    JLabel title = new JLabel();
    JButton start = new JButton("Start");
    JButton credit = new JButton("Credit");
    JButton exit = new JButton("Exit");
    static JFrame f = new JFrame();
    private Image img;

    public Menu() {
        setLayout(null);

        title.setBounds(113, 34, 198, 60);
        add(title);
        title.setIcon(new ImageIcon("src/memory/title.png"));

        start.setBounds(164, 111, 77, 36);
        add(start);

        credit.setBounds(164, 165, 77, 36);
        add(credit);

        exit.setBounds(164, 215, 77, 36);
        add(exit);

        start.addActionListener(this);
        credit.addActionListener(this);
        exit.addActionListener(this);

        img = Toolkit.getDefaultToolkit().createImage("src/memory/frame.jpg");
        loadImage(img);
    }

    private void loadImage(Image img) {
        try {
            MediaTracker track = new MediaTracker(this);
            track.addImage(img, 0);
            track.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        setOpaque(false);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    public static void main(String... argv) {
        Menu back = new Menu();
        f.getContentPane().add(back);
        f.setBounds(500, 250, 419, 317);
        f.setUndecorated(true);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton l = (JButton) e.getSource();
        if (l.getText().equals("Start")) {
            f.dispose();
            new GUI();
        } else if (l.getText().equals("Exit")) {
            System.exit(0);
        }
    }

}
