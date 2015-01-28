/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.pyrohail.dacado;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Decodes image which contains encoded binary data.
 * @author Justin Harrison
 * @since 0.1
 */
public final class BinaryDecoder implements Decodable {
  private final String text;

  /**
   * Constructor.
   * @param encodedImage Image which contains encoded binary data.
   */
  public BinaryDecoder(final BufferedImage encodedImage) {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int x = 0; x < encodedImage.getWidth(); ++x) {
      for (int y = 0; y < encodedImage.getHeight(); ++y) {
        final Color color = new Color(encodedImage.getRGB(x, y));
        stringBuilder.append(Integer.toString(color.getRed(), 2));
        stringBuilder.append(Integer.toString(color.getGreen(), 2));
        stringBuilder.append(Integer.toString(color.getBlue(), 2));
      }
    }

    // Remove leading format identifier.
    stringBuilder.delete(0, 3);

    while (true) {
      final int lastOne = stringBuilder.indexOf("1", stringBuilder.length() - 6);
      if (lastOne == -1) {
        stringBuilder.delete(stringBuilder.length() - 6, stringBuilder.length() + 1);
      } else {
        break;
      }
    }

    text = stringBuilder.toString();
  }

  @Override
  public String getText() {
    return text;
  }
}
