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

public class BinaryEncoderTest extends TestCase {
  private final BinaryEncoder binaryEncoder;
  private BufferedImage encodedImage;
  
  public BinaryEncoderTest() {
    binaryEncoder = new BinaryEncoder("0110100001100101011011000110110001101111");

    try {
      encodedImage = ImageIO.read(new File(getClass().getResource("/image/binary.png").toURI()));
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }
  
  public void testGetEncodedImage() {
    assertTrue(Utility.compareImages(binaryEncoder.getEncodedImage(), encodedImage));
  }
}
