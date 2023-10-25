package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private final Image _image;
  private static int _thickness;
  private final Color _borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (thiccness < 0) {
      throw new IllegalArgumentException();
    }
    if (image == null) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    _thickness = thiccness;
    this._borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
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
    int a = 2 * _thickness;
    return this._image.getWidth() + a;
  }

  @Override
  public int getHeight() {
    int a = 2 * _thickness;
    return this._image.getWidth() + a;
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
