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
    if (image == null) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    this._thickness = thiccness;
    this._borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x >= this._image.getWidth() + this._thickness || x < 0 - this._thickness) {
      throw new IllegalArgumentException();
    }
    if (y >= this._image.getHeight() + this._thickness || x < 0 - this._thickness) {
      throw new IllegalArgumentException();
    }
    if (x >= this._image.getWidth()) {
      return this._borderColor;
    } else if (y >= this._image.getHeight()) {
      return this._borderColor;
    } else if (x < 0) {
      return this._borderColor;
    } else if (y < 0) {
      return this._borderColor;
    } else {
      return this._image.getPixelColor(x, y);
    }
  }

  @Override
  public int getWidth() {
    return this._image.getWidth() + this._thickness + this._thickness;
  }

  @Override
  public int getHeight() {
    return this._image.getWidth() + this._thickness + this._thickness;
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
