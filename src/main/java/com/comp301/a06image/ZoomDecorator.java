package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {
  private Image _image;
  private int _multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (multiplier <= 0) {
      throw new IllegalArgumentException();
    }
    if (image == null) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    this._multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x >= this.getWidth() || y >= this.getHeight()) {
      throw new IllegalArgumentException();
    }
    int originalX = x / this._multiplier;
    int originalY = y / this._multiplier;
    return this._image.getPixelColor(originalX, originalY);
  }

  @Override
  public int getWidth() {
    return this._image.getWidth() * this._multiplier;
  }

  @Override
  public int getHeight() {
    return this._image.getHeight() * this._multiplier;
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
