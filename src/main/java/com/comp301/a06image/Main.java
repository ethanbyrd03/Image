package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    Image img = new PictureImage("img/kmp.jpg");
    Image imgR = new BorderDecorator(img, 5, new Color(255, 0, 0));
    Image imgB = new BorderDecorator(imgR, 50, new Color(0, 0, 255));
    Image imgYC = new CircleDecorator(imgB, 50, 50, 40, new Color(255, 255, 0));
    Image imgOS = new SquareDecorator(imgYC, 100, 100, 40, new Color(200, 80, 10));
    Image imgZ = new ZoomDecorator(imgOS);
    return imgZ;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
