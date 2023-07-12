package org.example;

import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Window extends JFrame {
    public Window() {
        try {
            URL image = getClass().getClassLoader().getResource("hila.jpg");// להכניס קובץ של התמונה
            if (image != null) {
                BufferedImage bufferedImage = ImageIO.read(image);// מחזיק את הרולזציה של התמונה
                this.setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
                int color = bufferedImage.getRGB(0, 0);
                Color colorObject = new Color(color);
                System.out.println("RED:" + colorObject.getRed());
                System.out.println("BLUE:" + colorObject.getBlue());
                System.out.println("GREEN:" + colorObject.getGreen());
                JLabel label = new JLabel(new ImageIcon(bufferedImage));
                this.add(label);
            } else {
                System.out.println("Cannot find!");
            }
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isBlackish(Color color) {
        return color.getGreen() + color.getBlue() + color.getRed() < 30;
    }

    public BufferedImage mirror(BufferedImage original) {
        BufferedImage processed = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < original.getHeight() - 2; i++) {
            for (int j = 0; j < original.getWidth() - 2; j++) {
                int col = original.getRGB(i, j);
                int colN = original.getRGB(i + 1, j + 1);
                Color color = new Color(col);
                Color colorN = new Color(colN);

            }
        }
        return processed;
    }

    private boolean isBigAverage(Color one, Color second) {
        boolean result = false;
        if (Math.abs((one.getBlue() + one.getGreen() + one.getRed()) / 3 - (second.getBlue() + second.getGreen() + second.getRed()) / 3) > 50)
            result = true;

        return result;
    }

    public BufferedImage borders(BufferedImage original) {
        BufferedImage processed = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_INT_RGB);
        return processed;
    }


    private boolean isDifferent(Color color1, Color color2) {
        int rgb1 = color1.getRed() + color1.getGreen() + color1.getBlue();
        int rgb2 = color2.getRed() + color2.getGreen() + color2.getBlue();
        return false;
    }

}
