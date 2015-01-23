package com.pyrohail.dacado;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Justin Harrison
 * @since 0.1
 */
public final class BinaryDecoder implements Decodable {
    private final String text;

    public BinaryDecoder(final BufferedImage encodedImage) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < encodedImage.getWidth(); ++x) {
            for (int y = 0; y < encodedImage.getHeight(); ++y) {
                final Color color = new Color(encodedImage.getRGB(x, y));
                stringBuilder.append((char) color.getRed());
                stringBuilder.append((char) color.getGreen());
                stringBuilder.append((char) color.getBlue());
            }
        }
        text = stringBuilder.toString();
    }

    @Override
    public String getText() {
        return text;
    }
}
