/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.pyrohail.dacado;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author Justin Harrison
 * @since 0.1
 */
public final class Main {

  public static void main(final String[] args) {
    final TextEncoder textEncoder = new TextEncoder("Just a test.");
    final BinaryEncoder binaryEncoder = new BinaryEncoder("0110100001100101011011000110110001101111");

    try {
      ImageIO.write(textEncoder.getEncodedImage(), "PNG", new File("text.png"));
      ImageIO.write(binaryEncoder.getEncodedImage(), "PNG", new File("binary.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    final Decoder decoder1 = new Decoder("text.png");
    System.out.println(decoder1.getText());

    final Decoder decoder2 = new Decoder("binary.png");
    System.out.println(decoder2.getText());
  }
}
