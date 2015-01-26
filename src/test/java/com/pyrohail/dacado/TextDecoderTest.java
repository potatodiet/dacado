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

public class TextDecoderTest extends TestCase {
  private final TextDecoder textDecoder;
  private static final String DECODED_TEXT = "Just a test.";
  
  public TextDecoderTest() {
    BufferedImage encodedImage = null;
    try {
      encodedImage = ImageIO.read(new File(getClass().getResource("/image/text.png").toURI()));
    } catch (URISyntaxException | IOException e) {
      System.exit(1);
      e.printStackTrace();
    }
    textDecoder = new TextDecoder(encodedImage);
  }
  
  public void testGetText() {
    assertEquals(textDecoder.getText(), DECODED_TEXT);
  }
}
