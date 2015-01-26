/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.pyrohail.dacado;

import java.awt.image.BufferedImage;

/**
 * Small utility methods which don't yet have a home.
 * @author Justin Harrison
 * @since 0.1
 */
abstract class Utility {

  /**
   * Prevent initialization.
   */
  private Utility() {
    throw new UnsupportedOperationException();
  }

  
  protected static boolean compareImages(final BufferedImage firstImage, final BufferedImage secondImage) {
    if (firstImage.getHeight() != secondImage.getHeight() || firstImage.getWidth() != secondImage.getWidth()) {
      return false;
    }

    for (int x = 0; x < firstImage.getWidth(); ++x) {
      for (int y = 0; y < firstImage.getHeight(); ++y) {
        if (firstImage.getRGB(x, y) != secondImage.getRGB(x, y)) {
          return false;
        }
      }
    }

    return true;
  }
}
