package com.pyrohail.dacado;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Justin Harrison
 * @since 0.1
 */
public final class TextDecoder implements Decodable {
    private final String text;

    public TextDecoder(final BufferedImage encodedImage) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < encodedImage.getWidth(); ++x) {
            for (int y = 0; y < encodedImage.getHeight(); ++y) {
                final Color color = new Color(encodedImage.getRGB(x, y));
                stringBuilder.append((char) color.getRed());
                stringBuilder.append((char) color.getGreen());
                stringBuilder.append((char) color.getBlue());
            }
        }

        final int indexOfNull = stringBuilder.indexOf("null");
        if (indexOfNull != -1) {
            stringBuilder.delete(indexOfNull, stringBuilder.length() + 1);
        }

        text = stringBuilder.toString();
    }

    @Override
    public String getText() {
        return text;
    }
}
