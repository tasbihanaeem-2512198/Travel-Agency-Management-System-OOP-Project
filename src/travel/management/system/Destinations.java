package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    Thread tl;
    JLabel[] label = new JLabel[9];   // ✅ only 9 images
    JLabel caption;

    public void run() {
      

        try {
            for (int i = 0; i < 9; i++) {
                label[i].setVisible(true);
                //caption.setText(text[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {

        setBounds(500, 200, 800, 600);
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.BOLD, 30));
        caption.setForeground(Color.WHITE);
        add(caption);

        for (int i = 0; i < 9; i++) {

            // ✅ Load image safely
            java.net.URL url = ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg");

            if (url == null) {
                System.out.println("Image not found: dest" + (i + 1));
                continue;
            }

            ImageIcon image = new ImageIcon(url);
            Image scaled = image.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            ImageIcon finalImage = new ImageIcon(scaled);

            label[i] = new JLabel(finalImage);
            label[i].setBounds(0, 0, 800, 600);
            label[i].setVisible(false);

            add(label[i]);
        }

        tl = new Thread(this);
        tl.start();

        setVisible(true);
    }

    public static void main(String args[]) {
        new Destinations();
    }
}