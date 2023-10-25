package com.comp301.a06image;

import java.awt.*;

public class SolidColorImage implements Image {

  private int _width;
  private int _height;
  private Color _color;

  public SolidColorImage(int width, int height, Color color) {
    this._width = width;
    this._height = height;
    this._color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x > this._width) {
      throw new IllegalArgumentException();
    }
    if (y < 0 || y > this._height) {
      throw new IllegalArgumentException();
    }
    return this._color;
  }

  @Override
  public int getWidth() {
    return this._width;
  }

  @Override
  public int getHeight() {
    return this._height;
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
