/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at http://mozilla.org/MPL/2.0/. 
 */

package com.pyrohail.dacado;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class TextDecoderTest {
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
  
  @Test
  public void testGetText() {
    assertEquals(textDecoder.getText(), DECODED_TEXT);
  }
}
