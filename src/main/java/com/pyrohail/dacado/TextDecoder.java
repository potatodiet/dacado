/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.pyrohail.dacado;

import java.awt.Color;
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
