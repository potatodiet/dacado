/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.pyrohail.dacado;

import java.awt.image.BufferedImage;

/**
 * Enables object to encode data into an image.
 * @author Justin Harrison
 * @since 0.1
 */
public interface Encodable {

    /**
     * Getter for encodedImage.
     * @return Image which contains encoded image.
     */
    BufferedImage getEncodedImage();
}
