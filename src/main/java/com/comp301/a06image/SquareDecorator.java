package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {

  private Image _image;
  private int _squareX;
  private int _squareY;
  private int _squareSize;
  private Color _color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null) {
      throw new IllegalArgumentException();
    }
    /*if (squareX < 0 || squareX >= image.getWidth()) {
      throw new IllegalArgumentException();
    }
    if (squareY < 0 || squareY >= image.getHeight()) {
      throw new IllegalArgumentException();
    }*/
    if (squareSize < 0) {
      throw new IllegalArgumentException();
    }
    if (color == null) {
      throw new IllegalArgumentException();
    }
    this._image = image;
    this._squareX = squareX;
    this._squareY = squareY;
    this._squareSize = squareSize;
    this._color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x > this._squareX && x < (this._squareX + this._squareSize)) {
      if (y > this._squareY && y < (this._squareY + this._squareSize)) {
        return this._color;
      }
    }
    return this._image.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return this._squareSize += this._squareX;
  }

  @Override
  public int getHeight() {
    return this._squareSize += this._squareY;
  }

  @Override
  public int getNumLayers() {
    return this._image.getNumLayers() + 1;
  }
}
