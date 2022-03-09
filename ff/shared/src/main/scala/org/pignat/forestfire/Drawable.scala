package org.pignat.forestfire

trait Drawable {
  def height(): Int

  def width(): Int

  def setPixel(x: Integer, y: Integer, c: Color): Unit

  def drawFilledRect(x: Integer, y: Integer, w: Integer, h: Integer, c: Color)

  def test() = {
    for (x <- 0 until width() / 2; y <- 0 until height() / 2) {
      setPixel(x, y, new Color(0, 0, 0))
    }
    for (x <- width() / 2 until width(); y <- 0 until height() / 2) {
      setPixel(x, y, new Color(255, 0, 0))
    }
    for (x <- 0 until width() / 2; y <- height() / 2 until height()) {
      setPixel(x, y, new Color(0, 255, 0))
    }
    for (x <- width() / 2 until width(); y <- height() / 2 until height()) {
      setPixel(x, y, new Color(0, 0, 255))
    }

    drawFilledRect(10, 10, 10, 10, new Color(255, 255, 255))
    drawFilledRect(20, 20, 10, 10, new Color(255, 255, 255, 127))

  }
}
