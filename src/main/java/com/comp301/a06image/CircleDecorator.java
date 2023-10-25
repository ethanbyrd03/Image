package com.comp301.a06image;

import java.awt.*;

public class CircleDecorator implements Image {

  private Image _image;
  private int _cx;
  private int _cy;
  private int _radius;
  private Color _color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null) {
      throw new IllegalArgumentException();
    }
    if (radius < 0) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    this._cx = cx;
    this._cy = cy;
    this._radius = radius;
    this._color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int a = x - this._cx;
    int b = y - this._cy;
    double aSqr = Math.pow(a, 2);
    double bSqr = Math.pow(b, 2);
    double aPlusB = aSqr + bSqr;
    double dist = Math.sqrt(aPlusB);
    if (dist < this._radius) {
      return this._color;
    } else {
      return this._image.getPixelColor(x, y);
    }
  }

  @Override
  public int getWidth() {
    return this._image.getWidth();
  }

  @Override
  public int getHeight() {
    return this._image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
