package com.comp301.a06image;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PictureImage implements Image {

  private BufferedImage picture;

  public PictureImage(String pathname) throws IOException {
    BufferedImage image;
    Path picPath = Paths.get(pathname);
    ImageInputStream is = ImageIO.createImageInputStream(picPath);
    Iterator<ImageReader> iter = ImageIO.getImageReaders(is);
    ImageReader imageReader = (ImageReader) iter.next();
    imageReader.setInput(is);
    image = imageReader.read(0);
    this.picture = image;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x > this.picture.getWidth()) {
      throw new IllegalArgumentException();
    }
    if (y < 0 || y > this.picture.getHeight()) {
      throw new IllegalArgumentException();
    }
    int rgb = this.picture.getRGB(x, y);
    Color pixel = new Color(rgb);
    return pixel;
  }

  @Override
  public int getWidth() {
    return this.picture.getWidth();
  }

  @Override
  public int getHeight() {
    return this.picture.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
