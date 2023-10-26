package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private final Image _image;
  private int _thickness;
  private final Color _borderColor;
  private Image _border;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (thiccness < 0) {
      throw new IllegalArgumentException();
    }
    if (image == null) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    this._thickness = thiccness;
    this._borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x > this.getWidth() || y > this.getHeight() || x < 0 || y < 0) {
      throw new IllegalArgumentException();
    }
    if (x < _thickness
        || x >= this._image.getWidth() + _thickness
        || y < _thickness
        || y >= this._image.getHeight() + _thickness) {
      return this._borderColor;
    } else {
      return this._image.getPixelColor(x - _thickness, y - _thickness);
    }
  }

  @Override
  public int getWidth() {
    return (_thickness + this._image.getWidth() + _thickness);
  }

  @Override
  public int getHeight() {
    return (_thickness + this._image.getHeight() + _thickness);
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
