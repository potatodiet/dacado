package com.pyrohail.dacado;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Justin Harrison
 * @since 0.1
 */
public final class Decoder implements Decodable {
    private String text;

    public Decoder(final String location) {
        try {
            final BufferedImage encodedImage = ImageIO.read(new File(location));

            final int format = new Color(encodedImage.getRGB(0, 0)).getBlue();
            switch (format) {
                case 0:
                    text = new TextDecoder(encodedImage).getText();
                    break;

                case 1:
                    text = new BinaryDecoder(encodedImage).getText();
                    break;

                default:
                    System.out.println("No format found");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }
}
