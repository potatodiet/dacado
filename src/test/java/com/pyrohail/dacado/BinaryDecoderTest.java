/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.pyrohail.dacado;

import junit.framework.TestCase;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import junit.runner.Version;

public final class BinaryDecoderTest extends TestCase {
  private final BinaryDecoder binaryDecoder;
  private static final String DECODED_BINARY = "0110100001100101011011000110110001101111";

  public BinaryDecoderTest() {
    BufferedImage encodedImage = null;
    try {
      encodedImage = ImageIO.read(new File(getClass().getResource("/image/binary.png").toURI()));
    } catch (URISyntaxException | IOException e) {
      System.exit(1);
      e.printStackTrace();
    }
    binaryDecoder = new BinaryDecoder(encodedImage);
    System.out.println(Version.id());
  }

  public void testGetText() {
    assertEquals(binaryDecoder.getText(), DECODED_BINARY);
  }
}
