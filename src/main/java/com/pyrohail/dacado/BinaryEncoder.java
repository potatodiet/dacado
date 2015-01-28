/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.pyrohail.dacado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Encodes binary data into an image.
 * @author Justin Harrison
 * @since 0.1
 */
public final class BinaryEncoder implements Encodable {
  private BufferedImage encodedImage;

  /**
   * Constructor.
   * @param binary Binary data to be encoded.
   */
  public BinaryEncoder(String binary) {
    while (0 != binary.length() % 3) {
      binary += null;
    }

    final Dimension dimension = calculateDimension(binary.length());
    encodedImage = new BufferedImage(
        (int) dimension.getWidth(),
        (int) dimension.getHeight(),
        BufferedImage.TYPE_INT_RGB
    );

    encodedImage.setRGB(0, 0, Format.TYPE_INT_Binary);

    int pixelPos = 0;
    for (int i = 0; i < binary.length(); i += 3) {
      pixelPos++;
      encodedImage.setRGB(pixelPos, 0, new Color(binary.charAt(i),
                                                 binary.charAt(i + 1),
                                                 binary.charAt(i + 2)).getRGB());
    }
  }

  /**
   * Constructor.
   * @param bytes Binary data to be encoded.
   */
  public BinaryEncoder(byte[] bytes) {
    while (0 != bytes.length % 3) {
      bytes = Arrays.copyOf(bytes, bytes.length + 1);
    }

    final Dimension dimension = calculateDimension(bytes.length);
    encodedImage = new BufferedImage(
        (int) dimension.getWidth(),
        (int) dimension.getHeight(),
        BufferedImage.TYPE_3BYTE_BGR
    );

    encodedImage.setRGB(0, 0, Format.TYPE_INT_Binary);

    int pixelPos = 0;
    for (int i = 0; i < bytes.length; i += 3) {
      pixelPos++;
      encodedImage.setRGB(pixelPos, 0, new Color(
          bytes[i],
          bytes[i + 1],
          bytes[i + 2]).getRGB()
      );
    }
  }
  
  /**
   * Calculates needed rectangular size of encoded image.
   * @param binaryLength Length of text to be encoded.
   * @return Rectangular size of encoded image.
   */
  private Dimension calculateDimension(final int binaryLength) {
    final Dimension dimension = new Dimension();
    // Add one so first pixel can hold data type. e.g. text, or binary
    dimension.setSize(binaryLength + 1, 1);
    return dimension;
  }

  @Override
  public BufferedImage getEncodedImage() {
    return encodedImage;
  }
}
