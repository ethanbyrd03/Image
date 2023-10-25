package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private Image _image;
  private int _thickness;
  private Color _borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (thiccness < 0) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    this._thickness = thiccness;
    this._borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x >= this._image.getWidth()
        && x < this._image.getWidth() + this._thickness
        && y >= this._image.getHeight()
        && y < this._image.getHeight() + this._thickness) {
      return this._borderColor;
    } else {
      return this._image.getPixelColor(x, y);
    }
  }

  @Override
  public int getWidth() {
    return this._image.getWidth() + this._thickness;
  }

  @Override
  public int getHeight() {
    return this._image.getWidth() + this._thickness;
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
